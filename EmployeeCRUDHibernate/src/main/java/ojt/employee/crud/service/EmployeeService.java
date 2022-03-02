package ojt.employee.crud.service;

import java.util.List;

import ojt.employee.crud.model.Employee;

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
     * @param employee Employee
     * @return void
     */
    public void doAddEmployee(Employee employee);

    /**
     * <h2>doUpdateEmployee</h2>
     * <p>
     * Update Employee
     * </p>
     *
     * @param employee Employee
     * @return void
     */
    public void doUpdateEmployee(Employee employee);

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
    public Employee doGetEmployeeById(int id);

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

    /**
     * <h2>doListEmployees</h2>
     * <p>
     * List All Employee
     * </p>
     *
     * @return
     * @return List<Employee>
     */
    public List<Employee> doListEmployees();
}