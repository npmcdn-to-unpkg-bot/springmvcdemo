package me.ele.pmo.dao;

import me.ele.pmo.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimi on 5/12/16.
 */
@Repository(value = "departmentDaoImpl")
public class DepartmentDaoImpl implements DepartmentDao {

    private static List<Department> list = new ArrayList<Department>(16);

    public DepartmentDaoImpl() {
        list.add(new Department(1, "waimai", "taizhou.wang@ele.me", "gang.gush@ele.me"));
        list.add(new Department(2, "napos", "run.zhao@ele.me", "li.wang03@ele.me"));
        list.add(new Department(3, "wuliu", "wei.gao@ele.me", "wenjun.cai@ele.me"));
    }

    public boolean add(final Department department) {
        boolean result = false;
        if (department != null) {
            for (Department d : list) {
                if (d.getDepartmentId() == department.getDepartmentId()) {
                    return result;
                }
            }

            if (!result) {
                return list.add(department);
            }
        }

        return result;
    }

    public boolean update(final Department department) {
        boolean result = true;
        if (department != null) {
            for (Department d : list) {
                if (d.getDepartmentId() == department.getDepartmentId()) {
                    d.setDepartmentManager(department.getDepartmentManager());
                    d.setDepartmentName(department.getDepartmentName());
                    d.setProjectManager(department.getProjectManager());
                    return result;
                }
            }

            return !result;
        }

        return !result;
    }

    public List<Department> query() {
        return list;
    }

    public Department getById(int departmentId) {
        for (Department d : list) {
            if (departmentId == d.getDepartmentId()) {
                return d;
            }
        }
        return new Department();
    }

    public List get() {
        return list;
    }
}
