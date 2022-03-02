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
     * <h2>doAddEmployee</h2>
     * <p>
     * Insert Employee
     * </p>
     * 
     * @param employee Employee
     */
    @Override
    public void doAddEmployee(Employee employee) {
        employeeDAO.dbAddEmployee(employee);
    }

    /**
     * <h2>doUpdateEmployee</h2>
     * <p>
     * Update Employee
     * </p>
     * 
     * @param employeeEmployee
     */
    @Override
    public void doUpdateEmployee(Employee employee) {
        employeeDAO.dbUpdateEmployee(employee);
    }

    /**
     * <h2>doListEmployees</h2>
     * <p>
     * List All Employees
     * </p>
     * 
     * @return List<Employee>
     */
    @Override
    public List<Employee> doListEmployees() {
        return this.employeeDAO.dbListEmployees();
    }

    /**
     * <h2>doGetEmployeeById</h2>
     * <p>
     * Get Employee ID
     * </p>
     * 
     * @param id int
     * @return
     */
    @Override
    public Employee doGetEmployeeById(int id) {
        return employeeDAO.dbGetEmployeeById(id);
    }

    /**
     * <h2>doDeleteEmployee</h2>
     * <p>
     * Delete Employee
     * </p>
     * 
     * @param id int
     */
    @Override
    public void doDeleteEmployee(int id) {
        employeeDAO.dbDeleteEmployee(id);
    }
}