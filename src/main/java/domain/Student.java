package domain;

import java.io.Serializable;
import java.sql.*;
/**
 * Created by robin on 2016/10/18.
 */
public class Student implements Serializable{
    //每个有十四个属性
    private String number;
    private String name;
    private String sex;
    private String address;
    private String birthYear;

    private String nation;
    private String status;
    private String entrance;
    private String college;
    private String major;

    private String tutor;
    private String degree;
    private String direction;
    private String department;

    public Student(){
    }
    public Student(ResultSet rs){
        try {
            this.department=rs.getString("department");
            this.direction=rs.getString("direction");
            this.degree=rs.getString("degree");
            this.address=rs.getString("address");
            this.birthYear=rs.getString("birthyear");

            this.name=rs.getString("name");
            this.tutor=rs.getString("tutor");
            this.college=rs.getString("college");
            this.entrance=rs.getString("entrance");
            this.major=rs.getString("major");

            this.number=rs.getString("number");
            this.nation=rs.getString("nation");
            this.sex=rs.getString("sex");
            this.status=rs.getString("status");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String toString(){
        return number+" "+name+" "+sex+" "+address+" "+birthYear+" "+nation+" "+status+" "+entrance+" "
                +college+" "+major+" "+tutor+" "+degree+" "+direction+" "+direction+" "+department;
    }
}
