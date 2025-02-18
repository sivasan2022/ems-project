package net.springbootprojects.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.springbootprojects.ems_backend.dto.EmployeeDto;
import net.springbootprojects.ems_backend.entity.Department;
import net.springbootprojects.ems_backend.entity.Employee;
import net.springbootprojects.ems_backend.exception.ResourceNotFoundException;
import net.springbootprojects.ems_backend.mapper.EmployeeMapper;
import net.springbootprojects.ems_backend.repository.DepartmentRepository;
import net.springbootprojects.ems_backend.repository.EmployeeRepository;
import net.springbootprojects.ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Department department = departmentRepository.findById(employeeDto.getDepartmentId()).
                orElseThrow(() -> new ResourceNotFoundException("Department does not exist"));
        employee.setDepartment(department);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist in the given id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> employees = employeeRepository.findAll();
       return employees.stream()
               .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with given Id : " + employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Department department = departmentRepository.findById(updatedEmployee.getDepartmentId()).
                orElseThrow(() -> new ResourceNotFoundException("Department does not exist"));
        employee.setDepartment(department);
        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with given Id : " + employeeId));
        employeeRepository.deleteById(employeeId);
    }


}
