/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.vet;

import DataObjects.DAO.RecetaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Receta;

/**
 *
 * @author Admin
 */
@WebServlet(name="RecetaryController", urlPatterns={"/RecetaryController"})
public class RecetaryController extends HttpServlet{
    
    private RecetaDAO data = new RecetaDAO();
    private Receta obj = new Receta();
    
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        obj.setIdConsulta(Integer.parseInt(rq.getParameter("idmeet")));
        obj.setMedicamento(rq.getParameter("medicine"));
        obj.setTipoAdministracion(rq.getParameter("aplicacion"));
        obj.setHorario(rq.getParameter("times"));
        obj.setDetalles(rq.getParameter("details"));
        data.create(obj);
        rs.sendRedirect(rq.getContextPath()+"/MeetVetController?idMeet="+obj.getIdConsulta());
        
        
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        doPost(rq, rs);
    }
    
}
