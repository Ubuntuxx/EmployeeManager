package tech.springbotapp.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.springbotapp.employeemanager.model.Employee;
import tech.springbotapp.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new UserNotFoundException("El usuario " + id + "no existe"));
    }

    public void deleteEmployee(long id) {
        employeeRepo.deleteById(id);
    }
}
