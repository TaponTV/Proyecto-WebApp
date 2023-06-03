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
import models.Consulta;
import models.Solicitud;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Respuesta", urlPatterns = {"/Respuesta"})
public class Respuesta extends HttpServlet {

    private SolicitudDAO data = new SolicitudDAO();
    private ConsultaDAO meetData = new ConsultaDAO();
    private Solicitud bell;
    private Consulta meet = new Consulta();

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try {
            boolean isUpdate;
            String msg;
            int option = Integer.parseInt(rq.getParameter("option"));
            int id = Integer.parseInt(rq.getParameter("id"));
            bell = (Solicitud) rq.getSession().getAttribute("data"+id);
            if (option == 1) {
                isUpdate = data.update(id, 2);
                meet.setIdSolicitud(bell.getIdSolicitud());
                meet.setFechaConsulta(bell.getFecha());
                meet.setDetalle(bell.getDescripcion());
                boolean isCreated = meetData.create(meet);
                if (isUpdate && isCreated) {
                    msg = "<script>alert('Cita agendada con exito')</script>";
                } else {
                    msg = "<script>alert('No fue posible agendar la cita')</script>";
                }
                 rs.sendRedirect(rq.getContextPath() + "/views/users/vet/menu.jsp?section=4");
            } else if (option == 2) {
                isUpdate = data.update(id, 3);
                msg = "<script>alert('Lamentamos la decisión')</script>";
                rs.sendRedirect(rq.getContextPath() + "/views/users/vet/menu.jsp?section=4");
            } else {
                rs.sendRedirect(rq.getContextPath() + "/views/users/vet/menu.jsp?section=1");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        doPost(rq, rs);
    }

}
