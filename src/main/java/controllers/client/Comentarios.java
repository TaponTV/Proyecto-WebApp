/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.client;

import DataObjects.DAO.CalificacionDAO;
import DataObjects.DAO.ClienteDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Calificacion;
import models.Usuario;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Comentarios", urlPatterns = {"/Comentarios"})
public class Comentarios extends HttpServlet {

    private CalificacionDAO data = new CalificacionDAO();
    private ClienteDAO clientData = new ClienteDAO();
    private Map<Integer, String> listClients = new HashMap<>();
    private List<Calificacion> list = new ArrayList<>();
    
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String CurrentVet = rq.getParameter("id");
        list = data.ListOne(CurrentVet);
        for(Calificacion tmp: list){
            listClients.put(tmp.getIdCliente(),clientData.nameClient(tmp.getIdCliente()));
        }
        rq.getSession().setAttribute("dataList", list);
        rq.getSession().setAttribute("hashClient", listClients);
        rs.sendRedirect(rq.getContextPath()+"/views/users/client/comentariosveterinario.jsp");
        
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        doPost(rq, rs);
    }

}
