/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.client;

import DataObjects.DAO.ConsultaDAO;
import DataObjects.DAO.RecetaDAO;
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
import models.Consulta;
import models.Receta;

/**
 *
 * @author Admin
 */

@WebServlet(name="HistorialClinico", urlPatterns={"/HistorialClinico"})
public class HistorialClinico extends HttpServlet{
    
    private Receta recipes = new Receta();
    private Consulta meets = new Consulta();
    private ConsultaDAO DataMeet = new ConsultaDAO();
    private RecetaDAO DataRecipe = new RecetaDAO();
    private List<Consulta> list = new ArrayList<>();
    private Map<Integer, List<Receta>> hashMeet = new HashMap<>();
    

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(rq.getParameter("id"));
            list = DataMeet.ListOne(id);
            for(Consulta tmp: list){
                hashMeet.put(tmp.getIdConsulta(), DataRecipe.read(tmp.getIdConsulta()));
            }
            rq.getSession().setAttribute("meets", list);
            rq.getSession().setAttribute("hashMeet", hashMeet);
            rs.sendRedirect(rq.getContextPath()+"/views/users/client/historial.jsp");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        doPost(rq, rs);
    }
    
}
