package testing;

/**
 * <h2>Test Class</h2>
 * <p>
 * Process for Displaying Test
 * </p>
 * 
 * @author User
 *
 */
public class Test {
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
        // declare variables and assign values
        int a = 10; // -2147483648 to 2147483647
        int b = 15;
        String c = "Rounds"; // word
        byte d = 25; // -128 to 127
        short e = 125; // -128 to 127
        long f = 12345L; // -9223372036854775808 to 9223372036854775807
        float g = 5.9f; // 3.4e−038 to 3.4e+038
        double h = 5.8d; // 1.7e−308 to 1.7e+308
        boolean i = true; // true or false
        char j = 'j'; // character

        System.out.println("Variables");
        System.out.println("int " + a);
        System.out.println("String " + c);
        System.out.println("byte " + d);
        System.out.println("short " + e);
        System.out.println("long " + f);
        System.out.println("float " + g);
        System.out.println("double " + h);
        System.out.println("boolean " + i);
        System.out.println("char " + j + "\n");

        System.out.println("Arithmetic Operators");
        System.out.println("Sum of a and b is " + (a + b));
        System.out.println("Subtraction of a and b is " + (a - b));
        System.out.println("Multiplication of a and b is " + (a * b));
        System.out.println("Division of a and b is " + (a / b));
        System.out.println("Modulus of a and b is " + (a % b) + "\n");

        System.out.println("Assignment Operators");
        a += 5;
        System.out.println("Add 5 to a is " + a);
        b -= 5;
        System.out.println("Substract 5 from b is " + b);
        b -= 5;
        System.out.println("Substract 5 from b is " + b);
        a *= 5;
        System.out.println("Multiply a with 5 is " + a);
        b /= 5;
        System.out.println("Divide b by 5 is " + b);
        b %= 5;
        System.out.println("Modulus b by 5 is " + b + "\n");

        System.out.println("Comparison & Ternary & Relational Operators");
        i = (a >= 5) ? true : false;
        System.out.println("A is greater than or equal 5 is " + i);
        i = (a < 5) ? true : false;
        System.out.println("A is less than 5 is " + i);
        i = (a != 5) ? true : false;
        System.out.println("A is not equal 5 is " + i);
        i = (a == 5) ? true : false;
        System.out.println("A is equal to 5 is " + i);

        System.out.println("Logical & Ternary & Relational Operators");
        i = (a > 5 && a == 75) ? true : false;
        System.out.println("A is greater than 5 and a is equal to 5 is " + i);
        i = (a < 5 && a == 75) ? true : false;
        System.out.println("A is less than 5 and a is equal to 5 is " + i);
        i = (a < 5 || a == 1) ? true : false;
        System.out.println("A is less than than 5 or a is equal to 1 is " + i);
        i = (a < 5 || a == 75) ? true : false;
        System.out.println("A is less than than 5 or a is equal to 75 is " + i);
        i = !(a < 5 || a == 75) ? true : false;
        System.out.println("A is less than than 5 or a is equal to 75 is " + i + "\n");

        System.out.println("Unary Operators");
        System.out.println("Normal a is " + a);
        a++;
        System.out.println("a after using increment  is " + a);
        a--;
        System.out.println("a after using decrement  is " + a);

    }
}
