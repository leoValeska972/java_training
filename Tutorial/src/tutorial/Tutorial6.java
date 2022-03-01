package tutorial;

/**
 * <h2>Tutorial6 Class</h2>
 * <p>
 * Process for Displaying Tutorial6
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial6 {
    /**
     * <h2>main</h2>
     * <p>
     * Printing out Triangle and Reverse number triangle touch with a single number
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        // upper rows
        for (int i = 1; i <= 7; i++) {
            // upper columns front space
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            // upper columns number and back space
            for (int j = i; j <= 7; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        // lower rows
        for (int i = 6; i >= 1; i--) {
            // lower columns front space
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            // lower columns number and back space
            for (int j = i; j <= 7; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
