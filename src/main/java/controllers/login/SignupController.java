/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.login;

import DataObjects.DAO.GenerosDAO;
import DataObjects.DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import models.Usuario;

/**
 *
 * @author eduar
 */
@WebServlet(name = "SignupController", urlPatterns = {"/SignupController"})
public class SignupController extends HttpServlet {

    private int idRol = 3, idGenero;
    private UsuarioDAO client = new UsuarioDAO();
    private GenerosDAO gender = new GenerosDAO();

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {

        if (rq.getParameter("typeUser").equals("Veterinario")) {
            idRol = 2;
        }
        idGenero = gender.check(rq.getParameter("genero"));
        Usuario user = new Usuario(
                rq.getParameter("Nombre"),
                rq.getParameter("apPaterno"),
                rq.getParameter("apMaterno"),
                idGenero,
                (int) Double.parseDouble(rq.getParameter("edad")),
                rq.getParameter("pais"),
                rq.getParameter("estado"),
                rq.getParameter("ciudad"),
                rq.getParameter("calle"),
                rq.getParameter("celular"),
                rq.getParameter("telefono"),
                rq.getParameter("email"),
                rq.getParameter("pswrd"),
                idRol
        );
        if (client.create(user)) {
            user.setIdUser(client.validate(user.getEmail(), user.getPswrd()));
            rq.getSession().setAttribute("CurrentUser", user);
            rq.getSession().setAttribute("rolUser", user.getIdRol());
            switch (idRol) {
                case 2:
                    rq.getRequestDispatcher("/VetSignupController").forward(rq, rs);
                    break;
                case 3:
                    rq.getRequestDispatcher("./views/users/client/menu.jsp").forward(rq, rs);
                    break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
