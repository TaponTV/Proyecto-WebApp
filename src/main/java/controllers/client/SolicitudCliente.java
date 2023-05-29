/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.client;

import DataObjects.DAO.SolicitudDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Cliente;
import models.Solicitud;
import models.Usuario;
/**
 *
 * @author Admin
 */
@WebServlet(name = "SolicitudCliente", urlPatterns = {"/SolicitudCliente"})
public class SolicitudCliente extends HttpServlet {

    private Cliente client = new Cliente();
    private SolicitudDAO data = new SolicitudDAO();
    private List<Solicitud> list = new ArrayList<>();
    
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        Usuario user = ((Usuario) rq.getSession().getAttribute("CurrentUser"));
        client.setIdUser(user.getIdUser());
        client.setIdCliente();
        String idcliente = String.valueOf(client.getIdCliente());
        try {
            list = data.ListOne(idcliente, 2);
            rq.getSession().setAttribute("solicitudes", list);
            rs.sendRedirect(rq.getContextPath() + "/views/users/client/solicitudes.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        doPost(rq, rs);
    }

}
