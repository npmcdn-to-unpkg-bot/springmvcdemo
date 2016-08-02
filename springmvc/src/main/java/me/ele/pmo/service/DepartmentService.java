package me.ele.pmo.service;

import me.ele.pmo.dto.DepEmpDto;
import me.ele.pmo.model.Department;

import java.util.List;

/**
 * Created by kimi on 5/12/16.
 */
public interface DepartmentService {
    boolean add(Department department);

    boolean update(Department department);

    List<Department> query();

    Department getById(int departmentId);

    List<DepEmpDto> get();
}
