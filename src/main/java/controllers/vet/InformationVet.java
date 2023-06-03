/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.vet;

import DataObjects.DAO.ConsultaDAO;
import DataObjects.DAO.SolicitudDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */

@WebServlet(name="InformationVet", urlPatterns={"/InformationVet"})
public class InformationVet extends HttpServlet{

    
    private ConsultaDAO InfoMeet = new ConsultaDAO();
    private SolicitudDAO InfoNoti = new SolicitudDAO();
    
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String id = rq.getSession().getAttribute("vetID").toString();
        rq.getSession().setAttribute("consultas",InfoMeet.count(id) );
        rq.getSession().setAttribute("solicitudes",InfoNoti.count(id) );
        rs.sendRedirect(rq.getContextPath() + "/views/users/vet/menu.jsp?section=1");
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        doPost(rq, rs);
    }
    
    
}
