/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.client;

import DataObjects.DAO.EspecieDAO;
import DataObjects.DAO.MascotaDAO;
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
import models.Especie;
import models.Mascota;

/**
 *
 * @author Admin
 */
@WebServlet(name="DataPet", urlPatterns="/DataPet")
public class DataPet extends HttpServlet{

    private MascotaDAO data = new MascotaDAO();
    private Mascota pet = new Mascota();
    private EspecieDAO specie = new EspecieDAO();
    private Map<Integer, String> hash = new HashMap<>();
    private List<Especie> list = new ArrayList<>();
    
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        int idspecie;
        int idPet = Integer.parseInt(rq.getParameter("id"));
        pet = data.getData(idPet);
        list = specie.read();
        for(Especie tmp: list){
            idspecie = tmp.getIdEspecie();
            hash.put(idspecie, tmp.getEspecie());
            //System.out.println(hash.get(idspecie));
        }
        rq.getSession().setAttribute("dataPet", pet);
        rq.getSession().setAttribute("hashSpecie", hash);
        rs.sendRedirect(rq.getContextPath()+"/views/users/client/datosmascotas.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        doPost(rq, rs);
    }
    
    
    
}
