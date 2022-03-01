package tutorial;

import java.util.HashMap;

/**
 * <h2>Tutorial12B Class</h2>
 * <p>
 * Process for Displaying Tutorial12B
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial12B {
    /**
     * <h2>main</h2>
     * <p>
     * Copying HashMap to another HashMap
     * </p>
     *
     * @param args String[]
     * @return void
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        HashMap<String, String> capitalC = new HashMap<String, String>();
        capitalC.put("England", "London");
        capitalC.put("Germany", "Berlin");
        capitalC.put("Myanmar", "Nay Pyi Taw");
        capitalC.put("USA", "Washington DC");
        System.out.println("Original HashMap : " + capitalC);
        //copy original HashMap into another HashMap
        HashMap<String, String> cap = (HashMap<String, String>) capitalC.clone();
        System.out.println("Copied HashMap : " + cap);
    }
}
