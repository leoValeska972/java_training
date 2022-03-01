package tutorial;

import java.util.HashMap;

/**
 * <h2>Tutorial12C Class</h2>
 * <p>
 * Process for Displaying Tutorial12C
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial12C {
    /**
     * <h2>main</h2>
     * <p>
     * Finding value with key from HashMap
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        HashMap<String, String> capitalC = new HashMap<String, String>();
        capitalC.put("England", "London");
        capitalC.put("Germany", "Berlin");
        capitalC.put("Myanmar", "Nay Pyi Taw");
        capitalC.put("USA", "Washington DC");
        System.out.println("HashMap : " + capitalC);
        // Finding value with key
        System.out.println("\nCity of England is " + capitalC.get("England"));
    }
}
