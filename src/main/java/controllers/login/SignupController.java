/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.login;

import DataObjects.DAO.ClienteDAO;
import DataObjects.DAO.ConexionDAO;
import DataObjects.DAO.GenerosDAO;
import DataObjects.DAO.UsuarioDAO;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import models.Cliente;
import models.Conexion;
import models.Usuario;

/**
 *
 * @author eduar
 */
@WebServlet(name = "SignupController", urlPatterns = {"/SignupController"})
public class SignupController extends HttpServlet {

    private int idRol = 3, idGenero;
    private ClienteDAO client = new ClienteDAO();
    private UsuarioDAO DataUser = new UsuarioDAO();
    private GenerosDAO gender = new GenerosDAO();
    private ConexionDAO DataConnection = new ConexionDAO();
    private Usuario user;
    private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private String tmsp;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {

        if (rq.getParameter("typeUser").equals("Veterinario")) {
            idRol = 2;
        }
        idGenero = gender.check(rq.getParameter("genero"));
        user = new Usuario(
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
        if (DataUser.create(user)) {
            tmsp = fmt.format(new Timestamp(new Date().getTime()));
            rq.getSession().setAttribute("CurrentTimeConnection", tmsp);
            user.setIdUser(DataUser.validate(user.getEmail(), user.getPswrd()));
            rq.getSession().setAttribute("CurrentUser", user);
            switch (idRol) {
                case 2:
                    rq.getSession().setAttribute("vetID", null);
                    rs.sendRedirect(rq.getContextPath() + "/views/login/VetForm.jsp");
                    break;
                case 3:
                    DataConnection.create(new Conexion(user.getIdUser(), tmsp, tmsp));
                    client.create(new Cliente(user.getIdUser()));
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
