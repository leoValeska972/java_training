package tutorial;

import java.util.Scanner;

/**
 * <h2>Tutorial9B Class</h2>
 * <p>
 * Process for Displaying Tutorial9B
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial9B {
    /**
     * <h2>main</h2>
     * <p>
     * Finding Maximum Number
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        int z;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Input the 1st number : ");
            int a = sc.nextInt();
            System.out.println("Input the 2nd number : ");
            int b = sc.nextInt();
            System.out.println("Input the 3rd number : ");
            int c = sc.nextInt();
            int d = Math.max(a, b);
            int e = Math.max(c, d);
            System.out.println("Maximum number is " + e);
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
