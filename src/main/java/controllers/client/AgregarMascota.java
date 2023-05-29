/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.client;

import DataObjects.DAO.MascotaDAO;
import java.io.IOException;
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
@WebServlet(name = "AgregarMascota", urlPatterns = {"/AgregarMascota"})
public class AgregarMascota extends HttpServlet {

    private Mascota pet;
    private MascotaDAO data = new MascotaDAO();
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        int idCliente = Integer.parseInt(rq.getParameter("idcliente"));
        String nombre = rq.getParameter("name");
        int edad = Integer.parseInt(rq.getParameter("edad"));
        String date = rq.getParameter("date");
        String raza = rq.getParameter("raza");
        String especie = rq.getParameter("especie");
        int idEspecie = Integer.parseInt(rq.getSession().getAttribute(especie).toString());
        pet = new Mascota(idCliente, nombre, edad, date,raza, idEspecie);
        data.create(pet);
        rs.sendRedirect(rq.getContextPath()+"/listPets");
    }

}
