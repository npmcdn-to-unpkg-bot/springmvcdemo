package me.ele.pmo.service;

import me.ele.pmo.dao.DepartmentDao;
import me.ele.pmo.dto.DepEmpDto;
import me.ele.pmo.model.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kimi on 5/12/16.
 */
@Service(value = "departmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {

    @Resource(name = "departmentDaoImpl")
    private DepartmentDao departmentDaoImpl;

    public boolean add(Department department) {
        return this.departmentDaoImpl.add(department);
    }

    public boolean update(Department department) {
        return this.departmentDaoImpl.update(department);
    }

    public List<Department> query() {
        return this.departmentDaoImpl.query();
    }

    public Department getById(int departmentId) {
        return this.departmentDaoImpl.getById(departmentId);
    }

    public List<DepEmpDto> get() {
        return null;
    }
}
