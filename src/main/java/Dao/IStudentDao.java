package Dao;
import Entity.Student;
import java.util.List;

public interface IStudentDao  {
    void save(Student s);
    void update(Student s);
    void delete(Long Id);
    Student getOne(Long Id);
    List<Student> getAll();
}
