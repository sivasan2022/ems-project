package net.springbootprojects.ems_backend.service;

import net.springbootprojects.ems_backend.dto.DepartmentDto;
import net.springbootprojects.ems_backend.entity.Department;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);
}
