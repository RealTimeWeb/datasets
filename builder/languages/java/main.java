package corgis.{{ metadata.name | snake_case }};

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.{{ metadata.name | snake_case }}.domain.*;

import java.sql.*;

/**
 * {{ metadata.description }}
 */
public class {{ metadata.name | camel_case_caps }}Library {
    {% if metadata.comment %}
    // {{ metadata.comment }}
    {% endif -%}
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = {{ metadata.hardware }};
    
    public static void main(String[] args) {
        System.out.println("Testing {{ metadata.name | camel_case_caps}}");
        {{ metadata.name | camel_case_caps }}Library {{ metadata.name | camel_case }}Library = new {{ metadata.name | camel_case_caps }}Library();
        {% for interface in interfaces %}
        {% if interface.production %}
        System.out.println("Testing production {{ interface.name | camel_case_caps}}");
        {{ interface.returns | to_java_type }} {{ interface.returns | to_java_variable }}_{{loop.index}}_production = {{ metadata.name|camel_case }}Library.{{ interface.name | camel_case }}({% for arg in interface.args %}{{arg.default|tojson|safe }}{{ ', ' if not loop.last }}{% endfor %}{% if interface.test %}{{ ', ' if interface.args }}false{% endif %});
        {% endif %}
        {% if interface.test %}
        System.out.println("Testing test {{ interface.name | camel_case_caps}}");
        {{ interface.returns | to_java_type }} {{ interface.returns | to_java_variable }}_{{loop.index}}_test = {{ metadata.name|camel_case }}Library.{{ interface.name | camel_case }}({% for arg in interface.args %}{{arg.default|tojson|safe }}{{ ', ' if not loop.last }}{% endfor %}{% if interface.test %}{{ ', ' if interface.args }}true{% endif %});
        {% endif %}
        {% endfor %}
    }
    
    private void connectToDatabase(String databasePath) {
        this.connection = null;
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:"+databasePath);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        this.parser =  new JSONParser();
    }
	
    /**
     * Create a connection to the database file in its standard position.
     */
	public {{ metadata.name | camel_case_caps }}Library() {
        this.databasePath = "{{ metadata.name | snake_case }}.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public {{ metadata.name | camel_case_caps }}Library(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    {% for interface in interfaces %}
    {% if interface.test %}
    /**
     * {{ interface.description }}
    {% for arg in interface.args %}
     * @param {{arg.name| camel_case}} {{ arg.description }}
    {%- endfor %}
     * @return a {{ interface.returns }}
     */
	public {{ interface.returns | to_java_type }} {{ interface.name | camel_case }}(
    {%- for arg in interface.args -%}
        {{ arg.type | to_java_type }} {{arg.name | camel_case }}
        {%- if not loop.last -%}
        , {% endif -%}
        {%- endfor -%}) {
        return this.{{ interface.name | camel_case }}(
    {%- for arg in interface.args -%}
        {{arg.name | camel_case }}
        {%- if not loop.last -%}
        , {% endif -%}
        {%- endfor -%}{{- ', ' if interface.args -}}true);
    }
    {% endif %}
    
    /**
     * {{ interface.description }}
    {% for arg in interface.args %}
     * @param {{arg.name| camel_case}} {{ arg.description }}
    {%- endfor %}
     * @return a {{ interface.returns }}
     */
	public {{ interface.returns | to_java_type }} {{ interface.name | camel_case }}(
    {%- for arg in interface.args -%}
        {{ arg.type | to_java_type }} {{arg.name | camel_case }}
        {%- if not loop.last -%}
        , {% endif -%}
        {%- endfor -%}{% if interface.test %}{{- ', ' if interface.args -}}boolean test{% endif %}) {
        {% if interface.comment %}
        // {{ interface.comment }}
        {% endif -%}
        String query;
        {% if not interface.test -%}
        boolean test = false;
        {% endif -%}
        if (test) {
            query = String.format("{{ interface.test.sql|replace('{hardware}', '%d') }}", this.HARDWARE);
        } else {
            query = "{{ interface.production.sql }}";
        }
        PreparedStatement preparedQuery = null;
        ResultSet rs = null;
        try {
            preparedQuery = this.connection.prepareStatement(query);
        } catch (SQLException e) {
            System.err.println("Could not build SQL query for local database.");
    		e.printStackTrace();
        }
        {% for arg in interface.args -%}
        try {
            preparedQuery.set{{ arg.type | to_java_type_for_queries}}({{ loop.index }}, {{ arg.name | camel_case }});
        } catch (SQLException e) {
            System.err.println("Could not build prepare argument: {{ arg.name }}");
    		e.printStackTrace();
        }
        {% endfor -%}
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        {{interface.returns | to_java_type }} result = {% if interface.returns | is_list %}new {{interface.returns | to_java_type }}(){% else %}null{% endif %};
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                {% if interface.returns | is_list %}{{ interface.returns | strip_list | to_java_type }}{% else %}{{ interface.returns | to_java_type}}{% endif %} parsed = null;
                if (test) {
                    {% if interface.test.post -%}
                    parsed = new {{ locals[0].row | to_java_type }}({{ interface.test.post|parse_bark }});
                    {% endif %}
                } else {
                    {% if interface.production.post -%}
                    parsed = new {{ locals[0].row | to_java_type }}({{ interface.production.post|parse_bark }});
                    {% endif %}
                }
                {% if interface.returns.startswith("list[") %}
                result.add(parsed);
                {% else %}
                result = parsed;
                {% endif %}
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from {{ interface.name | camel_case }}; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    {% endfor %}
}
