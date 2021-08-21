package controller;

import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "studentServlet")
public class studentServlet extends HttpServlet {
    private static List<Student> studentList;

    @Override
    public void init() throws ServletException {
        studentList = new ArrayList<>();
        studentList.add(new Student(1,"duc",1,50,"d1.jpg"));
        studentList.add(new Student(2,"duck",1,150,"2.jpg"));
        studentList.add(new Student(3,"duc2",1,250,"3.jpg"));
        studentList.add(new Student(4,"duc3",1,350,"4.jpg"));
        studentList.add(new Student(5,"duc4",1,450,"5.jpg"));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentList",studentList);

        request.getRequestDispatcher("/student/list.jsp").forward(request,response);
    }
}
