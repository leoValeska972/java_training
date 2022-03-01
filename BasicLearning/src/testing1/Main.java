package testing1;

/**
 * <h2>Bird Class</h2>
 * <p>
 * Process for Displaying Bird
 * </p>
 * 
 * @author User
 *
 */
interface Bird {
    /**
     * <h2>tweet</h2>
     * <p>
     * Tweet Function
     * </p>
     *
     * @return void
     */
    void tweet();

    /**
     * <h2>eat</h2>
     * <p>
     * Eat Function
     * </p>
     *
     * @return void
     */
    void eat();
}

/**
 * <h2>B1 Class</h2>
 * <p>
 * Process for Displaying B1
 * </p>
 * 
 * @author User
 *
 */
abstract class B1 implements Bird {
    /**
     * <h2>eat</h2>
     * <p>
     * Eat Function
     * </p>
     * 
     */
    @Override
    public void eat() {
        System.out.println("3)Abstractction with Interface\nEating");
    }
}

/**
 * <h2>b2 Class</h2>
 * <p>
 * Process for Displaying b2
 * </p>
 * 
 * @author User
 *
 */
class b2 extends B1 {
    /**
     * <h2>tweet</h2>
     * <p>
     * Tweet Function
     * </p>
     * 
     */
    @Override
    public void tweet() {
        System.out.println("Tweet Twet");
    }

}

/**
 * <h2>Main Class</h2>
 * <p>
 * Process for Displaying Main
 * </p>
 * 
 * @author User
 *
 */
public class Main {
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
        b2 b = new b2();
        b.eat();
        b.tweet();
    }
}
