package corgis.{{ metadata.name | snake_case }}.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

{% for field in dictionary.fields if not (field.type | is_builtin) and not (field.type | is_list) -%}
import corgis.{{ metadata.name | snake_case }}.domain.{{field.key | clean_invalid_characters | camel_case_caps}};
{% endfor %}
/**
 * {{ dictionary.description }}
 */
public class {{ dictionary.name | clean_invalid_characters | camel_case_caps }} {
	{% if dictionary.comment %}
    // {{ dictionary.comment }}
    {% endif -%}
	{% for field in dictionary.fields %}
    {% if field.comment -%}
    // {{ field.comment }}
    {% endif -%}
    private {{field.type | to_java_type(field.key)}} {{field.key | clean_invalid_characters| camel_case }};
    {%- endfor %}
    
    {% for field in dictionary.fields %}
    /*
     * @return {{ field.description }}
     */
    public {{field.type | to_java_type(field.key)}} get{{field.key | clean_invalid_characters| camel_case_caps }}() {
        return this.{{field.key | clean_invalid_characters| camel_case }};
    }
    
    {#/*
     * @param {{ field.description }}
     * @return {{field.type | to_java_type(field.key)}}
     */
    public void set{{field.key | camel_case_caps }}({{field.type | to_java_type(field.key)}} {{field.key | clean_invalid_characters| camel_case }}) {
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
        {{field.key | clean_invalid_characters| camel_case }}+ 
        {%- if not loop.last -%}
        ", "+
        {%- endif -%}
        {%- endfor -%}
        "]";
	}
	
	/**
	 * Internal constructor to create a {{ dictionary.name | camel_case_caps }} from a {{ dictionary.format }} representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public {{ dictionary.name | clean_invalid_characters | camel_case_caps }}(JSONObject json_data) {
        try {
            {%- for field in dictionary.fields -%}
            // {{field.key}}
            {%- if field.type | is_list %}
            this.{{ field.key | clean_invalid_characters | camel_case}} = new {{ field.type | to_java_type(field.key) }}();
            Iterator<Object> {{ field.key | clean_invalid_characters | camel_case }}Iter = ((List<Object>){{ field.key | clean_invalid_characters| parse_json_path }}).iterator();
            while ({{ field.key | clean_invalid_characters | camel_case }}Iter.hasNext()) {
                this.{{ field.key | clean_invalid_characters | camel_case }}.add(new {{ field.type | strip_list | to_java_type(field.key) }}((
                {%- if field.type | strip_list | is_builtin -%}
                {{ field.type | strip_list| to_java_type(field.key) }}
                {%- elif field.type | strip_list -%}
                JSONObject
                {%- else -%}
                List<Object>
                {%- endif -%}
                ){{ field.key | clean_invalid_characters | camel_case }}Iter.next()));
            }
            {%- else %}
            this.{{ field.key | clean_invalid_characters | camel_case }} = {{ field.key | parse_json_path | create_json_conversion(field.type, field.key)}};
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
