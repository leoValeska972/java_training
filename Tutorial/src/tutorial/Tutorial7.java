package tutorial;

/**
 * <h2>Tutorial7 Class</h2>
 * <p>
 * Process for Displaying Tutorial7
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial7 {
    /**
     * <h2>main</h2>
     * <p>
     * Printing out diamond wrapped with character
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        int ch = 65;
        // upper rows
        for (int i = 1; i <= 6; i++) {
            // upper left columns
            for (int j = 1; j <= 7 - i; j++) {
                System.out.print((char) ((ch + j) - 1)); // changing ASCII into character
            }
            // upper middle space
            for (int k = 1; k <= i * 2 - 3; k++) {
                System.out.print(" ");
            }
            // upper right columns
            for (int l = 7 - i; l >= 1; l--) {
                if (l != 6) {
                    System.out.print((char) ((ch + l) - 1));
                }
            }
            System.out.println();
        }
        // lower rows
        for (int i = 5; i >= 1; i--) {
            // lower left columns
            for (int j = 1; j <= 7 - i; j++) {
                System.out.print((char) ((ch + j) - 1));
            }
            // lower middle space
            for (int k = 1; k <= i * 2 - 3; k++) {
                System.out.print(" ");
            }
            // lower right columns
            for (int l = 7 - i; l >= 1; l--) {
                if (l != 6)
                    System.out.print((char) ((ch + l) - 1));
            }
            System.out.println();
        }
    }
}
