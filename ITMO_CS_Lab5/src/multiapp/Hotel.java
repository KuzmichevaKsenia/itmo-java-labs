package multiapp;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    String name;
    public Map<String, Feedback> feedbackMap = new HashMap<>();

    Hotel(String name) {
        this.name = name;
    }
}
