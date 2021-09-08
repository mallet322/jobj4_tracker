package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("mscott@dundermifflin.com", "Michael Scott");
        userMap.put("dschrute@dundermifflin.com", "Dwight Schrute");
        userMap.put("jhalpert@dundermifflin.com", "Jim Halpert");
        for (Map.Entry<String, String> entry : userMap.entrySet()) {
            System.out.println("email: " + entry.getKey() + ", user: " + entry.getValue());
        }
    }

}
