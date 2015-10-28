#lang scribble/manual
 
@title{ {{ metadata.name | kebab_case }} }
@author{+email "{{ metadata.author }}" "{{ metadata.contact }}"}

@section{Structs}
 
{{ metadata.description }}

{% for object in objects %}
@defproc[(make-{{ object.name | kebab_case }}
    {% for field in object.fields -%}
    {% if field.type | is_list -%}
        [{{ field.name| kebab_case }} (listof {{field.type | strip_list | kebab_case}}?]
    {% else -%}
        [{{ field.name| kebab_case }} {{ field.type | kebab_case }}?]
    {% endif -%}
    {% endfor -%}
        {{ object.name | kebab_case }}]{
        {{ object.description }}
        @itemlist[
            {% for field in object.fields -%}
                @item{@racket[{{field.name | kebab_case}}] --- {{ field.description }} }
            {% endfor %}
        ]}
{% endfor %}

@section{Functions}

@defproc[(disconnect-{{ metadata.name | kebab_case }} ) void]{
        Establishes that data will be retrieved locally.
        @itemlist[
            @item{@racket[filename] --- A cache file to use. Defaults to @racket{"cache.json"}.
		]}

@defproc[(disconnect-{{ metadata.name | kebab_case }} ) void]{
        Establishes that data will be accessed online.
        @itemlist[]}

{% for function in functions %}
@defproc[({{function.name | kebab_case }} {% for input in function.visible_inputs %} {% if input.type | is_list %} [{{ input.name| kebab_case }} (listof {{input.type | strip_list | kebab_case}}?)]{% else %}[{{ input.name| kebab_case }} {{ input.type | kebab_case }}?]{% endif %}{% endfor -%}
    ) 
    {% if function.output | is_list -%}
        (listof {{function.output | strip_list | kebab_case}}?)
    {% else -%}
        {{ function.output | kebab_case }}?
    {% endif -%}
    ]{
    {{ function.description }}
    @itemlist[
    {% for input in function.visible_inputs -%}
			@item{@racket[{{ input.name }}] --- {{ input.description }}}]}
    {% endfor %}]}
{% endfor %}
