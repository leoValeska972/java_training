package testing1;

/**
 * <h2>a Class</h2>
 * <p>
 * Process for Displaying a
 * </p>
 * 
 * @author User
 *
 */
class a {
    /**
     * <h2>area</h2>
     * <p>
     * Area Method
     * </p>
     *
     * @param b int
     * @param h int
     * @return void
     */
    void area(int b, int h) {
        System.out.println("Triangle area=" + 0.5 * b * h);
    }
}

/**
 * <h2>Area Class</h2>
 * <p>
 * Process for Displaying Area
 * </p>
 * 
 * @author User
 *
 */
public class Area extends a {
    /**
     * <h2>area</h2>
     * <p>
     * Area Method
     * </p>
     *
     * @return void
     */
    public void area() {
        System.out.println("4)polymorphism Method Overloading and Overriding\n");
    }

    /**
     * <h2>area</h2>
     * <p>
     * Area Method
     * </p>
     *
     * @param r int
     * @return void
     */
    public void area(int r) {
        System.out.println("Circle area = " + 3.14 * r * r);
    }

    /**
     * <h2>area</h2>
     * <p>
     * Area Method
     * </p>
     * 
     * @param l int
     * @param b int
     */
    public void area(int l, int b) {
        System.out.println("Rectangle area=" + l * b);
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
        Area ar = new Area();
        ar.area();
        ar.area(5);
        ar.area(15, 15);
    }
}
