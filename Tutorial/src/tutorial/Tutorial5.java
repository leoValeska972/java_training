package tutorial;

/**
 * <h2>Tutorial5 Class</h2>
 * <p>
 * Process for Displaying Tutorial5
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial5 {
    /**
     * <h2>main</h2>
     * <p>
     * Printing out Reverse Triangle
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
    	//rows
        for (int i = 1; i <= 6; i++) {
        	//columns
            for (int j = 2; j <= i; j++) {
                System.out.print(" ");
            }
            //stars
            for (int k = 6; k >= i; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
