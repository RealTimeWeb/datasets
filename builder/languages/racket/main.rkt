#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require net/url)
(require "sticky-web.rkt")

; Provide the external structs
(provide 
{%- for object in objects %}
    (struct-out {{ object.name | kebab_case }})
{%- endfor -%}
{%- for function in functions %}
    {{ function.name | kebab_case }}
{%- endfor %}
    connect-{{metadata.name | kebab_case}}
    disconnect-{{metadata.name | kebab_case}})

; Define the structs
{% for object in objects %}
(define-struct {{ object.name | kebab_case }}
    ({%- for field in object.fields %} {{ field.name | kebab_case }}{%- endfor -%}))
{% endfor %}

{% for object in objects %}
(define (json->{{object.name | kebab_case}} jdata)
    (make-{{object.name | kebab_case}}
        {% if object.format == "json" -%}
        {% for field in object.fields -%}
        {% if field.type | is_builtin -%}
        {{ field.path | parse_json_path }}
        {% else -%}
        {% if field.type | is_list -%}
        (map json->{{ field.type | strip_list | kebab_case }} {{ field.path | parse_json_path }})
        {% else -%}
        (json->{{ field.type | kebab_case }} {{ field.path | parse_json_path }})
        {% endif -%}
        {% endif -%}
        {%- endfor -%}
        {% elif object.format in ("html", "xml") -%}
        {% for field in object.fields -%}
        {{ field.path }}
        {% endfor -%}
        {% endif -%})
{% endfor %}

(define connect-{{metadata.name | kebab_case}} connect)
(define disconnect-{{metadata.name | kebab_case}} disconnect)

; Define the services, and their helpers
{% for function in functions %}
(define ({{function.name | kebab_case}} {% for input in visible_inputs -%} {{input.name}} {% endfor %})
{%- for input in visible_inputs %} 
    (check-arg '{{ function.name | kebab_case}} ({{input.type | kebab_case}}? {{input.name | kebab_case}}) '{{input.type | kebab_case}} {{ loop.index}} {{input.name | kebab_case}})
{%- endfor %} 
    (json->{{ function.output | kebab_case }} ({{function.name | kebab_case}}/json {% for input in visible_inputs %} {{input.name}} {% endfor %})))
    
(define ({{function.name | kebab_case}}/json {% for input in visible_inputs -%} {{input.name}} {% endfor %})
    (string->jsexpr ({{function.name | kebab_case}}/string {% for input in visible_inputs%} {{input.name}} {% endfor %})))
    
(define ({{function.name | kebab_case}}/string {% for input in visible_inputs -%} {{input.name}} {% endfor %})
    ({{ function.verb }}->string 
        (format "{{ function.url | convert_url_parameters }}" {% for input in function.url_inputs %} {{ input.name | kebab_case | convert_to_string(input.type | kebab_case) }}{%- endfor %})
        (list{% for input in function.payload_inputs %} (cons '{{input.name | kebab_case }} {{input.name | kebab_case }}){% endfor %})
        (list{% for input in function.payload_inputs if input.indexed %} (cons '{{input.name | kebab_case }} {{input.name | kebab_case }}){% endfor %})
        ))

{% endfor %}
