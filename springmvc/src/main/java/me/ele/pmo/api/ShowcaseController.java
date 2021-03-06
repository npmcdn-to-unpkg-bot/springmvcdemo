package me.ele.pmo.api;

import java.io.PrintWriter;
import java.net.URLDecoder;

import com.fh.util.FileUpload;
import com.fh.util.ObjectExcelRead1;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;
import me.ele.pmo.base.BaseController;
import me.ele.pmo.dto.DepEmpDto;
import me.ele.pmo.model.Department;
import me.ele.pmo.model.Employee;
import me.ele.pmo.model.Project;
import me.ele.pmo.service.DepartmentService;
import me.ele.pmo.service.EmployeeService;
import me.ele.pmo.service.ProjectService;
import me.ele.pmo.service.ProjectService1;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kimi on 5/13/16.
 */
@Controller
@RequestMapping(value = "/showcase")
public class ShowcaseController extends BaseController {

    @Autowired
    private DepartmentService realDepartmentServiceImpl;

    @Autowired
    private EmployeeService employeeServiceImpl;

    @Autowired
    private ProjectService projectServiceImpl;

    @Resource(name = "projectService1Impl")
    private ProjectService1 projectService1Impl;

    @RequestMapping(value = "/add2", method = RequestMethod.POST)
    @ResponseBody
    public String add2(@RequestBody Project project) {
        PageData pd = this.getPageData();
        //pd.put("projectId", project.getProjectId());
        pd.put("departmentId", project.getDepartmentId());
        pd.put("departmentName", project.getDepartmentName());

        try {
            this.projectServiceImpl.save1(pd);
        } catch (Exception e) {
        }
        return String.valueOf(pd.get("projectId"));
    }

    @RequestMapping(value = "/query2", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> query2(@RequestParam(value = "projectId", required = false, defaultValue = "0") int projectId,
                                      @RequestParam(value = "departmentName", required = false, defaultValue = "") String departmentName,
                                      @RequestParam(value = "departmentId", required = false, defaultValue = "0") int departmentId) {
        Map<String, Object> mapper = new HashMap<String, Object>();
        PageData pd = this.getPageData();
        //pd.put("projectId", projectId);
        pd.put("deparmentName", departmentName);
        pd.put("departmentId", departmentId);
        List<PageData> p = null;
        try {
            p = this.projectServiceImpl.find(pd);
            mapper.put("result", p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapper;
    }

    @RequestMapping(value = "/query3", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> query3() {
        Map<String, Object> mapper = new HashMap<String, Object>();
        PageData pd = this.getPageData();
        List<Integer> projectIds = new ArrayList<Integer>();
        projectIds.add(1);
        projectIds.add(6);
        projectIds.add(4);
        pd.put("list", projectIds);
        List<PageData> p = null;
        try {
            p = this.projectServiceImpl.list(pd);
            mapper.put("result", p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapper;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody Department department) {
        ResponseEntity<String> responseEntity;

        List<Department> list = this.realDepartmentServiceImpl.query();

        for (Department d : list) {
            d.show();
        }

        if (this.realDepartmentServiceImpl.add(department)) {
            responseEntity = new ResponseEntity<String>("add success", null, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        String str = null;
        try {
            str = new ObjectMapper().writeValueAsString(responseEntity);
        } catch (IOException e) {
        }

        return str;
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public String query(
            @RequestParam(value = "departmentId", required = false, defaultValue = "0") int departmentId) {
        ResponseEntity<List<Department>> responseEntity;
        if (departmentId == 0) {
            List<Department> list = this.realDepartmentServiceImpl.query();
            responseEntity = new ResponseEntity<List<Department>>(list, null, HttpStatus.OK);
        } else {
            Department d = this.realDepartmentServiceImpl.getById(departmentId);
            List<Department> list = new ArrayList<Department>();
            list.add(d);
            responseEntity = new ResponseEntity<List<Department>>(list, null, HttpStatus.OK);
        }

        String str = null;
        try {
            str = new ObjectMapper().writeValueAsString(responseEntity);
        } catch (IOException e) {
        }

        return str;
    }

    @RequestMapping(value = "/query1", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> query1(
            @RequestParam(value = "departmentId", required = false, defaultValue = "0") int departmentId) {
        Map<String, Object> mapper = new HashMap<String, Object>();
        List<Department> list;
        mapper.put("status", HttpStatus.OK);
        if (departmentId == 0) {
            list = this.realDepartmentServiceImpl.query();
        } else {
            Department department = this.realDepartmentServiceImpl.getById(departmentId);
            list = new ArrayList<Department>();
            list.add(department);
        }
        mapper.put("result", list);
        mapper.put("statusCode", HttpServletResponse.SC_OK);
        return mapper;
    }

    @RequestMapping(value = "/query2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> query2() {
        Map<String, Object> mapper = new HashMap<String, Object>();
        List<Map> rows = new ArrayList<Map>();
        List<Department> list = this.realDepartmentServiceImpl.query();
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
        mapper.put("rows", rows);
        return mapper;
    }

    @RequestMapping(value = "/addemployee", method = RequestMethod.POST)
    @ResponseBody
    public String addEmployee(@RequestBody Employee employee) {
        return String.valueOf(this.employeeServiceImpl.add(employee));
    }

    @RequestMapping(value = "/queryall", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> queryAll() {
        return this.employeeServiceImpl.query();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<DepEmpDto> get() {
        return this.realDepartmentServiceImpl.get();
    }

    @RequestMapping(value = "/get1", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Project> get1() {
        return this.projectService1Impl.findAll();
    }

    @RequestMapping(value = "/a1", method = RequestMethod.POST)
    @ResponseBody
    public Project a1(@RequestBody Project project) {
        return this.projectService1Impl.save(project);
    }

    @RequestMapping(value = "/get2", method = RequestMethod.GET)
    @ResponseBody
    public String get2() {
        Iterable<Project> projects = this.projectService1Impl.findAll();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<table border=\"1\"><tr><th>projectId</th><th>departmentName</th><tr>");
        for (Project p :
                projects) {
            stringBuilder.append("<tr><td>" + p.getProjectId() + "</td><td>" + p.getDepartmentName() + "</td></tr>");
        }
        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> m = new HashMap<>();

        List<String> list = new ArrayList<>();
        list.add("projectId");
        list.add("departmentId");
        list.add("departmentName");
        list.add("createdAt");
        m.put("titles", list);

        PageData pd = this.getPageData();

        List<PageData> l = this.projectServiceImpl.list(pd);

/*
        pd.put("var0", "10");
        pd.put("var1", "外卖");
        pd.put("var2", "100");
        l.add(pd);

        PageData pd1 = this.getPageData();
        pd1.put("var0", "11");
        pd1.put("var1", "商户端");
        pd1.put("var2", "80");
        l.add(pd1);

        PageData pd2 = this.getPageData();
        pd2.put("var0", "12");
        pd2.put("var1", "大物流");
        pd2.put("var2", "120");
        l.add(pd2);
*/
        m.put("varList", l);

        ObjectExcelView objectExcelView = new ObjectExcelView();
        HSSFWorkbook wb = new HSSFWorkbook();
        objectExcelView.buildExcelDocument(m, wb, request, response);
        OutputStream out = response.getOutputStream();
        wb.write(out);
        out.flush();
        return map;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> upload(@RequestParam MultipartFile[] file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<>();
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        String originalFileName = "";
        File f = null;
        for (MultipartFile f1 : file) {
            //originalFileName = URLDecoder.decode(f1.getOriginalFilename(), "UTF-8");
            originalFileName = f1.getName();
            f = new File(realPath, originalFileName);
            if (f.exists()) {
                f.delete();
            }
            FileUtils.copyInputStreamToFile(f1.getInputStream(), f);
        }
        List<Object> list1 = null;
        if (f.exists()) {
            list1 = ObjectExcelRead1.readExcel(realPath, originalFileName, 1, 0, 0);
        }
        map.put("result", list1);
        return map;
    }

    @RequestMapping(value = "/upload1", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> upload1(@RequestParam MultipartFile[] file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<>();
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        String originalFileName = "";
        for (MultipartFile f1 : file) {
            // TODO: file name should not hardcode
            originalFileName = FileUpload.fileUp(f1, realPath, "7月回滚");
        }
        List<Object> list1 = null;
        File f = new File(realPath + "//" + originalFileName);
        if (f.exists()) {
            list1 = ObjectExcelRead1.readExcel(realPath, originalFileName, 1, 0, 0);
        }
        map.put("result", list1);
        return map;
    }

    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> upload2(@RequestBody Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("key", map.get("key"));
        return map1;
    }
}
