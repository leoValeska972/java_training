package testing;

import testing1.Student;
import testing1.StudentService;
import testing1.StudentServiceImpl;

/**
 * <h2>AccMod Class</h2>
 * <p>
 * Process for Displaying AccMod
 * </p>
 * 
 * @author User
 *
 */
public class AccMod {
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
        Student std = new Student();
        std.setName("Leo");
        System.out.println("1)Encapsulation with Access Modifier \n" + std.getName());

        StudentService ss = new StudentServiceImpl();
        ss.intro();
    }
}
