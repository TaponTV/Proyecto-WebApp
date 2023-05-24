package controllers.admin.bellcontrollers;

import DataObjects.DAO.SolicitudDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Solicitud;

@WebServlet(name = "DataBellController", urlPatterns = {"/DataBellController"})
public class DataBellController extends HttpServlet {

    private SolicitudDAO DataBell = new SolicitudDAO();
    private Solicitud Bell = new Solicitud();
    private int BellID;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        DataBellVet(rq, rs);
    }

    private void DataBellVet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        BellID = Integer.parseInt(rq.getParameter("BellID"));
        Bell = DataBell.show(BellID);
        rq.getSession().setAttribute("Bell", Bell);
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/showBell.jsp");
    }

}
