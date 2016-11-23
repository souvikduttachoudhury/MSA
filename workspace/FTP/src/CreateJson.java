
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.annotation.*;
 
public class CreateJson{
 
    public String create()throws JsonProcessingException {
 
    	ObjectMapper mapper = new ObjectMapper();
 
    	ObjectNode userTable = mapper.createObjectNode();
        ArrayNode userArray = mapper.createArrayNode();
        
 
        /**
         * Create three JSON Objects objectNode1, objectNode2, objectNode3
         * Add all these three objects in the array
         */
 
        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("username", "Java");
        objectNode1.put("password", "100");
        objectNode1.put("role","SUPER_USER");
 
        ObjectNode objectNode2 = mapper.createObjectNode();
        objectNode2.put("username", "Spring");
        objectNode2.put("password", "200");
        objectNode2.put("role","IT_SUPPORT");
 
        ObjectNode objectNode3 = mapper.createObjectNode();
        objectNode3.put("username", "Liferay");
        objectNode3.put("password", "500");
        objectNode3.put("role","EMAIL_SUPPORT");
 
        /**
         * Array contains JSON Objects
         */
        userArray.add(objectNode1);
        userArray.add(objectNode2);
        userArray.add(objectNode3);
        
        ObjectNode tokencount=mapper.createObjectNode();
        //tokencount.put("tokencount", 3);
        userTable.put("tokencount", "3");
        userTable.putPOJO("users", userArray);
        
        ObjectNode content = mapper.createObjectNode();
        //content.putPOJO("UserRepository", userTable);
        
        
        /**
         * We can directly write the JSON in the console.
         * But it wont be pretty JSON String
         */
        //System.out.println(userTable.toString());
 
        /**
         * To make the JSON String pretty use the below code
         */
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userTable);
 
    }
 
}

