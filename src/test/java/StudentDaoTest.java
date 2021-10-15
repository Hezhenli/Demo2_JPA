import Dao.IStudentDao;
import Dao.Impl.StudentDao;
import Entity.Student;
import org.junit.*;

import java.util.List;

public class StudentDaoTest {
    IStudentDao sDao = new StudentDao();

    @Test
    public void create() {
        Student s1 = new Student();
        s1.setName("小王");
        s1.setSex(true);
        sDao.save(s1);
    }

    @Test
    public void updata() {
        Student s1 = new Student();
        s1.setId(1l);
        s1.setName("小马");
        s1.setSex(true);
        sDao.update(s1);
    }

    @Test
    public void findOne() {
        Student one = sDao.getOne(1l);
        System.out.println(one.getName());
    }

    @Test
    public void findAll() {
        List<Student> list = sDao.getAll();
        list.forEach(stu -> System.out.println(stu.getName()));
    }

    @Test
    public void delete() {
        sDao.delete(2l);
    }
}
