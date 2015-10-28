package realtimeweb.{{ metadata.name | flat_case }};

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
{% if "xml" in formats_required -%}
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
{%- endif %}
import realtimeweb.{{ metadata.name | flat_case }}.domain.*;

import realtimeweb.stickyweb.EditableCache;
import realtimeweb.stickyweb.StickyWeb;
import realtimeweb.stickyweb.StickyWebRequest;
import realtimeweb.stickyweb.StickyWebResponse;
import realtimeweb.stickyweb.exceptions.StickyWebDataSourceNotFoundException;
import realtimeweb.stickyweb.exceptions.StickyWebDataSourceParseException;
import realtimeweb.stickyweb.exceptions.StickyWebInternetException;
import realtimeweb.stickyweb.exceptions.StickyWebInvalidPostArguments;
import realtimeweb.stickyweb.exceptions.StickyWebInvalidQueryString;
import realtimeweb.stickyweb.exceptions.StickyWebJsonResponseParseException;
import realtimeweb.stickyweb.exceptions.StickyWebLoadDataSourceException;
import realtimeweb.stickyweb.exceptions.StickyWebNotInCacheException;

/**
 * {{ metadata.description }}
 */
public class {{ metadata.name | camel_case_caps }} {
    {% if metadata.comment %}
    // {{ metadata.comment }}
    {% endif -%}
	private StickyWeb connection;
	private boolean online;
    
    public static void main(String[] args) {
        {{ metadata.name | camel_case_caps }} {{ metadata.name | camel_case }} = new {{ metadata.name | camel_case_caps }}();
        
        // The following pre-generated code demonstrates how you can
		// use StickyWeb's EditableCache to create data files.
		try {
            // First, you create a new EditableCache, possibly passing in an FileInputStream to an existing cache
			EditableCache recording = new EditableCache();
            // You can add a Request object directly to the cache.
			// recording.addData({{ metadata.name | camel_case }}.{{ functions[0].name | camel_case }}Request(...));
            // Then you can save the expanded cache, possibly over the original
			recording.saveToStream(new FileOutputStream("cache.json"));
		} catch (StickyWebDataSourceNotFoundException e) {
			System.err.println("The given FileStream was not able to be found.");
		} catch (StickyWebDataSourceParseException e) {
			System.err.println("The given FileStream could not be parsed; possibly the structure is incorrect.");
		} catch (StickyWebLoadDataSourceException e) {
			System.err.println("The given data source could not be loaded.");
		} catch (FileNotFoundException e) {
			System.err.println("The given cache.json file was not found, or could not be opened.");
		}
        // ** End of how to use the EditableCache
    }
	
    /**
     * Create a new, online connection to the service
     */
	public {{ metadata.name | camel_case_caps }}() {
        this.online = true;
		try {
			this.connection = new StickyWeb(null);
		} catch (StickyWebDataSourceNotFoundException e) {
			System.err.println("The given datastream could not be loaded.");
		} catch (StickyWebDataSourceParseException e) {
			System.err.println("The given datastream could not be parsed");
		} catch (StickyWebLoadDataSourceException e) {
			System.err.println("The given data source could not be loaded");
		}
	}
	
    /**
     * Create a new, offline connection to the service.
     * @param cache The filename of the cache to be used.
     */
	public {{ metadata.name | camel_case_caps }}(String cache) {
        // TODO: You might consider putting the cache directly into the jar file,
        // and not even exposing filenames!
        try {
            this.online = false;
            this.connection = new StickyWeb(new FileInputStream(cache));
        } catch (StickyWebDataSourceNotFoundException e) {
			System.err.println("The given data source could not be found.");
            System.exit(1);
		} catch (StickyWebDataSourceParseException e) {
			System.err.println("Could not read the data source. Perhaps its format is incorrect?");
            System.exit(1);
		} catch (StickyWebLoadDataSourceException e) {
			System.err.println("The given data source could not be read.");
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.err.println("The given cache file could not be found. Make sure it is in the right folder.");
			System.exit(1);
		}
	}
    
    {% for function in functions %}
    /**
     * {{ function.description }}
     *
     * This version of the function meant for instructors to capture a
     * StickyWebRequest object which can be put into an EditableCache and then
     * stored to a "cache.json" file.
     * 
     {% for input in function.visible_inputs -%}
     * @param {{input.name | camel_case }} {{input.description }}
     * @return a StickyWebRequest
     {% endfor -%}
    */
    private StickyWebRequest {{ function.name | camel_case }}Request(
    {%- for input in function.visible_inputs -%}
        {{ input.type | to_java_type }} {{input.name | camel_case }}
        {%- if not loop.last -%}, {% endif -%}
    {%- endfor -%}
    ) {
        try {
            /*
            * Perform any user parameter validation here. E.g.,
            * if the first argument can't be zero, or they give an empty string.
            */
            
            // Build up query string
            final String url = String.format("{{ function.url | convert_url_parameters }}"
            {%- for parameter in function.url_inputs -%}
            {%- if parameter.hidden -%}
                , "{{ parameter.default }}"
            {%- else -%}
                , String.valueOf({{ parameter.name }})
            {%- endif -%}
            {%- endfor -%}
            );
            
            // Build up the query arguments that will be sent to the server
            HashMap<String, String> parameters = new HashMap<String, String>();
            {%- for parameter in function.payload_inputs -%}
            {%- if parameter.hidden %}
            parameters.put("{{ parameter.path }}", "{{ parameter.default }}");
            {%- else %}
            parameters.put("{{ parameter.path }}", String.valueOf({{ parameter.name }}));
            {%- endif -%}
            {% endfor %}
            
            // Build up the list of actual arguments that should be used to
            // create the local cache hash key
            ArrayList<String> indexList = new ArrayList<String>();
            {% for parameter in function.payload_inputs if parameter.indexed -%}
            indexList.add("{{ parameter.path }}");
            {% endfor %}
            
            // Build and return the connection object.
            return connection.{{ function.verb }}(url, parameters)
                            .setOnline(online)
                            .setIndexes(indexList);
        
        } catch (StickyWebDataSourceNotFoundException e) {
			System.err.println("Could not find the data source.");
		}
        return null;
    }
    
    /**
     * {{ function.description }}
    {% for input in function.visible_inputs %}
     * @param {{input.name| camel_case}} {{ input.description }}
    {%- endfor %}
     * @return a {{ function.output }}
     */
	public {{ function.output | to_java_type }} {{ function.name | camel_case }}(
    {%- for input in function.visible_inputs -%}
        {{ input.type | to_java_type }} {{input.name | camel_case }}
        {%- if not loop.last -%}
        , {% endif -%}
    {%- endfor -%}
    ) {
        {% if function.comment %}
        // {{ function.comment }}
        {% endif -%}
		try {
			StickyWebRequest request =  {{ function.name | camel_case }}Request(
            {%- for input in function.visible_inputs -%}
                {{input.name | camel_case }}
                {%- if not loop.last -%}, {% endif -%}
            {%- endfor -%}
            );
            {% if function.format == "xml" -%}
                {%- if function.post == "" -%}
            return new {{ function.output | to_java_type }}(request.execute().asXML());
                {%- else -%}
            XPath xPath =  XPathFactory.newInstance().newXPath();
            return new {{ function.output | to_java_type }}(xPath.compile("{{ function.post }}").evaluate(request.execute().asXML()));
                {%- endif -%}
            {%- elif function.format == "html" -%}
                {%- if function.post == "" -%}
            return new {{ function.output | to_java_type }}(request.execute().asHTML());
                {%- else -%}
            // TODO: Probably want to cast to (org.htmlcleaner.TagNode) and manipulate data
            return new {{ function.output | to_java_type }}(request.execute().asHTML().evaluateXPath("{{ function.post }}"));
                {%- endif -%}
            {%- elif function.format == "json" -%}
            {% if function.output | is_list %}
            {{function.output | to_java_type }} result = new {{function.output | to_java_type }}();
            StickyWebResponse response = request.execute();
            // TODO: Validate the output here using response.isNull, response.asText, etc.
            if (response.isNull())
                return result;
            Iterator<Object> resultIter = ((ArrayList<Object>) {{ function.post | parse_json_path_all("response.asJSON" | enforce_json_array(function.post)) }}).iterator();
            while (resultIter.hasNext()) {
                result.add(new {{ function.output | strip_list | to_java_type }}((
                {%- if object_is_map[function.output | strip_list] -%}
                Map<String, Object>
                {%- else -%}
                List<Object>
                {%- endif -%}
                )resultIter.next()));
            }
            return result;
            {%- else -%}
            return new {{ function.output | to_java_type }}((Map<String, Object>)request.execute().asJSON
            {%- if function.post != "" and function.post[0] == "[" -%}
                Array
            {%- elif function.post == "" -%}
                {{ object_is_map | make_array(function.output | to_java_type) }}
            {%- endif -%}
            ()
                {%- if function.post != "" -%}
                    {{ function.post | parse_json_path("") }}
                {%- endif -%});
            {%- endif %}
            {%- elif function.format == "text" -%}
                return new {{ function.output | to_java_type }}(request.execute().asText());
            {%- elif function.format == "csv" -%}
                {%- if function.post == "" -%}
            return new {{ function.output | to_java_type }}(request.execute().asCSV());
                {%- else -%}
            return new {{ function.output | to_java_type }}(request.execute().asCSV().get({{ function.post }}));
                {%- endif -%}
            {%- endif %}
		} catch (StickyWebNotInCacheException e) {
			System.err.println("There is no query in the cache for the given inputs. Perhaps something was mispelled?");
		} catch (StickyWebInternetException e) {
			System.err.println("Could not connect to the web service. It might be your internet connection, or a problem with the web service.");
		} catch (StickyWebInvalidQueryString e) {
			System.err.println("The given arguments were invalid, and could not be turned into a query.");
		} catch (StickyWebInvalidPostArguments e) {
			System.err.println("The given arguments were invalid, and could not be turned into a query.");
        {% if function.format != "text" %}
        {%- if function.format == "csv" -%}
		} catch (StickyWebCSVResponseParseException e) {
        {%- elif function.format == "xml" or function.format == "html" -%}
        } catch (StickyWebXMLResponseParseException e) {
        {%- else %}
        } catch (StickyWebJsonResponseParseException e) {
        {%- endif %}
            System.err.println("The response from the server couldn't be understood.");
        {% endif %}
		}
		return null;
	}
    {% endfor %}
}
