package ojt.employee.crud.dao;

import java.util.List;

import ojt.employee.crud.model.Employee;

/**
 * <h2>EmployeeDAO Class</h2>
 * <p>
 * Process for Displaying EmployeeDAO
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public interface EmployeeDAO {

    /**
     * <h2>addEmployee</h2>
     * <p>
     * Insert Employee
     * </p>
     *
     * @param employee Employee
     * @return void
     */
    public void addEmployee(Employee employee);

    /**
     * <h2>updateEmployee</h2>
     * <p>
     * Update Employee
     * </p>
     *
     * @param employee Employee
     * @return void
     */
    public void updateEmployee(Employee employee);

    /**
     * <h2>getEmployeeById</h2>
     * <p>
     * Get Employee ID
     * </p>
     *
     * @param id int
     * @return
     * @return Employee
     */
    public Employee getEmployeeById(int id);

    /**
     * <h2>removeEmployee</h2>
     * <p>
     * Delete Employee
     * </p>
     *
     * @param id int
     * @return void
     */
    public void deleteEmployee(int id);

    /**
     * <h2>listEmployees</h2>
     * <p>
     * List All Employees
     * </p>
     *
     * @return
     * @return List<Employee>
     */
    public List<Employee> listEmployees();

}