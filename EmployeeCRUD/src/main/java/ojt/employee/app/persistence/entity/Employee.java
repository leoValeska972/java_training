package ojt.employee.app.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ojt.employee.app.web.form.EmployeeForm;

/**
 * <h2>Employee Class</h2>
 * <p>
 * Process for Displaying Employee
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Entity
@Table(name = "Employee")
public class Employee {
    /**
     * <h2>eid</h2>
     * <p>
     * eid
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private Integer eid;

    /**
     * <h2>ename</h2>
     * <p>
     * ename
     * </p>
     */
    @Column(name = "Name")
    private String ename;

    /**
     * <h2>eage</h2>
     * <p>
     * eage
     * </p>
     */
    @Column(name = "Age")
    private Integer eage;

    /**
     * <h2>edept</h2>
     * <p>
     * edept
     * </p>
     */
    @Column(name = "Dept")
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
     * @param eid
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
     * @param ename
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
     * @param eage
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
     * @param edept
     * @return void
     */
    public void setEdept(String edept) {
        this.edept = edept;
    }

    public Employee() {
        super();
    }

    public Employee(EmployeeForm employeeForm) {
        super();
        this.eid = employeeForm.getEid();
        this.ename = employeeForm.getEname();
        this.eage = employeeForm.getEage();
        this.edept = employeeForm.getEdept();
    }
}
