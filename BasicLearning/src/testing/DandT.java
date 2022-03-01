package testing;

import java.util.Calendar;

/**
 * <h2>DandT Class</h2>
 * <p>
 * Process for Displaying DandT
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class DandT {
    /**
     * <h2>main</h2>
     * <p>
     * Date and Time
     * </p>
     *
     * @param args String[]
     * @return void
     */
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("At present Calendar's Year : " + calendar.get(Calendar.YEAR));
        System.out.println("At present Calendar's Day : " + calendar.get(Calendar.DATE));
        System.out.println("At present Calendar's Date and Time : " + calendar.getTime());
    }
}
