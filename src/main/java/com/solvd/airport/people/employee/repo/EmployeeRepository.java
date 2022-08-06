package com.solvd.airport.people.employee.repo;

import com.solvd.airport.people.employee.Employee;

import java.util.Set;

public interface EmployeeRepository {

    /**
     * Adds employee to the employees repository
     */
    Employee addEmployee(Employee employee);

    /**
     * Finds employee by employee`s id
     */
    Employee findEmployeeById(String id);

    /**
     * Deletes employee from the employee' repository if it is present
     */
    Set<Employee> deleteEmployee(Employee employee);

}
