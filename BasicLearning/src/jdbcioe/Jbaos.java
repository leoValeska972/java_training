package jdbcioe;

import java.io.ByteArrayOutputStream;

/**
 * <h2>Jbaos Class</h2>
 * <p>
 * Process for Displaying Jbaos
 * </p>
 * 
 * @author User
 *
 */
public class Jbaos {
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
        String data = "This is a test.";
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] array = data.getBytes();
            out.write(array);
            String streamData = out.toString();
            System.out.println("Output stream: " + streamData);
            out.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

}
