/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.login;

import DataObjects.DAO.ClienteDAO;
import DataObjects.DAO.GenerosDAO;
import DataObjects.DAO.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import models.Cliente;
import models.Usuario;

/**
 *
 * @author eduar
 */
@WebServlet(name = "SignupController", urlPatterns = {"/SignupController"})
public class SignupController extends HttpServlet {

    private int idRol = 3, idGenero;
    private ClienteDAO client = new ClienteDAO();
    private UsuarioDAO user = new UsuarioDAO();
    private GenerosDAO gender = new GenerosDAO();
    private Usuario tmp;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {

        if (rq.getParameter("typeUser").equals("Veterinario")) {
            idRol = 2;
        }
        idGenero = gender.check(rq.getParameter("genero"));
        tmp = new Usuario(
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
        if (user.create(tmp)) {
            tmp.setIdUser(user.validate(tmp.getEmail(), tmp.getPswrd()));
            rq.getSession().setAttribute("CurrentUser", tmp);
            switch (idRol) {
                case 2:
                    rq.getRequestDispatcher("/VetSignupController").forward(rq, rs);
                    break;
                case 3:
                    client.create(new Cliente(tmp.getIdUser()));
                    rs.sendRedirect(rq.getContextPath() + "/CheckController");
                    break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
            rq.getRequestDispatcher("/CheckController").forward(rq, rs);
    }

}
