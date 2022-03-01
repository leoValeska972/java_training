package jdbcioe;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * <h2>Jio Class</h2>
 * <p>
 * Process for Displaying Jio
 * </p>
 * 
 * @author User
 *
 */
public class Jio {
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
        try {
            FileOutputStream fout = new FileOutputStream("D:\\GitHub\\java_training\\test\\src\\jdbcioe\\text.txt");
            String s = "This is a test.";
            byte b[] = s.getBytes();
            fout.write(b);
            fout.close();
            System.out.println("Writing Successful...");

            FileInputStream input = new FileInputStream("D:\\GitHub\\java_training\\test\\src\\jdbcioe\\text.txt");
            System.out.println("\nData in the file is");
            int i = input.read();
            while (i != -1) {
                System.out.print((char) i);
                i = input.read();
            }
            input.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}
