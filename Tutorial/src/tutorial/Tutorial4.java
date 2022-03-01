package tutorial;

/**
 * <h2>Tutorial4 Class</h2>
 * <p>
 * Process for Displaying Tutorial4
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial4 {
    /**
     * <h2>main</h2>
     * <p>
     * Printing out Triangle numbers with no odd numbers except 1
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
                if (j == 1) {
                    System.out.print(j);
                }
                if (j % 2 == 0) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}
