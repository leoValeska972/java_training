package testing;

/**
 * <h2> StringB Class</h2>
 * <p>
 * Process for Displaying StringB
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class StringB {
    /**
     * <h2> main</h2>
     * <p>
     * StringBuider
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello ");
        System.out.println("sb's capacity : " + sb.capacity());
        sb.append("World!");
        System.out.println("Append \"World!\" to sb : " + sb);
        sb.insert(6, "the ");
        System.out.println("Insert \"the \" to sb : " + sb);
        sb.replace(10, 15, "Leo");
        System.out.println("Replace \"Leo\" with \"World\" in sb : " + sb);
        sb.delete(6, 10);
        System.out.println("Replace \"the \" from sb : " + sb);
        sb.reverse();
        System.out.println("Reverse sb : " + sb);
        System.out.println("sb's capacity : " + sb.capacity());
    }
}
