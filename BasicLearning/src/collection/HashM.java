package collection;

import java.util.HashMap;

/**
 * <h2>HashM Class</h2>
 * <p>
 * Process for Displaying HashM
 * </p>
 * 
 * @author User
 *
 */
public class HashM {
    /**
     * <h2>main</h2>
     * <p>
     * Main Method
     * </p>
     *
     * @param args String
     * @return void
     */
    public static void main(String[] args) {
        HashMap<String, String> capitalC = new HashMap<String, String>();
        capitalC.put("England", "London");
        capitalC.put("Germany", "Berlin");
        capitalC.put("Myanmar", "Nay Pyi Taw");
        capitalC.put("USA", "Washington DC");
        System.out.println(capitalC);
        System.out.println("\nOne item of HM/ City of England is " + capitalC.get("England"));
        capitalC.remove("Germany");
        System.out.println("\nDelete Germany" + capitalC);
        System.out.println("\nHM size is " + capitalC.size());
        System.out.println("\nShow only Keys:");
        for (String i : capitalC.keySet()) {
            System.out.println(i);
        }
        System.out.println("\nShow only Values:");
        for (String i : capitalC.values()) {
            System.out.println(i);
        }
        System.out.println("\nShow Both Keys and Values:");
        for (String i : capitalC.keySet()) {
            System.out.println("The capital city of " + i + " is " + capitalC.get(i));
        }
        capitalC.clear();
        System.out.println("\nDeleting all items in HM : " + capitalC.size());
    }
}
