package testing;

/**
 * <h2>Info Class</h2>
 * <p>
 * Process for Displaying Info
 * </p>
 * 
 * @author User
 *
 */
abstract class Info {
    public String name = "Leo";
    public int age = 22;

    /**
     * <h2>work</h2>
     * <p>
     * Work Method
     * </p>
     *
     * @return void
     */
    public abstract void work();
}

/**
 * <h2>Person Class</h2>
 * <p>
 * Process for Displaying Person
 * </p>
 * 
 * @author User
 *
 */
class Person extends Info {
    public int salary = 250000;

    /**
     * <h2>work</h2>
     * <p>
     * Work Method
     * </p>
     * 
     */
    public void work() {
        System.out.println("Working all day long");
    }
}

/**
 * <h2>ANAM Class</h2>
 * <p>
 * Process for Displaying ANAM
 * </p>
 * 
 * @author User
 *
 */
public class ANAM {
    /**
     * <h2>main</h2>
     * <p>
     * Main Method
     * </p>
     *
     * @param args Strings
     * @return void
     */
    public static void main(String[] args) {
        Person myObj = new Person();
        System.out.println("Name: " + myObj.name);
        System.out.println("Age: " + myObj.age);
        System.out.println("Salary: " + myObj.salary + " mmk");
        myObj.work();
    }
}