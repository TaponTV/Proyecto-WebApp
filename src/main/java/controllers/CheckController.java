package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import models.Usuario;

@WebServlet(name = "CheckController", urlPatterns = {"/CheckController"})
public class CheckController extends HttpServlet {

    private String tmp = "";

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        if (rq.getSession().getAttribute("NotFoundUser") == null && rq.getSession().getAttribute("CurrentUser") != null) {
            switch (((Usuario) rq.getSession().getAttribute("CurrentUser")).getIdRol()) {
                case 1:
                    tmp = rq.getContextPath()+"/views/users/admin/menu.jsp";
                    break;
                case 2:
                    tmp = rq.getContextPath()+"/views/users/vet/menu.jsp";
                    break;
                case 3:
                    tmp = rq.getContextPath()+"/views/users/client/menu.jsp";
                    break;
            }
            rs.sendRedirect(tmp);
        } else {
            rs.sendRedirect(rq.getContextPath()+"/views/login/login.jsp");
        }

    }

}
