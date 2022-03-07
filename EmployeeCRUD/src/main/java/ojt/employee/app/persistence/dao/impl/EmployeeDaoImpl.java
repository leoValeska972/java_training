package ojt.employee.app.persistence.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.employee.app.persistence.dao.EmployeeDao;
import ojt.employee.app.persistence.entity.Employee;

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
public class EmployeeDaoImpl implements EmployeeDao {

    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <h2>SELECT_STUDENT_HQL</h2>
     * <p>
     * SELECT_STUDENT_HQL
     * </p>
     */
    private static final String SELECT_EMPLOYEE_HQL = "SELECT " + "e " + "FROM Employee e ";

    /**
     * <h2>dbAddEmployee</h2>
     * <p>
     * Insert Employee
     * </p>
     * 
     * @param employee Employee
     */
    @Override
    public void dbAddEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(employee);
    }

    /**
     * <h2>dbListEmployees</h2>
     * <p>
     * List All Employees
     * </p>
     * 
     * @return List<Employee>
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> dbListEmployees() {
        return this.sessionFactory.getCurrentSession().createQuery(SELECT_EMPLOYEE_HQL).list();
    }

    /**
     * <h2>dbGetEmployeeById</h2>
     * <p>
     * Get Employee ID
     * </p>
     * 
     * @param id int
     * @return
     */
    @SuppressWarnings("removal")
    @Override
    public Employee dbGetEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, new Integer(id));
        return employee;
    }

    /**
     * <h2>dbUpdateEmployee</h2>
     * <p>
     * Update Employee
     * </p>
     * 
     * @param employee Employee
     */
    @Override
    public void dbUpdateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }

    /**
     * <h2>dbDeleteEmployee</h2>
     * <p>
     * Delete Employee
     * </p>
     * 
     * @param id int
     */
    @SuppressWarnings("removal")
    @Override
    public void dbDeleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, new Integer(id));
        if (null != employee) {
            session.delete(employee);
        }
    }
}