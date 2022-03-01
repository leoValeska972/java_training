package tutorial;

import java.util.Scanner;

/**
 * <h2>Tutorial14 Class</h2>
 * <p>
 * Process for Displaying Tutorial14
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Tutorial14 {
    /**
     * <h2>main</h2>
     * <p>
     * Palindrome
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        String z = "";
        boolean b = true;
        boolean c = true;
        Scanner sc = new Scanner(System.in);
        do {
            String str = "";
            String rev = "";
            System.out.println("Enter a word in lower case: ");
            str = sc.nextLine();
            int length = str.length();
            for (int i = length - 1; i >= 0; i--) {
                rev = rev + str.charAt(i);
            }
            if (str.equalsIgnoreCase(rev)) {
                System.out.println(str + " is a palindrome");
            } else {
                System.out.println(str + " is not a palindrome");
            }
            System.out.println("Do you want to continue? yes/no?");
            z = sc.nextLine();
            if (z.equals("yes")) {
                b = true;
            } else if (z.equals("no")) {
                b = false;
            } else {
                do {
                    System.out.println("Type only yes or no");
                    z = sc.nextLine();
                    if (z.equals("yes")) {
                        c = false;
                    } else if (z.equals("no")) {
                        c = false;
                    } else {
                        c = true;
                    }
                } while (c == true);
            }
        } while (b == true);
        sc.close();
        System.out.println("Exit...");
    }
}
