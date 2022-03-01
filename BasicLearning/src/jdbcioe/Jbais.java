package jdbcioe;

import java.io.ByteArrayInputStream;

/**
 * <h2>Jbais Class</h2>
 * <p>
 * Process for Displaying Jbais
 * </p>
 * 
 * @author User
 *
 */
public class Jbais {
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
        byte[] array = { 1, 2, 3, 4 };
        try {
            ByteArrayInputStream input = new ByteArrayInputStream(array);
            System.out.print("The bytes read from the input stream: ");
            for (int i = 0; i < array.length; i++) {
                int data = input.read();
                System.out.print(data + ", ");
            }
            input.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
