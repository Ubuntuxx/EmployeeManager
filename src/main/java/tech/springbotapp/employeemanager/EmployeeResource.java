package tech.springbotapp.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.springbotapp.employeemanager.model.Employee;
import tech.springbotapp.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<List<Employee>> getEmployeeById(@PathVariable Long id) {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
