package tutorial;

import java.util.Scanner;

/**
 * <h2>Tutorial9C Class</h2>
 * <p>
 * Process for Displaying Tutorial9C
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial9C {
    /**
     * <h2>main</h2>
     * <p>
     * Finding Leap Years
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        int z;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter Year : ");
            int y = sc.nextInt();
            if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
                System.out.println("This is a Leap Year");
            } else {
                System.out.println("This is not a Leap Year");
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
