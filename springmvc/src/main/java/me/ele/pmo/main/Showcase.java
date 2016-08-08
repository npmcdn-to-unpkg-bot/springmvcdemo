package me.ele.pmo.main;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fh.util.ObjectExcelRead;
import com.fh.util.ObjectExcelRead1;
import me.ele.pmo.model.Dep;
import me.ele.pmo.model.Emp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimi on 5/28/16.
 */
public class Showcase {
    public static JsonGenerator jsonGenerator = null;
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        /*

        Dep department = new Dep();
        Emp employee1 = new Emp();
        employee1.setEmployeeId(1);
        employee1.setName("kimi");
        employee1.setAge(33);
        employee1.setGender("male");

        Emp employee2 = new Emp();
        employee2.setEmployeeId(2);
        employee2.setName("lucy");
        employee2.setAge(37);
        employee2.setGender("female");

        Emp employee3 = new Emp();
        employee3.setEmployeeId(3);
        employee3.setName("benson");
        employee3.setAge(34);
        employee3.setGender("male");

        List<Emp> list = new ArrayList<Emp>(16);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);

        department.setDepartmentId(10);
        department.setDepartmentName("gmd");
        department.setEmployees(list);


        //System.out.println("=============================");
        //mapper.writeValue(System.out, department);
        //mapper.writeValue(new File("/Users/kimi/Downloads/data.json"), department);
        //System.out.println("=============================");

        Dep dep1 = mapper.readValue(new File("/Users/kimi/Downloads/data.json"), Dep.class);
        if (dep1 != null) {
            List<Emp> employees = dep1.getEmployees();
            for (Emp e : employees) {
                System.out.println(e.toString());
            }
        }
        */

        //List<Object> list = ObjectExcelRead.readExcel("//Users//kimi//Downloads//原", "七月份回滚数据.xls", 1, 0, 0);

        List<Object> list1 = ObjectExcelRead1.readExcel("//Users//kimi//Downloads//原", "七月份回滚数据.xlsx", 1, 0, 0);
    }
}

