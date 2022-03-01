package collection;

import java.util.HashMap;

public class NHM {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, String>> outerMap = new HashMap<String, HashMap<String, String>>();
        HashMap<String, String> innerMap1 = new HashMap<String, String>();
        innerMap1.put("England", "London");
        innerMap1.put("Germany", "Berlin");
        innerMap1.put("Myanmar", "Nay Pyi Taw");
        innerMap1.put("USA", "Washington DC");
        outerMap.put("city", innerMap1);
        HashMap<String, String> innerMap2 = new HashMap<String, String>();
        innerMap2.put("Purple", "#800080");
        innerMap2.put("Black", "#000000");
        innerMap2.put("White", "#FFFFFF");
        innerMap2.put("SkyBlue", "#87CEEB");
        outerMap.put("color", innerMap2);
        System.out.println(outerMap);
        System.out.println(outerMap.get("city").get("England"));        
        System.out.println(outerMap.get("color").get("Purple"));
    }
}
