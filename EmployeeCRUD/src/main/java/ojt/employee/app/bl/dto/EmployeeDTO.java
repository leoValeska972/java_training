package ojt.employee.app.bl.dto;

import ojt.employee.app.persistence.entity.Employee;

/**
 * <h2>EmployeeDTO Class</h2>
 * <p>
 * Process for Displaying EmployeeDTO
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class EmployeeDTO {
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
    private String ename;
    /**
     * <h2>eage</h2>
     * <p>
     * eage
     * </p>
     */
    private Integer eage;
    /**
     * <h2>edept</h2>
     * <p>
     * edept
     * </p>
     */
    private String edept;

    /**
     * <h2>getEid</h2>
     * <p>
     * Get Employee Id
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
     * Set Employee Id
     * </p>
     *
     * @param eid
     * @return void
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * <h2>getEname</h2>
     * <p>
     * get Employee Name
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
     * set Employee Name
     * </p>
     *
     * @param ename
     * @return void
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * <h2>getEage</h2>
     * <p>
     * get Employee Age
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
     * set Employee Age
     * </p>
     *
     * @param eage
     * @return void
     */
    public void setEage(Integer eage) {
        this.eage = eage;
    }

    /**
     * <h2>getEdept</h2>
     * <p>
     * get Employee Department
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
     * set Employee Department
     * </p>
     *
     * @param edept
     * @return void
     */
    public void setEdept(String edept) {
        this.edept = edept;
    }

    /**
     * <h2>Constructor for EmployeeDTO</h2>
     * <p>
     * Constructor for EmployeeDTO
     * </p>
     */
    public EmployeeDTO() {
        super();
    }

    /**
     * <h2>Constructor for EmployeeDTO</h2>
     * <p>
     * Constructor for EmployeeDTO
     * </p>
     * 
     * @param employee Employee
     */
    public EmployeeDTO(Employee employee) {
        super();
        this.eid = employee.getEid();
        this.ename = employee.getEname();
        this.eage = employee.getEage();
        this.edept = employee.getEdept();
    }
}