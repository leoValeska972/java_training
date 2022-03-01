package testing1;

/**
 * <h2>Animal Class</h2>
 * <p>
 * Process for Displaying Animal
 * </p>
 * 
 * @author User
 *
 */
class Animal {
    /**
     * <h2>eat</h2>
     * <p>
     * Eat Method
     * </p>
     *
     * @return void
     */
    void eat() {
        System.out.println("2)Inheritance\nEating");
    }
}

/**
 * <h2>Dog Class</h2>
 * <p>
 * Process for Displaying Dog
 * </p>
 * 
 * @author User
 *
 */
public class Dog extends Animal {
    /**
     * <h2>bark</h2>
     * <p>
     * Bark Method
     * </p>
     *
     * @return void
     */
    void bark() {
        System.out.println("Bark...");
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
        Dog d = new Dog();
        d.eat();
        d.bark();
    }
}
