/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.client;

import DataObjects.DAO.UsuarioDAO;
import DataObjects.DAO.VeterinarioDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Veterinario;

/**
 *
 * @author Admin
 */
@WebServlet(name="BusquedaServlet", urlPatterns={"/BusquedaServlet"})
public class BusquedaServlet extends HttpServlet {
    
    private VeterinarioDAO data = new VeterinarioDAO();
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        List<Veterinario> list = new ArrayList<>();
        list = data.read();
        rq.getSession().setAttribute("veterinarios", list);
        rs.sendRedirect(rq.getContextPath()+"/views/users/client/veterinarios.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    
    
}
