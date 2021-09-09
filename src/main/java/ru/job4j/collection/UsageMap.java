package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("mscott@dundermifflin.com", "Michael Scott");
        userMap.put("dschrute@dundermifflin.com", "Dwight Schrute");
        userMap.put("jhalpert@dundermifflin.com", "Jim Halpert");
        for (String key : userMap.keySet()) {
            String value = userMap.get(key);
            System.out.println("Email " + key + ", user " + value);
        }
    }

}
