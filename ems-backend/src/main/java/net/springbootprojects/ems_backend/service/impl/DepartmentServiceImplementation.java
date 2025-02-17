package net.springbootprojects.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.springbootprojects.ems_backend.dto.DepartmentDto;
import net.springbootprojects.ems_backend.entity.Department;
import net.springbootprojects.ems_backend.exception.ResourceNotFoundException;
import net.springbootprojects.ems_backend.mapper.DepartmentMapper;
import net.springbootprojects.ems_backend.repository.DepartmentRepository;
import net.springbootprojects.ems_backend.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class DepartmentServiceImplementation implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->new ResourceNotFoundException("Department does not exist with the given id: "+departmentId));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department -> DepartmentMapper.mapToDepartmentDto(department))).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->new ResourceNotFoundException("Department does not exist with the given id: "+departmentId));
        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
        Department updatedDepartmentObj = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(updatedDepartmentObj);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department does not exist with the given id: "+departmentId));
        departmentRepository.deleteById(departmentId);
    }
}
