package controllers.admin.bellcontrollers;

import DataObjects.DAO.SolicitudDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Solicitud;

@WebServlet(name = "RipBellController", urlPatterns = {"/RipBellController"})
public class RipBellController extends HttpServlet {

    private SolicitudDAO DataBell = new SolicitudDAO();
    private Solicitud Bell = new Solicitud();
    private int BellID;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        RipBellVet(rq, rs);
    }

    private void RipBellVet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
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
    }

}
