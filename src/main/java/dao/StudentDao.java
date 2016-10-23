package dao;

import domain.Student;

import java.util.List;

/**
 * Created by robin on 2016/10/20.
 */
public interface StudentDao {
    public Student getStudentByNumber(String number);
    public List<Student> getStudentByYear();
    public List<Student> getAllStudent();
}
