package testing;

/**
 * <h2>TestMethod Class</h2>
 * <p>
 * Process for Displaying TestMethod
 * </p>
 * 
 * @author User
 *
 */
public class TestMethod {
    // normal method
    /**
     * <h2>sum</h2>
     * <p>
     * Sum Method
     * </p>
     *
     * @param a int
     * @param b int
     * @return
     * @return int
     */
    public int sum(int a, int b) {
        int c = a + b;
        return c;
    }

    // static method with if else
    /**
     * <h2>checkNum</h2>
     * <p>
     * Check Number Method
     * </p>
     *
     * @param a int
     * @return
     * @return String
     */
    public static String checkNum(int a) {
        String result = "";
        if (a % 2 == 0) {
            result = "This number " + a + " is Even";
        } else {
            result = "This number " + a + " is Odd";
        }
        return result;
    }

    // nested if
    /**
     * <h2>marks</h2>
     * <p>
     * Marks Method
     * </p>
     *
     * @param a int
     * @return
     * @return String
     */
    public String marks(int a) {
        String status = "";
        if (a > 0 && a < 40) {
            status = "Exam Fail";
        } else if (a >= 40 && a < 80) {
            status = "Exam Pass";
        } else if (a >= 80 && a <= 100) {
            status = "Exam Pass With Flying Colors";
        } else if (a < 0 || a > 100) {
            status = "Invalid Mark";
        }
        return status;
    }

    // switch case
    /**
     * <h2>days</h2>
     * <p>
     * Days Method
     * </p>
     *
     * @param a int
     * @return void
     */
    public void days(int a) {
        switch (a) {
        case 1:
            System.out.println("Today is Monday");
            break;
        case 2:
            System.out.println("Today is Tuesday");
            break;
        case 3:
            System.out.println("Today is Wednesday");
            break;
        case 4:
            System.out.println("Today is Thursday");
            break;
        case 5:
            System.out.println("Today is Friday");
            break;
        case 6:
            System.out.println("Today is Saturday");
            break;
        case 7:
            System.out.println("Today is Sunday");
            break;
        default:
            System.out.println("Today is Day Unknown");
        }
    }

    /**
     * <h2>main</h2>
     * <p>
     * Main Method
     * </p>
     *
     * @param args String
     * @return void
     */
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        int mark = 78;

        TestMethod myMethod = new TestMethod();

        int z = myMethod.sum(x, y);
        System.out.println("The sum of two numbers is " + z + "\n");

        System.out.println(checkNum(x));
        System.out.println(checkNum(y));

        System.out.println("\n" + myMethod.marks(mark) + "\n");

        myMethod.days(x);
        System.out.println();

        // for loop
        for (int i = 1; i < 5; i++) {
            if (i == 3) {
                break;
            }
            System.out.println(i);
        }
        System.out.println();

        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println(i);
        }
        System.out.println();

        // for each loop
        int[] j = { 1, 2, 3, 4, 5 };
        for (int i : j) {
            System.out.println(i);
        }
        System.out.println();

        // while loop
        while (x <= 10) {
            System.out.println(x);
            x++;
        }
        System.out.println();

        // do while loop
        do {
            System.out.println(x);
            x++;
        } while (x <= 10);
    }
}
