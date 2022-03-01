package tutorial;

/**
 * <h2>Tutorial3 Class</h2>
 * <p>
 * Process for Displaying Tutorial3
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial3 {
    /**
     * <h2>main</h2>
     * <p>
     * Printing out Triangle numbers
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
    	//rows
        for (int i = 1; i <= 10; i++) {
        	//columns
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
