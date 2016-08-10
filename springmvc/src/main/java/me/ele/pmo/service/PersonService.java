package me.ele.pmo.service;

import com.fh.util.Page;
import com.fh.util.PageData;
import me.ele.pmo.dao.AbstractDao;
import me.ele.pmo.dao.PersonManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("personService")
public class PersonService implements PersonManager {

    @Resource(name = "daoImplSupport")
    private AbstractDao dao;

    public void save(PageData pd) throws Exception {
        dao.save("PersonMapper.save", pd);
    }

    public void delete(PageData pd) throws Exception {
        dao.delete("PersonMapper.delete", pd);
    }

    public void edit(PageData pd) throws Exception {
        dao.update("PersonMapper.edit", pd);
    }

    public List<PageData> listAll(PageData pd) throws Exception {
        return (List<PageData>) dao.findForList("PersonMapper.listAll", pd);
    }

    public PageData findById(PageData pd) throws Exception {
        return (PageData) dao.findForObject("PersonMapper.findById", pd);
    }

    public void deleteAll(String[] ArrayDATA_IDS) throws Exception {
        dao.delete("PersonMapper.deleteAll", ArrayDATA_IDS);
    }

    public List<PageData> list(Page page) throws Exception {
        return (List<PageData>) dao.findForList("PersonMapper.listPage", page);
    }

}

