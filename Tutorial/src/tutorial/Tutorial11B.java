package tutorial;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <h2>Tutorial11B Class</h2>
 * <p>
 * Process for Displaying Tutorial11B
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial11B {
    /**
     * <h2>main</h2>
     * <p>
     * Swapping elements in ArrayList
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Red");
        al.add("Green");
        al.add("Black");
        al.add("White");
        al.add("Pink");
        System.out.println("Before Swapping : " + al);
        // swapping elements from ArrayList with index
        Collections.swap(al, 0, 2);
        System.out.println("After Swapping : " + al);
    }

}
