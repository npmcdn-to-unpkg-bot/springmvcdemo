package me.ele.pmo.service;

import com.fh.util.PageData;
import me.ele.pmo.dao.AbstractDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kimi on 5/23/16.
 */

@Service(value = "projectServiceImpl")
public class ProjectServiceImpl implements ProjectService {

    @Resource(name = "daoImplSupport")
    private AbstractDao daoImplSupport;

    public boolean save(PageData pd) throws Exception {
        return this.daoImplSupport.save("ProjectMapper.save", pd) != null ? true : false;
    }

    public PageData findById(PageData pd) throws Exception {
        return (PageData) this.daoImplSupport.findForObject("ProjectMapper.findById", pd);
    }

    public List<PageData> find(PageData pd) throws Exception {
        return (List<PageData>) this.daoImplSupport.findForList("ProjectMapper.find", pd);
    }

    public List<PageData> listAll(PageData pd) throws Exception {
        return (List<PageData>) this.daoImplSupport.findForList("ProjectMapper.listAll", pd);
    }

    public List<PageData> list(PageData pd) throws Exception {
        return (List<PageData>) this.daoImplSupport.findForList("ProjectMapper.list", pd);
    }
}
