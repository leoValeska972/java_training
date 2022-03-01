package tutorial;

import java.util.Scanner;

/**
 * <h2>Tutorial13 Class</h2>
 * <p>
 * Process for Displaying Tutorial13
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial13 {
    /**
     * <h2>main</h2>
     * <p>
     * Fibonacci Series
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int z;
        boolean b = true;
        do {
            int f1 = 1;
            int f2 = 2;
            int t = 1;
            System.out.println("Input n : ");
            int n = sc.nextInt();
            System.out.print("Fionacci Series is ");
            while (t <= n) {
                if (t == n) {
                    System.out.print(f1 + "\n\n");
                } else {
                    System.out.print(f1 + ", ");
                }
                int f3 = f2 + f1;
                f1 = f2;
                f2 = f3;
                t++;
            }
            do {
                System.out.println("Please only enter 1 as yes and 2 as no.");
                System.out.println("Do you want to continue? 1=y/2=n?");
                z = sc.nextInt();
                if (z > 2 || z <= 0) {
                    b = true;
                } else {
                    b = false;
                }
            } while (b == true);
        } while (z != 2);
        sc.close();
        System.out.println("Exit...");
    }
}
