import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.client.utils.URLEncodedUtils;
import groovyx.net.http.*;

import com.fasterxml.jackson.annotation.*;
 
public class CreateJSON {
 
    public static void main(String[] args) throws JsonProcessingException, URISyntaxException, MalformedURLException {
 
    	ObjectMapper mapper = new ObjectMapper();
 
        ArrayNode arrayNode = mapper.createArrayNode();
 
        /**
         * Create three JSON Objects objectNode1, objectNode2, objectNode3
         * Add all these three objects in the array
         */
 
        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("bookName", "Java");
        objectNode1.put("price", "100");
 
        ObjectNode objectNode2 = mapper.createObjectNode();
        objectNode2.put("bookName", "Spring");
        objectNode2.put("price", "200");
 
        ObjectNode objectNode3 = mapper.createObjectNode();
        objectNode3.put("bookName", "Liferay");
        objectNode3.put("price", "500");
 
        /**
         * Array contains JSON Objects
         */
        arrayNode.add(objectNode1);
        arrayNode.add(objectNode2);
        arrayNode.add(objectNode3);
        
        //URI u=new URI("http://localhost:8080/webstore/");
        URIBuilder ub=new URIBuilder("http://localhost:8080/webstore/");
        ub.addQueryParam("username", "valid");
        ub.addQueryParam("password", "invalid");
        //ub=new URIBuilder(ub);
        ub.setPath("login.jsp");
        System.out.println(ub.toString());
 
        /**
         * We can directly write the JSON in the console.
         * But it wont be pretty JSON String
         */
        System.out.println(arrayNode.toString());
 
        /**
         * To make the JSON String pretty use the below code
         */
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode));
 
    }
 
}
