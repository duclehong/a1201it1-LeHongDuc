package controller;

import model.Customer;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "customerServlet",urlPatterns = "")
public class customerServlet extends HttpServlet {
    private static List<Customer> customerList;

    @Override
    public void init() throws ServletException {
        customerList = new ArrayList<>();
        customerList.add(new Customer("duc","22-05-2001","nghe an","d1.jpg"));
        customerList.add(new Customer("duck","22-05-2001","nghe an","2.jpg"));
        customerList.add(new Customer("duc2","22-05-2001","nghe an","3.jpg"));
        customerList.add(new Customer("duc3","22-05-2001","nghe an","4.jpg"));
        customerList.add(new Customer("duc4","22-05-2001","nghe an","5.jpg"));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList",customerList);

        request.getRequestDispatcher("/customer/list.jsp").forward(request,response);
    }
}
