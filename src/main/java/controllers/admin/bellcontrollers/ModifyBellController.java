package controllers.admin.bellcontrollers;

import DataObjects.DAO.SolicitudDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Solicitud;

@WebServlet(name = "ModifyBellController", urlPatterns = {"/ModifyBellController"})
public class ModifyBellController extends HttpServlet {

    private SolicitudDAO DataBell = new SolicitudDAO();
    private Solicitud Bell = new Solicitud();
    private int BellID;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        ModifyBellVet(rq, rs);
    }

    private void ModifyBellVet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
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
    }

}
