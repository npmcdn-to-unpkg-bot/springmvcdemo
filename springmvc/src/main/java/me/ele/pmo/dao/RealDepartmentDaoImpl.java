package me.ele.pmo.dao;

import me.ele.pmo.model.Department;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimi on 5/13/16.
 */
@Repository(value = "realDepartmentDaoImpl")
public class RealDepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean add(Department department) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(department);
        tx.commit();
        Serializable id = session.getIdentifier(department);
        session.flush();
        session.close();
        return id != null ? true : false;
    }

    public boolean update(Department department) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(department);
        tx.commit();
        Serializable id = session.getIdentifier(department);
        session.flush();
        session.close();
        return id != null ? true : false;
    }

    public List<Department> query() {
        Session session = null;
        Query query;
        try {
            session = sessionFactory.openSession();
            query = session.createQuery("from Department");
            return query.list();
        } catch (Exception e) {

        } finally {
            session.flush();
            session.close();
        }
        return new ArrayList<Department>();
    }

    public Department getById(int departmentId) {
        Session session = null;
        Department department;
        try {
            session = sessionFactory.openSession();
            department = (Department) session.get(Department.class, departmentId);
            return department;
        } catch (Exception e) {

        } finally {
            session.flush();
            session.close();
        }
        return new Department();
    }

    public List get() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            String sql = "select d.departmentId, d.departmentName, d.departmentManager, d.projectManager, e.employeeId, e.name, e.age, e.gender from tbl_department as d, tbl_employee as e where d.departmentId = e.departmentId";
            Query query = session.createSQLQuery(sql);
            return query.list();
        } catch (Exception e) {
        } finally {
            session.flush();
            session.close();
        }
        return null;
    }
}
