/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.client;

import DataObjects.DAO.CalificacionDAO;
import DataObjects.DAO.VeterinarioDAO;
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
import models.Usuario;
import models.Veterinario;

/**
 *
 * @author TaponTV
 */
@WebServlet(name="BusquedaServlet", urlPatterns={"/BusquedaServlet"})
public class BusquedaServlet extends HttpServlet {
    
    private VeterinarioDAO data = new VeterinarioDAO();
    private Map<String, Integer> hashScore = new HashMap<>();
    private CalificacionDAO scoreData = new CalificacionDAO();
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        int score;
        Usuario CurrentUser = (Usuario)rq.getSession().getAttribute("CurrentUser");
        List<Veterinario> list = new ArrayList<>();
        list = data.read(CurrentUser.getCiudad());
        for(Veterinario tmp: list){
            score = scoreData.Score(tmp.getCedula());
            hashScore.put(tmp.getCedula(), score);
        }
        rq.getSession().setAttribute("veterinarios", list);
        rq.getSession().setAttribute("hashScore", hashScore);
        rs.sendRedirect(rq.getContextPath()+"/views/users/client/veterinarios.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    
    
}
