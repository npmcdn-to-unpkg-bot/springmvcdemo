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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by kimi on 7/19/16.
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) {
        /*String code = (String) session.getAttribute("validateCode");
        String submitCode = WebUtils.getCleanParam(request, "validateCode");
        if (StringUtils.isEmpty(submitCode) || !StringUtils.equals(code, submitCode.toLowerCase())) {
            return "redirect:/";
        }*/
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(true);
        try {
            currentUser.login(token);
            return "redirect:/datagrid.html";
        } catch (AuthenticationException e) {
            token.clear();
            return "redirect:/login.jsp";
        }
    }
}
