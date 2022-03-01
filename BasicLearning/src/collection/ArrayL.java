package collection;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <h2>ArrayL Class</h2>
 * <p>
 * Process for Displaying ArrayL
 * </p>
 * 
 * @author User
 *
 */
public class ArrayL {
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
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Tesla");
        cars.add("BMW");
        cars.add("Suzuki");
        System.out.println("All items in AL " + cars);
        System.out.println("\nOne item of AL is " + cars.get(0));
        cars.set(2, "Toyota");
        System.out.println("\nUpdate Suzuki to Toyota : " + cars);
        cars.remove(2);
        System.out.println("\nDelete Toyota" + cars);
        System.out.println("\nAL size is " + cars.size());
        System.out.println("\nAL with looping : ");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }
        System.out.println("\nAL with Sorting : ");
        Collections.sort(cars);
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }
        cars.clear();
        System.out.println("\nDeleting all items in AL : " + cars.size());
    }
}
