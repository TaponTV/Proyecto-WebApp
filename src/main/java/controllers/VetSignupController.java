package controllers;

import DataObjects.DAO.VeterinarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import models.Usuario;
import models.Veterinario;

/**
 *
 * @author eduar
 */
@WebServlet(name = "VetSignupController", urlPatterns = {"/VetSignupController"})
public class VetSignupController extends HttpServlet {

    private VeterinarioDAO DataVet = new VeterinarioDAO();
    private Veterinario user;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        Usuario u = (Usuario) rq.getSession().getAttribute("CurrentUser");
        user = new Veterinario(
                rq.getParameter("cedula"),
                u.getIdUser(),
                rq.getParameter("specialty"),
                rq.getParameter("university"),
                rq.getParameter("dateTitle")
        );
        if (DataVet.create(user)) {
            rs.sendRedirect(rq.getContextPath() + "/CheckController");
        }

    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rq.getRequestDispatcher("/CheckController").forward(rq, rs);
    }

}
