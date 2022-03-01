package com.javainterviewpoint;

import java.io.Serializable;

/**
 * <h2>Employee Class</h2>
 * <p>
 * Process for Displaying Employee
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = -1280037900360314186L;
    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
    private Integer id;
    /**
     * <h2>name</h2>
     * <p>
     * name
     * </p>
     */
    private String name;
    /**
     * <h2>age</h2>
     * <p>
     * age
     * </p>
     */
    private Integer age;
    /**
     * <h2>dept</h2>
     * <p>
     * dept
     * </p>
     */
    private String dept;

    /**
     * <h2>Constructor for Employee</h2>
     * <p>
     * Constructor for Employee
     * </p>
     */
    public Employee() {
        super();
    }

    /**
     * <h2>Constructor for Employee</h2>
     * <p>
     * Constructor for Employee
     * </p>
     * 
     * @param id   Integer
     * @param name String
     * @param dept String
     * @param age  String
     */
    public Employee(Integer id, String name, String dept, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.age = age;
    }

    /**
     * <h2>getId</h2>
     * <p>
     * Get Id
     * </p>
     *
     * @return
     * @return Integer
     */
    public Integer getId() {
        return id;
    }

    /**
     * <h2>setId</h2>
     * <p>
     * Set Id
     * </p>
     *
     * @param id Integer
     * @return void
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <h2>getName</h2>
     * <p>
     * Get Name
     * </p>
     *
     * @return
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * <h2>setName</h2>
     * <p>
     * Set Name
     * </p>
     *
     * @param name String
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <h2>getDept</h2>
     * <p>
     * Get Department
     * </p>
     *
     * @return
     * @return String
     */
    public String getDept() {
        return dept;
    }

    /**
     * <h2>setDept</h2>
     * <p>
     * Set Department
     * </p>
     *
     * @param dept String
     * @return void
     */
    public void setDept(String dept) {
        this.dept = dept;
    }

    /**
     * <h2>getAge</h2>
     * <p>
     * Get Age
     * </p>
     *
     * @return
     * @return Integer
     */
    public Integer getAge() {
        return age;
    }

    /**
     * <h2>setAge</h2>
     * <p>
     * Set Age
     * </p>
     *
     * @param age Integer
     * @return void
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}