package com.javainterviewpoint;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
     * <h2>jdbcTemplate</h2>
     * <p>
     * jdbcTemplate
     * </p>
     */
    private JdbcTemplate jdbcTemplate;

    /**
     * <h2>setJdbcTemplate</h2>
     * <p>
     * Set JDBC Tamplate
     * </p>
     *
     * @param jdbcTemplate JdbcTemplate
     * @return void
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * <h2>saveEmployee</h2>
     * <p>
     * Insert Employee
     * </p>
     * 
     * @param employee Employee
     */
    public void saveEmployee(Employee employee) {
        String sql = "insert into Employee values(?,?,?,?)";
        jdbcTemplate.update(sql,
                new Object[] { employee.getId(), employee.getName(), employee.getDept(), employee.getAge() });
    }

    /**
     * <h2>getEmployeeById</h2>
     * <p>
     * Get an Employee Id
     * </p>
     * 
     * @param id int
     * @return employee Employee
     */
    public Employee getEmployeeById(int id) {
        String sql = "select * from Employee where id=?";
        @SuppressWarnings("deprecation")
        Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee employee = new Employee();
                employee.setId(rs.getInt(1));
                employee.setName(rs.getString(2));
                employee.setDept(rs.getString(3));
                employee.setAge(rs.getInt(4));
                return employee;
            }
        });
        return employee;
    }

    /**
     * <h2>getAllEmployees</h2>
     * <p>
     * Show All Employees
     * </p>
     * 
     * @return List<Employee>
     */
    public List<Employee> getAllEmployees() {
        String sql = "select * from Employee";

        List<Employee> employeeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>() {
            @Override
            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Employee> list = new ArrayList<Employee>();
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setId(rs.getInt(1));
                    employee.setName(rs.getString(2));
                    employee.setDept(rs.getString(3));
                    employee.setAge(rs.getInt(4));
                    list.add(employee);
                }
                return list;
            }
        });
        return employeeList;
    }

    /**
     * <h2>updateEmployee</h2>
     * <p>
     * Update Employee
     * </p>
     * 
     * @param employee Employee
     */
    public void updateEmployee(Employee employee) {
        String sql = "update Employee set age =?, dept=?,name=? where id=?";
        jdbcTemplate.update(sql,
                new Object[] { employee.getAge(), employee.getDept(), employee.getName(), employee.getId() });
    }

    /**
     * <h2>deleteEmployee</h2>
     * <p>
     * Delete Employee
     * </p>
     * 
     * @param id
     */
    public void deleteEmployee(int id) {
        String sql = "delete from employee where id=?";
        jdbcTemplate.update(sql, new Object[] { id });
    }
}
