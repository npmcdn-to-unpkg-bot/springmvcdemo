package me.ele.pmo.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimi on 5/24/16.
 */
@Repository(value = "mockDaoImplSupport")
public class MockDaoImplSupport implements AbstractDao {
    public MockDaoImplSupport() {
    }

    @Override
    public void save1(String str, Object obj) throws Exception {

    }

    public Object save(String str, Object obj) throws Exception {
        return obj;
    }

    public Object update(String str, Object obj) throws Exception {
        return obj;
    }

    public Object delete(String str, Object obj) throws Exception {
        return obj;
    }

    public Object findForObject(String str, Object obj) throws Exception {
        return obj;
    }

    public Object findForList(String str, Object obj) throws Exception {
        return new ArrayList<Object>();
    }

    public List<Object> findForList1(String str, Object obj) throws Exception {
        return null;
    }

    public Object findForMap(String sql, Object obj, String key, String value) throws Exception {
        return obj;
    }
}
