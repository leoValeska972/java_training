package tutorial;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <h2>Tutorial10C Class</h2>
 * <p>
 * Process for Displaying Tutorial10C
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial10C {
    /**
     * <h2>main</h2>
     * <p>
     * Converting ArrayList into Array
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Python");
        al.add("JAVA");
        al.add("PHP");
        al.add("Perl");
        al.add("C#");
        // changing ArrayList to Array
        String[] str = al.toArray(new String[al.size()]);
        System.out.println("ArrayList : " + al);
        // Converting ArrayList into Array
        System.out.println("Converting ArrayList into Array : " + Arrays.toString(str));
    }
}
