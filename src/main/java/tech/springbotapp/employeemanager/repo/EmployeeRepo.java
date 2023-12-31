package tech.springbotapp.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tech.springbotapp.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
