package net.springbootprojects.ems_backend.repository;

import net.springbootprojects.ems_backend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {


}
