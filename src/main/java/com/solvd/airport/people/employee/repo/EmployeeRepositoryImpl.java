package com.solvd.airport.people.employee.repo;

import com.solvd.airport.exception.EntityAlreadyExistsException;
import com.solvd.airport.exception.NoSuchElementException;
import com.solvd.airport.people.employee.Employee;

import java.util.LinkedHashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private Set<Employee> employees = new LinkedHashSet<>();
    private static final EmployeeRepositoryImpl EMPLOYEE_REPOSITORY = new EmployeeRepositoryImpl();

    private EmployeeRepositoryImpl() {
    }

    public static EmployeeRepositoryImpl getEmployeeRepositoryImpl() {
        return EMPLOYEE_REPOSITORY;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee findEmployeeById(String id) {
        Employee employee = employees.stream().filter(e -> e.getId().equals(id)).findAny()
                .orElseThrow(() -> new NoSuchElementException("There is no employee with the given id: " + id));
        return employee;
    }

    @Override
    public Set<Employee> deleteEmployee(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
        } else {
            throw new NoSuchElementException("There was no such employee");
        }
        return employees;
    }
}