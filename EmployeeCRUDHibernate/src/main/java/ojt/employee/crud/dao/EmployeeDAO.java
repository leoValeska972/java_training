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
     * <h2>dbAddEmployee</h2>
     * <p>
     * Add Employee
     * </p>
     *
     * @param employee Employee
     * @return void
     */
    public void dbAddEmployee(Employee employee);

    /**
     * <h2>dbUpdateEmployee</h2>
     * <p>
     * Update Employee
     * </p>
     *
     * @param employee Employee
     * @return void
     */
    public void dbUpdateEmployee(Employee employee);

    /**
     * <h2>dbGetEmployeeById</h2>
     * <p>
     * Get Employee ID
     * </p>
     *
     * @param id int
     * @return
     * @return Employee
     */
    public Employee dbGetEmployeeById(int id);

    /**
     * <h2>dbDeleteEmployee</h2>
     * <p>
     * Delete Employee
     * </p>
     *
     * @param id int
     * @return void
     */
    public void dbDeleteEmployee(int id);

    /**
     * <h2>dbListEmployees</h2>
     * <p>
     * List All Employees
     * </p>
     *
     * @return
     * @return List<Employee>
     */
    public List<Employee> dbListEmployees();
}