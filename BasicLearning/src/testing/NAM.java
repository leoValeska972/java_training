package testing;

/**
 * <h2>NAM Class</h2>
 * <p>
 * Process for Displaying NAM
 * </p>
 * 
 * @author User
 *
 */
public class NAM {
    double PI = 3.14;

    /**
     * <h2>myStaticMethod</h2>
     * <p>
     * Static Method
     * </p>
     *
     * @return void
     */
    static void myStaticMethod() {
        System.out.println("Static methods can be called without creating objects");
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
        NAM nam = new NAM();
        nam.PI = 34.1; // can't assign value because of final keyword
        System.out.println(nam.PI);
        myStaticMethod();
    }
}
