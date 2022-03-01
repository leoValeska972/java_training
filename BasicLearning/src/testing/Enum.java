package testing;

/**
 * <h2>Enum Class</h2>
 * <p>
 * Process for Displaying Enum
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Enum {
    /**
     * <h2>Season Class</h2>
     * <p>
     * Process for Displaying Season
     * </p>
     * 
     * @author ZawLwinTun
     *
     */
    public enum Season {
        WINTER, SPRING, SUMMER, FALL
    }

    /**
     * <h2>main</h2>
     * <p>
     * Enum
     * </p>
     *
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        for (Season s : Season.values()) {
            System.out.println(s);
        }
        System.out.println("Value of WINTER is: " + Season.valueOf("WINTER"));
        System.out.println("Index of WINTER is: " + Season.valueOf("WINTER").ordinal());
        System.out.println("Index of SUMMER is: " + Season.valueOf("SUMMER").ordinal());
    }
}
