package ojt.employee.app.bl.service;

import java.util.List;

import ojt.employee.app.bl.dto.EmployeeDTO;
import ojt.employee.app.web.form.EmployeeForm;

/**
 * <h2>EmployeeService Class</h2>
 * <p>
 * Process for Displaying EmployeeService
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public interface EmployeeService {

    /**
     * <h2>doAddEmployee</h2>
     * <p>
     * Insert Employee
     * </p>
     *
     * @param employeeForm EmployeeForm
     * @return void
     */
    public void doAddEmployee(EmployeeForm employeeFrom);

    /**
     * <h2>doListEmployees</h2>
     * <p>
     * List All Employee
     * </p>
     *
     * @return
     * @return List<EmployeeDTO>
     */
    public List<EmployeeDTO> doListEmployees();

    /**
     * <h2>doGetEmployeeById</h2>
     * <p>
     * Get Employee ID
     * </p>
     *
     * @param id int
     * @return
     * @return Employee
     */
    public EmployeeDTO doGetEmployeeById(int id);

    /**
     * <h2>doUpdateEmployee</h2>
     * <p>
     * Update Employee
     * </p>
     *
     * @param employeeForm EmployeeForm
     * @return void
     */
    public void doUpdateEmployee(EmployeeForm employeeForm);

    /**
     * <h2>doDeleteEmployee</h2>
     * <p>
     * Delete Employee
     * </p>
     *
     * @param id int
     * @return void
     */
    public void doDeleteEmployee(int id);
}