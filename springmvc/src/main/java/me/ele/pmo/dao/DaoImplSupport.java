package me.ele.pmo.dao;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kimi on 5/23/16.
 */
@Repository("daoImplSupport")
public class DaoImplSupport implements AbstractDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void save1(String str, Object obj) throws Exception {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            int returnObj = sqlSession.insert(str, obj);
            sqlSession.flushStatements();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public Object save(String str, Object obj) throws Exception {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            Object returnObj = sqlSession.insert(str, obj);
            sqlSession.flushStatements();
            sqlSession.commit();
            return returnObj;
        } finally {
            sqlSession.close();
        }
    }

    public Object update(String str, Object obj) throws Exception {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            Object returnObj = sqlSession.update(str, obj);
            sqlSession.flushStatements();
            sqlSession.commit();
            return returnObj;
        } finally {
            sqlSession.close();
        }
    }

    public Object delete(String str, Object obj) throws Exception {
        return null;
    }

    public Object findForObject(String str, Object obj) throws Exception {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            return sqlSession.selectOne(str, obj);
        } finally {
            sqlSession.close();
        }
    }

    public Object findForList(String str, Object obj) throws Exception {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            return sqlSession.selectList(str, obj);
        } finally {
            sqlSession.close();
        }
    }

    public List<Object> findForList1(String str, Object obj) throws Exception {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            return sqlSession.selectList(str, obj);
        } finally {
            sqlSession.close();
        }
    }

    public Object findForMap(String sql, Object obj, String key, String value) throws Exception {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            return sqlSession.selectMap(sql, obj, key);
        } finally {
            sqlSession.close();
        }
    }
}
