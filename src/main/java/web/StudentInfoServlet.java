package web;

import domain.Student;
import service.StudentService;
import util.PropertyUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

import java.util.List;
import util.PropertyUtil;
import static util.PropertyUtil.*;
/**
 * Created by robin on 2016/10/20.
 */
public class StudentInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, 
    		HttpServletResponse response)throws ServletException, IOException {
        String number = request.getParameter("number");
        StudentService service= new StudentService();
        Student stu= service.getStudentByNumber(number);
        List list=PropertyUtil.getRobinFiledsInfo(stu);
       
        request.setAttribute("styles", list);
		 RequestDispatcher view=request.getRequestDispatcher("result.jsp");
		 view.forward(request, response);
      

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);

    }

}