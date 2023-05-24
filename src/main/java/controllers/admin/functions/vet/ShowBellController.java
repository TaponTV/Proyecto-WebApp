package controllers.admin.functions.vet;

import DataObjects.DAO.SolicitudDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Solicitud;

@WebServlet(name = "ShowBellController", value = {"/BellsVetAdmin", "/DataBellVet", "/ModifyBellVet", "/RipBellVet"})
public class ShowBellController extends HttpServlet {

    private SolicitudDAO DataBell = new SolicitudDAO();
    private Solicitud Bell = new Solicitud();
    private int BellID;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try {
            switch (rq.getServletPath()) {
                case "/BellsVetAdmin":
                    String InfoID = rq.getParameter("UserInfoID");
                    List<Solicitud> list = DataBell.ListDataVet(InfoID);
                    rq.getSession().setAttribute("DataBell", list);
                    rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/vet/dataBell.jsp?id=" + InfoID);
                    break;
                case "/DataBellVet":
                    BellID = Integer.parseInt(rq.getParameter("BellID"));
                    Bell = DataBell.show(BellID);
                    rq.getSession().setAttribute("Bell", Bell);
                    rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/vet/showBell.jsp");
                    break;
                case "/ModifyBellVet":
                    Bell = (Solicitud) rq.getSession().getAttribute("newObj");
                    rq.getSession().removeAttribute("newObj");
                    if (rq.getParameter("option").equals("yes")) {
                        boolean isUpdate = DataBell.update(Bell);
                        if (isUpdate) {
                            rq.getSession().setAttribute("Bell", Bell);
                            rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/vet/showBell.jsp");
                        }
                    } else {
                        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/vet/showBell.jsp");
                    }
                    break;
                case "/RipBellVet":
                    BellID = Integer.parseInt(rq.getSession().getAttribute("BellID").toString());
                    rq.getSession().removeAttribute("BellID");
                    if (rq.getParameter("option").equals("yes")) {
                        boolean isUpdate = DataBell.delete(BellID);
                        if (isUpdate) {
                            rq.getSession().removeAttribute("Bell");
                            rs.sendRedirect(rq.getContextPath() + "/GetData?action=3");
                        }
                        //Añadir un mensaje algún día
                    } else {
                        rq.getSession().setAttribute("Bell", rq.getSession().getAttribute("Bell"));
                        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/vet/showBell.jsp");
                    }
                    break;
            }

        } catch (Exception ex) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    }

}
