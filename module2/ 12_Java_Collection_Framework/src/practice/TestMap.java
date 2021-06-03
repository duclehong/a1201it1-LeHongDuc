package practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMapDemo = new HashMap<>();
        hashMapDemo.put("Duck", 20);
        hashMapDemo.put("Pea", 20);
        hashMapDemo.put("Dog", 10);
        hashMapDemo.put("Rat", 2);
        hashMapDemo.put("Cat", 7);
        hashMapDemo.put("Tiger", 22);
        //////////////////////
        Map<String, Integer> treeMap = new TreeMap<>(hashMapDemo);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);
        ////////////////////////
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis"));
    }
}
