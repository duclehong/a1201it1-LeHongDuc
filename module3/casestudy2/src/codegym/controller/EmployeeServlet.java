package codegym.controller;

import codegym.dao.EmployeeDAO;
import codegym.model.Customer;
import codegym.model.Emplyoee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO;

    public void init() {
        employeeDAO = new EmployeeDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertEmployee(request, response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateEmployee(request, response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        String name = request.getParameter("name");
        Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        System.out.println(address);
        int position = Integer.parseInt(request.getParameter("position"));
        int education = Integer.parseInt(request.getParameter("education"));
        int division  = Integer.parseInt(request.getParameter("division"));
        employeeDAO.updateEmployee(id,name,birthday,idCard,salary,phone,email,address,position,education,division);
        List<Emplyoee> emplyoeeList = employeeDAO.showShowAllEmployee();
        request.setAttribute("listEmployee", emplyoeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {

        String name = request.getParameter("name");
        Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("type"));
        int education = Integer.parseInt(request.getParameter("education"));
        int division  = Integer.parseInt(request.getParameter("division"));

        employeeDAO.insertEmployee(name,birthday,idCard,salary,phone,email,address,position,education,division);
        List<Emplyoee> emplyoeeList = employeeDAO.showShowAllEmployee();
        request.setAttribute("listEmployee", emplyoeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                    showNewForm(request, response);
                break;
            case "edit":
                    showEditForm(request, response);
                break;
            case "delete":
                try {
                    deleteEmployee(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "find":
                    findEmployee(request, response);
                break;
            default:
                listEmployee(request, response);
                break;
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO.deleteEmployee(id);
        List<Emplyoee> emplyoeeList = employeeDAO.showShowAllEmployee();
        request.setAttribute("listEmployee", emplyoeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Emplyoee existingEmployee = employeeDAO.selectEmployee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/editEmployee.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/createEmployee.jsp");
        dispatcher.forward(request, response);
    }

    private void findEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("findId"));
        List<Emplyoee> emplyoeeList = employeeDAO.showEmployee(id);
        request.setAttribute("listEmployee", emplyoeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Emplyoee> emplyeeList = employeeDAO.showShowAllEmployee();
        request.setAttribute("listEmployee", emplyeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }
}
