package controllers.admin.bellcontrollers;

import DataObjects.DAO.SolicitudDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Solicitud;

@WebServlet(name = "ShowBellController", urlPatterns = {"/ShowBellController"})
public class ShowBellController extends HttpServlet {

    private SolicitudDAO DataBell = new SolicitudDAO();
    private Solicitud Bell = new Solicitud();
    private int BellID;
    private String InfoID = "";
    private List<Solicitud> list;
    private int typeUser;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {

        try {
            typeUser = Integer.parseInt(rq.getParameter("typeUser"));
            if (typeUser == 1) {
                ShowBellVet(rq, rs);
            } else if (typeUser == 2) {
                ShowBellClient(rq, rs);
            }
            rq.getSession().setAttribute("DataBell", list);
            rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/dataBell.jsp?id=" + InfoID);

        } catch (Exception ex) {

        }

    }

    private void ShowBellVet(HttpServletRequest rq, HttpServletResponse rs) {
        InfoID = rq.getParameter("UserInfoID");
        list = DataBell.ListOne(InfoID, 1);
    }

    private void ShowBellClient(HttpServletRequest rq, HttpServletResponse rs) {
        InfoID = rq.getParameter("ClientID");
        list = DataBell.ListOne(InfoID, 2);
    }

}
