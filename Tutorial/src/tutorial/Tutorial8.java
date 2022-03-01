package tutorial;

/**
 * <h2>Tutorial8 Class</h2>
 * <p>
 * Process for Displaying Tutorial8
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial8 {
    /**
     * <h2>main</h2>
     * <p>
     * Printing out Side character Triangle
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        int ch = 65;
        int inc = 1;
        // upper rows
        for (int i = 1; i <= 5; i++) {
            // upper columns
            for (int j = 1; j <= i; j++) {
                System.out.print((char) (ch + (inc * j) - 1) + " "); // changing ASCII into character
            }
            System.out.println();
            inc++;
        }
        // lower rows
        for (int i = 1; i <= 4; i++) {
            // lower columns
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print((char) (ch + (inc * j) - 1) + " "); // changing ASCII into character
            }
            System.out.println();
            inc++;
        }
    }
}
