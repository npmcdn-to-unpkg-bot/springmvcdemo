package me.ele.pmo.api;

import me.ele.pmo.model.Dep;
import me.ele.pmo.model.Department;
import me.ele.pmo.model.Emp;
import me.ele.pmo.model.Employee;
import me.ele.pmo.service.DepartmentService;
import me.ele.pmo.service.EmployeeService1Impl;
import me.ele.pmo.service.EmployeeService2Impl;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kimi on 5/10/16.
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    private DepartmentService departmentServiceImpl;

    @Resource(name = "employeeService1Impl")
    private EmployeeService1Impl employeeServiceImpl;

    @Resource(name = "employeeService2Impl")
    private EmployeeService2Impl employeeService2Impl;

    @RequestMapping(value = "/saysorry", method = RequestMethod.POST)
    @ResponseBody
    /**
     *
     */
    public String saySorry(@RequestBody String appId, String age) throws IOException {
        return new ObjectMapper().writeValueAsString("say sorry " + appId + ", age = " + age);
    }

    @RequestMapping(value = "/sayhello", method = RequestMethod.GET)
    @ResponseBody
    /**
     *
     */
    public String sayHello(
            @RequestParam(value = "name", required = false, defaultValue = "kimi") String name,
            @RequestParam(value = "age", required = false, defaultValue = "0") int age,
            @RequestParam(value = "gender", required = false, defaultValue = "male") String gender) throws IOException {
        Employee e = new Employee(name, age, gender);
        return new ObjectMapper().writeValueAsString(e);
    }

    @RequestMapping(value = "/saysorry1", method = RequestMethod.POST)
    @ResponseBody
    public Department saySorry(@RequestBody Department department) throws IOException {
        return department;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody Department department) throws IOException {
        ResponseEntity<String> responseEntity;
        if (this.departmentServiceImpl.add(department)) {
            responseEntity = new ResponseEntity<String>("add success", null, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        return new ObjectMapper().writeValueAsString(responseEntity);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public String query(
            @RequestParam(value = "departmentId", required = false, defaultValue = "0") int departmentId) throws IOException {
        ResponseEntity<String> responseEntity;
        if (departmentId == 0) {
            List<Department> list = this.departmentServiceImpl.query();
            responseEntity = new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), null, HttpStatus.OK);
        } else {
            Department d = this.departmentServiceImpl.getById(departmentId);
            responseEntity = new ResponseEntity<String>(new ObjectMapper().writeValueAsString(d), null, HttpStatus.OK);
        }

        return new ObjectMapper().writeValueAsString(responseEntity);
    }

    @RequestMapping(value = "/query2", method = RequestMethod.GET)
    @ResponseBody
    public List<Department> query() throws IOException {
        return this.departmentServiceImpl.query();
    }

    @RequestMapping(value = "/query1", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> query1(
            @RequestParam(value = "departmentId", required = false, defaultValue = "0") int departmentId) throws IOException {
        Map<String, Object> mapper = new HashMap<String, Object>();
        List<Map> rows = new ArrayList<Map>();
        if (departmentId == 0) {
            List<Department> list = this.departmentServiceImpl.query();
            mapper.put("total", list.size());
            mapper.put("page", 1);
            for (Department d : list) {
                Map<String, Object> cellMap = new HashMap<String, Object>();
                cellMap.put("id", d.getDepartmentId());
                cellMap.put("cell", new Object[]{
                        d.getDepartmentId(),
                        d.getDepartmentName(),
                        d.getDepartmentManager(),
                        d.getProjectManager()
                });
                rows.add(cellMap);
            }
        } else {
            Department department = this.departmentServiceImpl.getById(departmentId);
            mapper.put("result", department);
        }
        mapper.put("rows", rows);
        return mapper;
    }

    @RequestMapping(value = "/add2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> add2(@RequestBody Dep department) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>(16);
        map.put("result", department);

        if (department != null) {
            List<Emp> employees = department.getEmployees();
            for (Emp e : employees) {
                e.Console();
            }
        }

        return map;
    }

    @RequestMapping(value = "queryall", method = RequestMethod.GET)
    @ResponseBody
    /*
    */
    public List<Employee> all() {
        return this.employeeServiceImpl.query();
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public Employee get(@RequestParam(value = "employeeId", required = false, defaultValue = "0") int employeeId) {
        return this.employeeServiceImpl.getById(employeeId);
    }

    @RequestMapping(value = "get1", method = RequestMethod.GET)
    @ResponseBody
    public Employee get1(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
        return this.employeeServiceImpl.getByName(name);
    }

    @RequestMapping(value = "get2", method = RequestMethod.GET)
    @ResponseBody
    public Employee get2(@RequestParam(value = "name", required = false, defaultValue = "") String name,
                         @RequestParam(value = "gender", required = false, defaultValue = "female") String gender) {
        return this.employeeServiceImpl.get(name, gender);
    }

    @RequestMapping(value = "get3", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> get3() {
        return this.employeeService2Impl.query();
    }

    @RequestMapping(value = "/add3", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> add3(@RequestBody Employee employee) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>(16);
        boolean result = this.employeeService2Impl.add(employee);
        map.put("result", result);
        return map;
    }

    @RequestMapping(value = "get4", method = RequestMethod.GET)
    @ResponseBody
    public Employee get4(@RequestParam(value = "employeeId", required = false, defaultValue = "0") int employeeId) {
        return this.employeeService2Impl.getById(employeeId);
    }

    @RequestMapping(value = "get5", method = RequestMethod.GET)
    @ResponseBody
    public Employee get5(@RequestParam(value = "name", required = false, defaultValue = "") String name,
                         @RequestParam(value = "gender", required = false, defaultValue = "female") String gender) {
        return this.employeeService2Impl.get(name, gender);
    }

    @RequestMapping(value = "get6", method = RequestMethod.GET)
    @ResponseBody
    public Employee get6(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
        return this.employeeService2Impl.getByName(name);
    }
}
