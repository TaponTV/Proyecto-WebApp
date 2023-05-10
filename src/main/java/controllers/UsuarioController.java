package controllers;

import DataObjects.DAO.UsuarioDAO;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import models.Usuario;

@WebServlet (name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
       doGet(rq, rs);
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
       
        UsuarioDAO userDAO = new UsuarioDAO ();
        String action;
        RequestDispatcher ds = null;
        
        action = rq.getParameter("accion");
        
        if(action == null){
            ds = rq.getRequestDispatcher("./index.jsp");
            List<Usuario> listUsers = userDAO.read();
            rq.setAttribute("Lista Usuarios", listUsers);
            
        }
        ds.forward(rq, rs);
    }
    
}
