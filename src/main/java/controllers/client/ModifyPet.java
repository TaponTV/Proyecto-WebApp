/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.client;

import DataObjects.DAO.MascotaDAO;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Mascota;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ModifyPet", urlPatterns = {"/ModifyPet"})
public class ModifyPet extends HttpServlet {

    private MascotaDAO data = new MascotaDAO();
    private Mascota obj = new Mascota();

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try {
            String option = rq.getParameter("option");
            String msg="", specie;
            if (option.equals("yes")) {
                obj = (Mascota) rq.getSession().getAttribute("pet");
                Map<Integer, String> hashSpecie = (Map<Integer, String>) rq.getSession().getAttribute("hashSpecie");
                for (Map.Entry<Integer, String> entry : hashSpecie.entrySet()) {
                    specie = entry.getValue().replace(" ", "");
                    if (obj.getEspecie().equals(specie)) {
                        obj.setIdEspecie(entry.getKey());
                        System.out.println(obj.getIdEspecie());
                    }
                }
                if(data.update(obj)){
                    msg = "<script>alert('Modificacion realizada con exito');</script>";
                }else{
                    msg = "<script>alert('No fue posible realizar la modificacion');</script>";
                }
                rq.getSession().setAttribute("msg", msg);
            }
            rs.sendRedirect(rq.getContextPath()+"/DataPet?id="+obj.getIdMascota());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        doPost(rq, rs);
    }

}
