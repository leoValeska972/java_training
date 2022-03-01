package ojt.employee.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ojt.employee.crud.dao.EmployeeDAO;
import ojt.employee.crud.model.Employee;

/**
 * <h2>EmployeeServiceImpl Class</h2>
 * <p>
 * Process for Displaying EmployeeServiceImpl
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    /**
     * <h2>employeeDAO</h2>
     * <p>
     * employeeDAO
     * </p>
     */
    @Autowired
    private EmployeeDAO employeeDAO;

    /**
     * <h2>setemployeeDAO</h2>
     * <p>
     * set EmployeeDao
     * </p>
     *
     * @param employeeDao EmployeeDAO
     * @return void
     */
    public void setemployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    /**
     * <h2>addEmployee</h2>
     * <p>
     * Insert Employee
     * </p>
     * 
     * @param employee Employee
     */
    @Override
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    /**
     * <h2>updateEmployee</h2>
     * <p>
     * Update Employee
     * </p>
     * 
     * @param employeeEmployee
     */
    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    /**
     * <h2>listEmployees</h2>
     * <p>
     * List All Employees
     * </p>
     * 
     * @return List<Employee>
     */
    @Override
    public List<Employee> listEmployees() {
        return this.employeeDAO.listEmployees();
    }

    /**
     * <h2>getEmployeeById</h2>
     * <p>
     * Get Employee ID
     * </p>
     * 
     * @param id int
     * @return
     */
    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    /**
     * <h2>removeEmployee</h2>
     * <p>
     * Delete Employee
     * </p>
     * 
     * @param id int
     */
    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}