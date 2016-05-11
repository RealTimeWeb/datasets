package corgis.{{ metadata.name | flat_case }}.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

{% for field in dictionary.fields if not (field.type | is_builtin) -%}
import corgis.{{ metadata.name | flat_case }}.domain.{{field.key | camel_case_caps}};
{% endfor %}
/**
 * {{ dictionary.description }}
 */
public class {{ dictionary.name | camel_case_caps }} {
	{% if dictionary.comment %}
    // {{ dictionary.comment }}
    {% endif -%}
	{% for field in dictionary.fields %}
    {% if field.comment -%}
    // {{ field.comment }}
    {% endif -%}
    private {{field.type | to_java_type(field.key)}} {{field.key | camel_case }};
    {%- endfor %}
    
    {% for field in dictionary.fields %}
    /*
     * @return {{ field.description }}
     */
    public {{field.type | to_java_type(field.key)}} get{{field.key | camel_case_caps }}() {
        return this.{{field.key | camel_case }};
    }
    
    {#/*
     * @param {{ field.description }}
     * @return {{field.type | to_java_type(field.key)}}
     */
    public void set{{field.key | camel_case_caps }}({{field.type | to_java_type(field.key)}} {{field.key | camel_case }}) {
        this.{{field.key | camel_case }} = {{field.key | camel_case }};
    }#}
    {% endfor %}
	
	/**
	 * Creates a string based representation of this {{ dictionary.name | camel_case_caps }}.
	
	 * @return String
	 */
	public String toString() {
		return "{{dictionary.name | camel_case_caps }}[" + 
        {%- for field in dictionary.fields -%}
        {{field.key | camel_case }}+ 
        {%- if not loop.last -%}
        ", "+
        {%- endif -%}
        {%- endfor -%}
        "]";
	}
	
	/**
	 * Internal constructor to create a {{ dictionary.name | camel_case_caps }} from a {{ dictionary.format }} representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public {{ dictionary.name | camel_case_caps }}(JSONObject json_data) {
        try {
            {%- for field in dictionary.fields -%}
            {%- if field.type | is_list %}
            this.{{ field.key | camel_case }} = new {{ field.type | to_java_type(field.key) }}();
            Iterator<Object> {{ field.key | camel_case }}Iter = ((List<Object>){{ field.path | parse_json_path}}).iterator();
            while ({{ field.key | camel_case }}Iter.hasNext()) {
                this.{{ field.key | camel_case }}.add(new {{ field.type | strip_list | to_java_type(field.key) }}((
                {%- if field.type | strip_list -%}
                Map<String, Object>
                {%- elif field.type | strip_list | is_builtin -%}
                {{ field.type | strip_list| to_java_type(field.key) }}
                {%- else -%}
                List<Object>
                {%- endif -%}
                ){{ field.key | camel_case }}Iter.next()));
            }
            {%- else %}
            this.{{ field.key | camel_case }} = {{ field.key | parse_json_path | create_json_conversion(field.type, field.key)}};
            {%- endif %}
            {%- endfor %}
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a {{ dictionary.name | camel_case_caps }}; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a {{ dictionary.name | camel_case_caps }}; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}
