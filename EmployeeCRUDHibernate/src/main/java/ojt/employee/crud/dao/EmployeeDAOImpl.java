package ojt.employee.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.employee.crud.model.Employee;

/**
 * <h2>EmployeeDAOImpl Class</h2>
 * <p>
 * Process for Displaying EmployeeDAOImpl
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;

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
        Session session = sessionFactory.getCurrentSession();
        session.persist(employee);
    }

    /**
     * <h2>updateEmployee</h2>
     * <p>
     * Update Employee
     * </p>
     * 
     * @param employee Employee
     */
    @Override
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }

    /**
     * <h2>listEmployees</h2>
     * <p>
     * List All Employees
     * </p>
     * 
     * @return List<Employee>
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> listEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> EmployeesList = session.createQuery("from Employee").list();
        return EmployeesList;
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
    @SuppressWarnings("removal")
    @Override
    public Employee getEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, new Integer(id));
        return employee;
    }

    /**
     * <h2>removeEmployee</h2>
     * <p>
     * Delete Employee
     * </p>
     * 
     * @param id int
     */
    @SuppressWarnings("removal")
    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, new Integer(id));
        if (null != employee) {
            session.delete(employee);
        }
    }
}