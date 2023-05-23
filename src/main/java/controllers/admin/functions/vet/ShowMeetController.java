/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.admin.functions.vet;

import DataObjects.DAO.ConsultaDAO;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ShowMeetController", value = {"/MeetsVetAdmin"})
public class ShowMeetController extends HttpServlet {

    private ConsultaDAO DataMeet = new ConsultaDAO();

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try {
            switch (rq.getServletPath()) {
                case "/MeetsVetAdmin":
                    String InfoID = rq.getParameter("UserInfoID");
                    List<Consulta> list = DataMeet.ListOne(InfoID);
                    rq.getSession().setAttribute("DataMeet", list);
                    rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/vet/dataMeet.jsp");
                    break;
            };
        } catch (Exception ex) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    }

}
