package uk.co.hyttioaboa.messages;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import uk.co.hyttioaboa.messages.json.JsonMessage;
import uk.co.hyttioaboa.messages.json.JsonPage;
import uk.co.hyttioaboa.messages.xml.XmlMessage;

import java.util.ArrayList;

public class Message {
    ArrayList<Page> pages;
    ArrayList<Element> elements;
    private String type;

    public Message(String testDefinition) {
        JsonMessage jsonMessage = new JsonMessage(testDefinition);
        if (jsonMessage.isJsonMessage()) {
            if (jsonMessage.hasPages() && !jsonMessage.hasElements()) {

            }


            System.out.println("Valid JSON");
            type = "JSON";
        }
        else {
            XmlMessage xmlValidator = new XmlMessage(testDefinition);
            if (xmlValidator.isMessageValid()) {
                System.out.println("Valid XML");
                type = "XML";
            }
            else {
                System.out.println("Invalid everything :(");
            }
        }
    }

    private ArrayList getPages(JsonMessage parentElement) {
        ArrayList<JsonPage> newArray = new ArrayList<JsonPage>();

        if (parentElement.hasPages()) {
            newArray = parentElement.getPages();
        }

        return newArray;
    }


}
