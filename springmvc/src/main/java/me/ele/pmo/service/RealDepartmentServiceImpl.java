package me.ele.pmo.service;

import me.ele.pmo.dao.DepartmentDao;
import me.ele.pmo.dto.DepEmpDto;
import me.ele.pmo.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimi on 5/13/16.
 */
@Service(value = "realDepartmentServiceImpl")
public class RealDepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao realDepartmentDaoImpl;

    public boolean add(Department department) {
        return this.realDepartmentDaoImpl.add(department);
    }

    public boolean update(Department department) {
        return this.realDepartmentDaoImpl.update(department);
    }

    public List<Department> query() {
        return this.realDepartmentDaoImpl.query();
    }

    public Department getById(int departmentId) {
        return this.realDepartmentDaoImpl.getById(departmentId);
    }

    public List<DepEmpDto> get() {
        List<DepEmpDto> result = new ArrayList<DepEmpDto>(16);

        List list = this.realDepartmentDaoImpl.get();
        for (int index = 0; index < list.size(); index++) {
            Object o = list.get(index);
            DepEmpDto depEmpDto = new DepEmpDto();
            Object[] values = (Object[]) o;
            for (int i = 0; i < values.length; i++) {
                depEmpDto.setDepartmentId(Integer.parseInt(String.valueOf(values[0])));
                depEmpDto.setDepartmentName(String.valueOf(values[1]));
                depEmpDto.setDepartmentManager(String.valueOf(values[2]));
                depEmpDto.setProjectManager(String.valueOf(values[3]));
                depEmpDto.setEmployeeId(Integer.parseInt(String.valueOf(values[4])));
                depEmpDto.setName(String.valueOf(values[5]));
                depEmpDto.setAge(Integer.parseInt(String.valueOf(values[6])));
                depEmpDto.setGender(String.valueOf(values[7]));
            }
            result.add(depEmpDto);
        }

        return result;
    }
}
