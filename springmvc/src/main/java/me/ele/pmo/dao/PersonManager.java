package me.ele.pmo.dao;

import com.fh.util.Page;
import com.fh.util.PageData;

import java.util.List;

public interface PersonManager {

    void save(PageData pd) throws Exception;

    void delete(PageData pd) throws Exception;

    void edit(PageData pd) throws Exception;

    List<PageData> listAll(PageData pd) throws Exception;

    PageData findById(PageData pd) throws Exception;

    void deleteAll(String[] ArrayDATA_IDS) throws Exception;

    List<PageData> list(Page page) throws Exception;
}

