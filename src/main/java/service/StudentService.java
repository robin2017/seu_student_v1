package service;

import dao.StudentDao;
import dao.StudentDaoImpl;
import domain.Student;

import java.util.List;

/**
 * Created by robin on 2016/10/20.
 */
public class StudentService {
    public static void main(String[] args){
        StudentDao service= new StudentDaoImpl();
        List<Student> list=service.getAllStudent();
        int cnt=0;
        for(Student stu:list) {
            System.out.println(stu.toString());
            System.out.println("-------"+cnt++);
        }
    }
}
