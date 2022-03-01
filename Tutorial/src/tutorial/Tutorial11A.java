package tutorial;

import java.util.ArrayList;

/**
 * <h2>Tutorial11A Class</h2>
 * <p>
 * Process for Displaying Tutorial11A
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial11A {
    /**
     * <h2>main</h2>
     * <p>
     * Printing out elements from ArrayList
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Red");
        al.add("Green");
        al.add("Orange");
        al.add("White");
        al.add("Black");
        System.out.println("ArrayList : " + al);
    }
}
