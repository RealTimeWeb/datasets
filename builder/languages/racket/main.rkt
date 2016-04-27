#lang racket

; Load the internal libraries
(require htdp/error)
(require json)
(require racket/port)
(require racket/format)
(require net/url)
(require db)

(define database-name "{{ metadata.name|flat_case }}.db")
(define database (sqlite3-connect #:database database-name))
(define hardware-limit {{ metadata.hardware }})
(define test-mode false)

; Provide the external structs
(provide 
{%- for name, structure in structures.items() -%}
{%- for path, data in structure.dictionaries.items() %}
    (struct-out {{ data.name | kebab_case }})
{%- endfor -%}
{%- endfor -%}
{%- for interface in interfaces %}
    {{ interface.name | kebab_case }}
{%- endfor %}
    main)

; Define the structs
{%- for name, structure in structures.items() -%}
{%- for path, data in structure.dictionaries.items() %}
(define-struct {{ data.name | kebab_case }}
    ({%- for field in data.fields %}{{ field.key | kebab_case }}{{ ' ' if not loop.last }}{%- endfor -%}))
{% endfor %}
{% endfor %}

{%- for name, structure in structures.items() -%}
{%- for path, data in structure.dictionaries.items() %}
(define (json->{{data.name | kebab_case}} jdata)
    (make-{{data.name | kebab_case}}
        {% for field in data.fields -%}
        {% if field.type | is_builtin -%}
        {{ field.key | parse_json_path }}
        {% else -%}
        {% if field.type | is_list -%}
        {%- set inner_type = structure.lists[field.path].type -%}
        {% if inner_type | is_builtin -%}
        {{ field.key | parse_json_path }}
        {% else -%}
        (map json->{{ field.key | kebab_case }} {{ field.key | parse_json_path }})
        {% endif -%}
        {% else -%}
        (json->{{ field.key | kebab_case }} {{ field.key | parse_json_path }})
        {% endif -%}
        {% endif -%}
        {%- endfor -%}
    ))
{% endfor %}
{% endfor %}

; Define the services, and their helpers
{% for interface in interfaces %}
(define ({{ interface.name | kebab_case }} {% for arg in interface.args %}{{arg.name| kebab_case }}{{ ' ' if not loop.last }}{% endfor %}{% if interface.test %}{% if interface.args %} {% endif %}[test #t]{% endif %})
{%- for arg in interface.args %} 
    (check-arg '{{ arg.name | kebab_case}} ({{arg.type | kebab_case}}? {{arg.name | kebab_case}}) '{{arg.type | kebab_case}} {{ loop.index}} {{arg.name | kebab_case}})
    {% if arg.matches -%}
    ; Ensure a match exists
    (let ([potentials (map string-downcase 
                           (query-list database "{{ arg.matches }}"))]
          [arg (string-downcase {{arg.name|kebab_case}})])
        (if (eq? false (member arg potentials))
            (error "Error, the given argument could not be found. Please check to make sure you have the right spelling.")
            true))
    {%- endif %}
{%- endfor %} 
{% if interface.test %}
    (if (or test-mode test)
    {%- if interface.test.type == "SQL" %}
        (let* [(result (query-list database 
                                  (format "{{ interface.test.sql|replace('{hardware}', '~a') }}" hardware-limit)
                                {% for arg in interface.args -%}
                                {{arg.name| kebab_case }}
                                {%- endfor %}))
               {%- if interface.test.post %}
               (result {{ interface.test.post|parse_bark }})
               {%- endif %}]
           {%- if interface.returns.startswith('list[') %}
           (map json->{{ interface.returns|strip_list|kebab_case }} result)
           {%- else %}
           (first (map json->{{ interface.returns|kebab_case }} result))
           {%- endif %}
           )
    {%- endif -%}
{%- endif -%}
    {% if interface.production.type == "SQL" -%}
        (let* [(result (query-list database 
                                   "{{ interface.production.sql }}"
                                {% for arg in interface.args -%}
                                {{arg.name| kebab_case }}
                                {% endfor -%}))
               {% if interface.production.post -%}
               (result {{ interface.production.post|parse_bark }})
               {% endif -%}]
           {%- if interface.returns.startswith('list[') %}
           (map json->{{ interface.returns|strip_list|kebab_case }} result)
           {%- else %}
           (first (map json->{{ interface.returns|kebab_case }} result))
           {%- endif %}
           )
    {%- endif -%}
{%- if interface.test -%}
    )
{%- endif %}
)
{% endfor %}

(define (main)
    (displayln "Running tests")
    {% for interface in interfaces %}
    (displayln "Production {{ interface.name | kebab_case }}")
    (displayln {{ '(length ' if interface.returns.startswith("list[") }}(time ({{ interface.name | kebab_case }} {% for arg in interface.args %}{{arg.default|tojson|safe }}{{ ' ' if not loop.last }}{% endfor %}{% if interface.test %}{{ ' ' if interface.args }}false{% endif %})){{ ')' if interface.returns.startswith("list[") }})
    {% if interface.test -%}
    (displayln "Test {{ interface.name | kebab_case }}")
    (displayln {{ '(length ' if interface.returns.startswith("list[") }}(time ({{ interface.name | kebab_case }} {% for arg in interface.args %}{{arg.default|tojson|safe }}{{ ' ' if not loop.last }}{% endfor %}{% if interface.test %}{{ ' ' if interface.args }}true{% endif %})){{ ')' if interface.returns.startswith("list[") }})
    {% endif %}
    {% endfor %}

    )