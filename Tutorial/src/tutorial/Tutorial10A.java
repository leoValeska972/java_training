package tutorial;

/**
 * <h2>Tutorial10A Class</h2>
 * <p>
 * Process for Displaying Tutorial10A
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial10A {
    /**
     * <h2>main</h2>
     * <p>
     * Calculating average value of array elements
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        double j = 0;
        int[] num = { 3, 4, 5, 7, 9 };
        System.out.print("Elements in an array : ");
        // Printing out all elements in array
        for (int i : num) {
            System.out.print(i + " ");
            j += i;
        }
        System.out.println("\nSum of array elements : " + j);
        // Counts of array elements
        System.out.println("Counts of array elements : " + num.length);
        // Average value of array elements
        System.out.println("\nAverage value of array elements is " + j / num.length);
    }
}
