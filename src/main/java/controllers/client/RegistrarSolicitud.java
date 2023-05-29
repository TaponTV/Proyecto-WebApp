/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.client;

import DataObjects.DAO.SolicitudDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "RegistrarSolicitud", urlPatterns = {"/RegistrarSolicitud"})
public class RegistrarSolicitud extends HttpServlet {

    private SolicitudDAO data = new SolicitudDAO();
    private Solicitud obj;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String mascota = rq.getParameter("pets");
        String tmp;
        int idpet = Integer.parseInt(rq.getSession().getAttribute("idpet").toString());
        if (data.exist(idpet)) {
            tmp = "<script>alert('Esta mascota ya tiene pendiente una cita, por favor revisa las solicitudes realizadas, o cancela');</script>";
            rq.getSession().setAttribute("msg", tmp);
            rs.sendRedirect(rq.getContextPath() + "/BusquedaServlet");
        } else {
            tmp = "<script>alert('Solicitud enviada :D');</script>";
            int idCliente = Integer.parseInt(rq.getParameter("idcliente"));
            String idVet = rq.getParameter("idvet");
            int prioridad = 1;
            int status = 1;
            String date = rq.getParameter("date");
            String details = rq.getParameter("details");
            obj = new Solicitud(idCliente, idVet, idpet, prioridad, status, date, details);
            data.create(obj);
            rq.getSession().setAttribute("msg", tmp);
            rs.sendRedirect(rq.getContextPath() + "/BusquedaServlet");
        }
    }

}
