package HelpMeAmStuck.Genge;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class GengeJSON {
    public static void GetThisJSONRight() {

        String jsonString = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\",\"hobbies\":[\"reading\",\"traveling\"]}";


        Gson gson = new Gson();


        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);


        String name = jsonObject.get("name").getAsString();
        int age = jsonObject.get("age").getAsInt();
        String city = jsonObject.get("city").getAsString();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);


        JsonArray hobbiesArray = jsonObject.get("hobbies").getAsJsonArray();

        System.out.println("Hobbies:");
        for (JsonElement hobbyElement : hobbiesArray) {
            String hobby = hobbyElement.getAsString();
            System.out.println("- " + hobby);
        }
    }
}
