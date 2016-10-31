package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import web.StudentInfoServlet;

/**
 * Created by robin on 2016/10/23.
 */
public class DataBaseUtil {

    public static String driver="com.mysql.jdbc.Driver";
    public static String host="localhost";
    public static String username="root";
    public static String password="123456";
    public static String port="3306";
    public static String database="seu";

    public static String url=null;
    public static Connection con=null;
    public static Statement stmt=null;

    public static void s1LoadDriver() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace();
        }
    }
    public static void s2ProviderURL(){
//    	host=StudentInfoServlet.database_ip;
//    	username=StudentInfoServlet.database_user;
//    	password=StudentInfoServlet.database_password;
        url = "jdbc:mysql://"+host+":"+port+"/"+database;
    }
    public static void s3CreateConnection()  {
        try {
        	System.out.println(url+"-----"+username+"-----"+password);
            con = DriverManager.getConnection(url, username, password) ;
        } catch (SQLException e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
    }

    /**
     1、执行静态SQL语句。通常通过Statement实例实现。
     2、执行动态SQL语句。通常通过PreparedStatement实例实现。
     3、执行数据库存储过程。通常通过CallableStatement实例实现。
     * */
    public static void s4CreateStatement(){
        //此处用静态
        try {
            stmt=con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**进行数据库连接的预处理，得到statement，就可以进行连接
     Statement接口提供了三种执行SQL语句的方法：executeQuery 、executeUpdate
     和execute

     1、ResultSet executeQuery(String sqlString)：执行查询数据库的SQL语句
     ，返回一个结果集（ResultSet）对象。
     2、int executeUpdate(String sqlString)：用于执行INSERT、UPDATE或
     DELETE语句以及SQL DDL语句，如：CREATE TABLE和DROP TABLE等
     3、execute(sqlString):用于执行返回多个结果集、多个更新计数或二者组合的
     语句。

     * */
    public static void preOperation(){//数据库连接的1-4步
        s1LoadDriver();
        s2ProviderURL();
        s3CreateConnection();
        s4CreateStatement();
    }

    public static void afterOperation() {//数据库连接的7步
        try {
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("数据库关闭异常");
            e.printStackTrace();
        }
    }
}
