package dao;

import domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 2016/10/20.
 */
public class StudentDaoImpl implements StudentDao {



    public Student getStudentByNumber(String num) {
        Student stu=null;
        ResultSet rs=null;
        String sql="select * from studentinfo where number='"+num+"'";
        DataBaseUtil.preOperation();
        try {
             rs = DataBaseUtil.stmt.executeQuery(sql);

            while(rs.next()){
                stu=new Student(rs);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataBaseUtil.afterOperation();
        return stu;
    }

    public List<Student> getStudentByYear() {
        return null;
    }

    public List<Student> getAllStudent() {

        List<Student> list=new ArrayList<Student>();
        ResultSet rs=null;
        String sql="select * from studentinfo";
        DataBaseUtil.preOperation();
        try {
            rs = DataBaseUtil.stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while(rs.next()){
                list.add(new Student(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataBaseUtil.afterOperation();
        return list;
    }
}
