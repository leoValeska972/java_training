package tutorial;

import java.util.Scanner;

/**
 * <h2>Tutorial9A Class</h2>
 * <p>
 * Process for Displaying Tutorial9A
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial9A {
    /**
     * <h2>main</h2>
     * <p>
     * Checking Number is Positive or Negative
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        int z;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Input Number : ");
            int num = sc.nextInt();
            if (num > 0) {
                System.out.println("Expected Output : Number is positive");
            } else {
                System.out.println("Expected Output : Number is negative");
            }
            System.out.println("Do you want to continue? 1=y/2=n?");
            z = sc.nextInt();
            if (z > 2 || z <= 0) {
                while (z > 2 || z <= 0) {
                    System.out.println("Please only enter 1 as yes and 2 as no.");
                    System.out.println("Do you want to continue? 1=y/2=n?");
                    z = sc.nextInt();
                }
            }
        } while (z != 2);
        sc.close();
        System.out.println("Exit...");
    }
}
