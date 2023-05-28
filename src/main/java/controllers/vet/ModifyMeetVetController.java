/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.vet;

import DataObjects.DAO.ConsultaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Consulta;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ModifyMeetVetController", urlPatterns = {"/vet/updateMeet"})
public class ModifyMeetVetController extends HttpServlet {

    private Consulta Meet = new Consulta();
    private ConsultaDAO DataMeet = new ConsultaDAO();
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try {
            Meet = (Consulta) rq.getSession().getAttribute("newObj");
            rq.getSession().removeAttribute("newObj");
            rq.getSession().setAttribute("idMeet", Meet.getIdConsulta());
            if (rq.getParameter("option").equals("yes")) {
                DataMeet.update(Meet);
            } 
            rs.sendRedirect(rq.getContextPath() + "/MeetVetController");
        } catch (Exception e) {

        }
    }

}
