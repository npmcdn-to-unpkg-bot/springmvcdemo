package me.ele.pmo.api;

import com.fh.util.Page;
import com.fh.util.PageData;
import me.ele.pmo.base.BaseController;
import me.ele.pmo.dao.PersonManager;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/person")
public class PersonController extends BaseController {

    @Resource(name = "personService")
    private PersonManager personService;

    @RequestMapping(value = "/save1", method = RequestMethod.POST)
    @ResponseBody
    public String save1(@RequestBody PageData pageData) throws Exception {
        pageData.put("PERSON_ID", this.get32UUID());
        personService.save(pageData);
        return pageData.toString();
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> query() {
        Map<String, Object> mapper = new HashMap<String, Object>();
        List<PageData> pd = null;
        Page page = new Page();
        page.setShowCount(1);
        page.setTotalResult(3);
        page.setCurrentPage(1);
        try {
            pd = this.personService.list(page);
            mapper.put("result", pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapper;
    }

    @RequestMapping(value = "/save")
    public ModelAndView save() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        mv.setViewName("person_edit");
        return mv;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }
}
