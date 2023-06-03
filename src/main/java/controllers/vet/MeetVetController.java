package controllers.vet;

import DataObjects.DAO.ConsultaDAO;
import DataObjects.DAO.RecetaDAO;
import DataObjects.DAO.SolicitudDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Consulta;
import models.Receta;
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
    private RecetaDAO recipes = new RecetaDAO();
    private List<Receta> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        int id = Integer.parseInt(rq.getParameter("idMeet"));
        list = recipes.read(id);
        tmpmeet = data.show(id);
        Consulta Currentmeet = (Consulta) rq.getSession().getAttribute("data" + id);
        Currentmeet.setIdSolicitud(tmpmeet.getIdSolicitud());
        Currentmeet.setDetalle(tmpmeet.getDetalle());
        rq.getSession().setAttribute("CurrentMeet", Currentmeet);
        rq.getSession().setAttribute("listRecipes", list);
        rs.sendRedirect(rq.getContextPath() + "/views/users/vet/menu.jsp?section=3");
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        doGet(rq, rs);
    }

}
