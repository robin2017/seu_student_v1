package web;

import com.alibaba.fastjson.JSON;
import dao.StudentDao;
import dao.StudentDaoImpl;
import domain.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by robin on 2016/10/20.
 */
public class TestHTTPServer extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setCharacterEncoding("gbk");

        PrintWriter out = response.getWriter();

        String number = request.getParameter("number");

        out.println("number=" + number);


        StudentDao dao= new StudentDaoImpl();

        Student stu= dao.getStudentByNumber(number);
        String text= JSON.toJSONString(stu);
        out.println("student="+text);

        if (number == null || "".equals("number") || number.length() <= 0) {
            out.println("http call failed,参数param1不能为空,程序退出");
        } else{
            out.println("---http call success---");
        }

        out.close();

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);

    }

}