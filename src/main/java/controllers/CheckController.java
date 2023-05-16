package controllers;

import DataObjects.DAO.VeterinarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import models.Usuario;

@WebServlet(name = "CheckController", urlPatterns = {"/CheckController"})
public class CheckController extends HttpServlet {

    private VeterinarioDAO DataVet = new VeterinarioDAO();
    private String tmp = "";

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        if (rq.getSession().getAttribute("NotFoundUser") == null && rq.getSession().getAttribute("CurrentUser") != null) {
            switch (((Usuario) rq.getSession().getAttribute("CurrentUser")).getIdRol()) {
                case 1:
                    tmp = rq.getContextPath() + "/GetData?action=1";
                    break;
                case 2:
                    String ID = DataVet.getRowID(((Usuario) rq.getSession().getAttribute("CurrentUser")).getIdUser());
                    if (ID != null) {
                        rq.getSession().setAttribute("vetID", ID);
                        tmp = rq.getContextPath() + "/views/users/vet/menu.jsp";
                    } else {
                        tmp = rq.getContextPath() + "/views/login/VetForm.jsp";
                    }
                    break;
                case 3:
                    tmp = rq.getContextPath() + "/views/users/client/menu.jsp";
                    break;
            }
            rs.sendRedirect(tmp); 
        } else {
            rs.sendRedirect(rq.getContextPath() + "/index.jsp");
        }

    }
}
