package me.ele.pmo.api;

import com.alibaba.druid.util.StringUtils;
import me.ele.pmo.base.BaseController;
import me.ele.pmo.model.Department;
import me.ele.pmo.model.Employee;
import me.ele.pmo.service.DepartmentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by kimi on 7/19/16.
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private DepartmentService departmentServiceImpl;

    @RequestMapping(value = "/login")
    public String login(Employee user, HttpSession session, HttpServletRequest request) {
        String code = (String) session.getAttribute("validateCode");
        String submitCode = WebUtils.getCleanParam(request, "validateCode");
        if (StringUtils.isEmpty(submitCode) || !StringUtils.equals(code, submitCode.toLowerCase())) {
            return "redirect:/";
        }
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getGender());
        token.setRememberMe(true);
        try {
            currentUser.login(token);
            return "";
        } catch (AuthenticationException e) {
            token.clear();
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView mv = this.getModelAndView();
        com.fh.util.PageData pd = new com.fh.util.PageData();
        List<Department> list = this.departmentServiceImpl.query();
        mv.setViewName("list");
        pd.put("list", list);
        mv.addObject("pd", pd);
        return mv;
    }
}
