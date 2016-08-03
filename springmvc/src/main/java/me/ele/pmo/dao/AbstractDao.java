package me.ele.pmo.dao;

import java.util.List;

/**
 * Created by kimi on 5/23/16.
 */
public interface AbstractDao {

    void save1(String str, Object obj) throws Exception;

    /**
     * 保存对象
     *
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object save(String str, Object obj) throws Exception;

    /**
     * 修改对象
     *
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object update(String str, Object obj) throws Exception;

    /**
     * 删除对象
     *
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object delete(String str, Object obj) throws Exception;

    /**
     * 查找对象
     *
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object findForObject(String str, Object obj) throws Exception;

    /**
     * 查找对象
     *
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object findForList(String str, Object obj) throws Exception;

    List<Object> findForList1(String str, Object obj) throws Exception;

    /**
     * 查找对象封装成Map
     *
     * @param sql
     * @param obj
     * @return
     * @throws Exception
     */
    Object findForMap(String sql, Object obj, String key, String value) throws Exception;

}
