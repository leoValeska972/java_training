package ojt.employee.app.web.form;

import javax.validation.constraints.*;

import org.springframework.stereotype.Component;

/**
 * <h2>Employee Class</h2>
 * <p>
 * Process for Displaying Employee
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Component
public class EmployeeForm {
    /**
     * <h2>eid</h2>
     * <p>
     * eid
     * </p>
     */
    private Integer eid;

    /**
     * <h2>ename</h2>
     * <p>
     * ename
     * </p>
     */
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z_ ]*$")
    @Size(max = 30)
    private String ename;

    /**
     * <h2>eage</h2>
     * <p>
     * eage
     * </p>
     */
    @NotNull
    @Min(value = 18)
    @Max(value = 60)
    private Integer eage;

    /**
     * <h2>edept</h2>
     * <p>
     * edept
     * </p>
     */
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z_ ]*$")
    @Size(max = 30)
    private String edept;

    /**
     * <h2>getEid</h2>
     * <p>
     * Get Employee ID
     * </p>
     *
     * @return
     * @return Integer
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * <h2>setEid</h2>
     * <p>
     * Set Employee ID
     * </p>
     *
     * @param eid Integer
     * @return void
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * <h2>getEname</h2>
     * <p>
     * Get Employee Name
     * </p>
     *
     * @return
     * @return String
     */
    public String getEname() {
        return ename;
    }

    /**
     * <h2>setEname</h2>
     * <p>
     * Set Employee Name
     * </p>
     *
     * @param ename String
     * @return void
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * <h2>getEage</h2>
     * <p>
     * Get Employee Age
     * </p>
     *
     * @return
     * @return Integer
     */
    public Integer getEage() {
        return eage;
    }

    /**
     * <h2>setEage</h2>
     * <p>
     * Set Employee Age
     * </p>
     *
     * @param eage Integer
     * @return void
     */
    public void setEage(Integer eage) {
        this.eage = eage;
    }

    /**
     * <h2>getEdept</h2>
     * <p>
     * Get Employee Department
     * </p>
     *
     * @return
     * @return String
     */
    public String getEdept() {
        return edept;
    }

    /**
     * <h2>setEdept</h2>
     * <p>
     * Set Employee Department
     * </p>
     *
     * @param edept String
     * @return void
     */
    public void setEdept(String edept) {
        this.edept = edept;
    }
}