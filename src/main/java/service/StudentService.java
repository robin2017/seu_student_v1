package service;

import dao.StudentDao;
import dao.StudentDaoImpl;
import domain.Student;

import java.util.List;

/**
 * Created by robin on 2016/10/20.
 */
//此处的没用getStudentByNumber

/**
 * service层的作用：
 * 1、对dao层的接口进行权限控制，不是所有的接口都要用
 * 2、下层的是new对象，提供给上层的是静态方法
 * */
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

    public static Student getStudentByNumber(String number){
        return new StudentDaoImpl().getStudentByNumber(number);
    }
}
