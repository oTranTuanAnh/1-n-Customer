package controller;

import model.Customer;
import service.CustomerService;
import service.Icustomer;
import service.Iprovince;
import service.ProvinceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    Icustomer icustomer = new CustomerService();
    Iprovince iprovince = new ProvinceService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String act = req.getParameter("action");
        if (act == null) {
            act = "";
        }
        switch (act){
            case "create":
                showFormCreate(req, resp);
                break;
            default:
                showList(req, resp);
                break;
        }

    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("create.jsp");
        try {
            req.setAttribute("provinceList",iprovince.findAll());
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        try {
            req.setAttribute("customer",icustomer.findAll());
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String act = req.getParameter("action");
        if (act == null) {
            act = "";
        }
        switch (act){
            case "create":
                createNewCustomer(req, resp);
                break;
            default:
                showList(req, resp);
                break;
        }
    }

    private void createNewCustomer(HttpServletRequest req, HttpServletResponse resp) {
        String c_name = req.getParameter("name");
        String c_address = req.getParameter("address");
        String c_email = req.getParameter("email");
        String c_phone = req.getParameter("phone");
        int p_id = Integer.parseInt(req.getParameter("province"));
        Customer customer = new Customer(c_name, c_address, c_email, c_phone);
        icustomer.save(customer, p_id);


    }
}
