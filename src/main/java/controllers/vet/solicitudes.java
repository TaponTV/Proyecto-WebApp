/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.vet;

import DataObjects.DAO.SolicitudDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Solicitud;

/**
 *
 * @author Admin
 */
@WebServlet(name="solicitudes", urlPatterns={"/solicitudes"})
public class solicitudes extends HttpServlet {

     private SolicitudDAO data = new SolicitudDAO();
     private List<Solicitud> list = new ArrayList<>();
     
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try{
            String idVet = rq.getSession().getAttribute("vetID").toString();
            list = data.ListOne(idVet, 1);
            rq.getSession().setAttribute("dataList", list);
            rs.sendRedirect(rq.getContextPath()+"/views/users/vet/menu.jsp?section=4");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        doPost(rq, rs);
    }
    
}
