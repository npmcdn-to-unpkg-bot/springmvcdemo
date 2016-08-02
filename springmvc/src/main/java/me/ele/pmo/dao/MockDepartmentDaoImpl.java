package me.ele.pmo.dao;

import me.ele.pmo.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kimi on 5/24/16.
 */
@Repository(value = "mockDepartmentDaoImpl")
public class MockDepartmentDaoImpl implements DepartmentDao {

    public boolean add(Department department) {
        return false;
    }

    public boolean update(Department department) {
        return false;
    }

    public List<Department> query() {
        return null;
    }

    public Department getById(int departmentId) {
        return null;
    }

    public List get() {
        return null;
    }
}
