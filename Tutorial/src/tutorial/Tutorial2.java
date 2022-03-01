package tutorial;

/**
 * <h2>Tutorial2 Class</h2>
 * <p>
 * Process for Displaying Tutorial2
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial2 {
    /**
     * <h2>main</h2>
     * <p>
     * Printing out number 1 to 10 and their sum and odd numbers among them
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        int z = 0;
        int[] i = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        //printing out number 1 to 10 and their sum
        for (int j : i) {
            z += j;
            System.out.print(j + " ");
        }
        System.out.println("\n\nSum of 1 to 10 is " + z);
        System.out.println("\nOdd Number Between 1 to 10 is ");
        //printing out odd numbers among them
        for (int k = 0; k < i.length; k++) {
            if (i[k] % 2 != 0) {
                System.out.print(i[k] + " ");
            }
        }
    }
}
