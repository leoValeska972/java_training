package tutorial;

import java.util.HashMap;

/**
 * <h2>Tutorial12A Class</h2>
 * <p>
 * Process for Displaying Tutorial12A
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial12A {
    /**
     * <h2>main</h2>
     * <p>
     * Printing out HashMap
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
    }
}
