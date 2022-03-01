package com.javainterviewpoint;

import java.util.List;

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
     * <h2>saveEmployee</h2>
     * <p>
     * Insert Employee
     * </p>
     *
     * @param employee Employee
     * @return void
     */
    public void saveEmployee(Employee employee);

    /**
     * <h2>getEmployeeById</h2>
     * <p>
     * Get an Employee Id
     * </p>
     *
     * @param id int
     * @return
     * @return Employee
     */
    public Employee getEmployeeById(int id);

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
     * <h2>deleteEmployee</h2>
     * <p>
     * Delete Employee
     * </p>
     *
     * @param id int
     * @return void
     */
    public void deleteEmployee(int id);

    /**
     * <h2>getAllEmployees</h2>
     * <p>
     * Show All Employees
     * </p>
     *
     * @return
     * @return List<Employee>
     */
    public List<Employee> getAllEmployees();
}
