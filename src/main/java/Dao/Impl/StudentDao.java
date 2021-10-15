package Dao.Impl;
import Dao.IStudentDao;
import Entity.Student;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Util.JPAUtil;

public class StudentDao implements IStudentDao{
    @Override
    public void save(Student s) {
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void update(Student s) {
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(Long Id) {
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        Student s = manager.find(Student.class, Id);
        manager.remove(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public Student getOne(Long Id) {
        EntityManager manager = JPAUtil.getEntityManager();
        Student stu = manager.find(Student.class, Id);
        manager.close();
        return stu;
    }

    @Override
    public List<Student> getAll() {
        EntityManager manager = JPAUtil.getEntityManager();
        String sql = "select p from Entity.Student p";
        Query query = manager.createQuery(sql);
        List list = query.getResultList();
        manager.close();
        return list;
    }
}
