package controllers.vet;

import DataObjects.DAO.ConsultaDAO;
import DataObjects.DAO.SolicitudDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Consulta;
import models.Solicitud;

/**
 *
 * @author Admin
 */
@WebServlet(name = "MeetVetController", urlPatterns = {"/MeetVetController"})
public class MeetVetController extends HttpServlet {

    private ConsultaDAO data = new ConsultaDAO();
    private SolicitudDAO databell = new SolicitudDAO();
    private Consulta tmpmeet = new Consulta();
    private Solicitud datameet = new Solicitud();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        int id = Integer.parseInt(rq.getParameter("idMeet"));
        tmpmeet = data.show(id);
        Consulta Currentmeet = (Consulta) rq.getSession().getAttribute("data" + id);
        Currentmeet.setIdSolicitud(tmpmeet.getIdSolicitud());
        Currentmeet.setDetalle(tmpmeet.getDetalle());
        rq.getSession().setAttribute("CurrentMeet", Currentmeet);
        rs.sendRedirect(rq.getContextPath() + "/views/users/vet/menu.jsp?section=3");
    }

}
