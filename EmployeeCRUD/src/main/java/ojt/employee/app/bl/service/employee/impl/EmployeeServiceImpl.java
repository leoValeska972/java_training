package ojt.employee.app.bl.service.employee.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ojt.employee.app.bl.dto.EmployeeDTO;
import ojt.employee.app.bl.service.employee.EmployeeService;
import ojt.employee.app.persistence.dao.employee.EmployeeDao;
import ojt.employee.app.persistence.entity.Employee;
import ojt.employee.app.web.form.EmployeeForm;

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
    private EmployeeDao employeeDao;

    /**
     * <h2>setemployeeDAO</h2>
     * <p>
     * set EmployeeDao
     * </p>
     *
     * @param employeeDao EmployeeDAO
     * @return void
     */
    public void setemployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /**
     * <h2>doAddEmployee</h2>
     * <p>
     * Insert Employee
     * </p>
     * 
     * @param employeeForm EmployeeForm
     */
    @Override
    public void doAddEmployee(EmployeeForm employeeForm) {
        Employee employee = new Employee(employeeForm);
        employeeDao.dbAddEmployee(employee);
    }

    /**
     * <h2>doListEmployees</h2>
     * <p>
     * List All Employees
     * </p>
     * 
     * @return List<EmployeeDTO>
     */
    @Override
    public List<EmployeeDTO> doListEmployees() {
        List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
        for (Employee employee : this.employeeDao.dbListEmployees()) {
            EmployeeDTO employeeDto = new EmployeeDTO(employee);
            employeeList.add(employeeDto);
        }
        return employeeList;
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
    public EmployeeDTO doGetEmployeeById(int id) {
        Employee employee = this.employeeDao.dbGetEmployeeById(id);
        EmployeeDTO employeeForm = employee != null ? new EmployeeDTO(employee) : null;
        return employeeForm;
    }

    /**
     * <h2>doUpdateEmployee</h2>
     * <p>
     * Update Employee
     * </p>
     * 
     * @param employeeForm EmployeeForm
     */
    @Override
    public void doUpdateEmployee(EmployeeForm employeeForm) {
        Employee employee = new Employee(employeeForm);
        employeeDao.dbUpdateEmployee(employee);
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
        employeeDao.dbDeleteEmployee(id);
    }
}