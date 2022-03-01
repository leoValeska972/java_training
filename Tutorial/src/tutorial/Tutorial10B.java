package tutorial;

import java.util.Arrays;

/**
 * <h2>Tutorial10B Class</h2>
 * <p>
 * Process for Displaying Tutorial10B
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial10B {
    /**
     * <h2>main</h2>
     * <p>
     * Deleting an element in an array
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        int[] num = { 25, 14, 56, 15, 36 };
        System.out.println("Array before deleting : " + Arrays.toString(num));
        int[] arr = new int[num.length - 1];
        int k = 0;
        // copying original array to another array
        for (int i = 0; i < num.length; i++) {
            // exclude the element that user want to delete
            if (num[i] == 25) {
                continue;
            }
            arr[k++] = num[i];
        }
        // Array after deleting
        System.out.print("Array after deleting : " + Arrays.toString(arr));
    }
}
