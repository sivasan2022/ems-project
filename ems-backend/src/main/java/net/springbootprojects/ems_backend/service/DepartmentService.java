package net.springbootprojects.ems_backend.service;

import net.springbootprojects.ems_backend.dto.DepartmentDto;
import net.springbootprojects.ems_backend.entity.Department;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long departmentId);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto);

    void deleteDepartment(Long departmentId);
}
