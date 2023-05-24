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
@WebServlet(name = "ShowMeetController", value = {"/MeetsVetAdmin", "/ModifyMeetVet", "/RipMeetVet", "/DataMeetVet"})
public class ShowMeetController extends HttpServlet {

    private ConsultaDAO DataMeet = new ConsultaDAO();
    private Consulta Meet = new Consulta();
    private int MeetID = 0;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try {

            switch (rq.getServletPath()) {
                case "/MeetsVetAdmin":
                    String InfoID = rq.getParameter("UserInfoID");
                    List<Consulta> list = DataMeet.ListOne(InfoID);
                    rq.getSession().setAttribute("DataMeet", list);
                    rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/vet/dataMeet.jsp?id=" + InfoID);
                    break;
                case "/ModifyMeetVet":
                    Meet = (Consulta) rq.getSession().getAttribute("newObj");
                    rq.getSession().removeAttribute("newObj");
                    if (rq.getParameter("option").equals("yes")) {
                        boolean isUpdate = DataMeet.update(Meet);
                        if (isUpdate) {
                            rq.getSession().setAttribute("Meet", Meet);
                            rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/vet/showMeet.jsp");
                        }
                    } else {
                        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/vet/showMeet.jsp");
                    }

                    break;
                case "/RipMeetVet":
                    MeetID = Integer.parseInt(rq.getSession().getAttribute("MeetID").toString());
                    rq.getSession().removeAttribute("MeetID");
                    if (rq.getParameter("option").equals("yes")) {
                        boolean isUpdate = DataMeet.delete(MeetID);
                        if (isUpdate) {
                            rq.getSession().removeAttribute("Meet");
                            rs.sendRedirect(rq.getContextPath() + "/GetData?action=3");
                        }
                        //Añadir un mensaje algún día
                    } else {
                        rq.getSession().setAttribute("Meet", rq.getSession().getAttribute("Meet"));
                        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/vet/showMeet.jsp");
                    }

                    break;
                case "/DataMeetVet":
                    MeetID = Integer.parseInt(rq.getParameter("MeetID"));
                    Meet = DataMeet.show(MeetID);
                    rq.getSession().setAttribute("Meet", Meet);
                    rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/vet/showMeet.jsp");
                    break;
            }
        } catch (Exception ex) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    }

}
