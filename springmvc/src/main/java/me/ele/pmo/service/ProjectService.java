package me.ele.pmo.service;

import com.fh.util.PageData;

import java.util.List;

/**
 * Created by kimi on 5/23/16.
 */
public interface ProjectService {
    void save1(PageData pd) throws Exception;

    boolean save(PageData pd) throws Exception;

    PageData findById(PageData pd) throws Exception;

    List<PageData> listAll(PageData pd) throws Exception;

    List<PageData> find(PageData pd) throws Exception;

    List<PageData> list(PageData pd) throws Exception;
}
