package collection;

import java.util.LinkedList;
import java.util.Collections;

/**
 * <h2>LinkedL Class</h2>
 * <p>
 * Process for Displaying LinkedL
 * </p>
 * 
 * @author User
 *
 */
public class LinkedL {
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
        LinkedList<String> cars = new LinkedList<String>();
        cars.add("Volvo");
        cars.addLast("BMW");
        cars.add("Ford");
        cars.addFirst("Tesla");
        System.out.println("All items in LL " + cars);
        System.out.println("\nOne item of LL is " + cars.getFirst());
        cars.set(2, "Toyota");
        System.out.println("\nUpdate BMW to Toyota : " + cars);
        cars.remove(2);
        System.out.println("\nDelete Toyota" + cars);
        System.out.println("\nLL size is " + cars.size());
        System.out.println("\nLL with looping : ");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }
        System.out.println("\nLL with Sorting : ");
        Collections.sort(cars);
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }
        cars.clear();
        System.out.println("\nDeleting all items in LL : " + cars.size());
    }
}
