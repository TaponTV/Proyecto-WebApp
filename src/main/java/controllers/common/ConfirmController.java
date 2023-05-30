package controllers.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Consulta;
import models.Solicitud;

@WebServlet(name = "ConfirmController", urlPatterns = {"/ConfirmController"})
public class ConfirmController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try {
            int MeetID;
            switch (rq.getParameter("action")) {
                case "modifymeet":
                    CreateObjectMeet(rq, rs);
                    rs.sendRedirect(rq.getContextPath() + "/views/users/common/confirmpage.jsp?action=1");
                    break;
                case "ripmeet":
                    MeetID = Integer.parseInt(rq.getParameter("MeetID"));
                    rq.getSession().setAttribute("MeetID", MeetID);
                    rs.sendRedirect(rq.getContextPath() + "/views/users/common/confirmpage.jsp?action=2");
                    break;
                case "modifybell":
                    CreateObjectBell(rq, rs);
                    rs.sendRedirect(rq.getContextPath() + "/views/users/common/confirmpage.jsp?action=3");
                    break;
                case "ripbell":
                    int BellID = Integer.parseInt(rq.getParameter("BellID"));
                    String page = rq.getParameter("page");
                    rq.getSession().setAttribute("BellID", BellID);
                    if (page != null && page.equals("client")) {
                        rs.sendRedirect(rq.getContextPath() + "/views/users/common/confirmpage.jsp?action=7");
                    } else {
                        rs.sendRedirect(rq.getContextPath() + "/views/users/common/confirmpage.jsp?action=4");
                    }
                    break;
                case "deletepet":
                    int PetID = Integer.parseInt(rq.getParameter("InfoID"));
                    rq.getSession().setAttribute("PetID", PetID);
                    rs.sendRedirect(rq.getContextPath() + "/views/users/common/confirmpage.jsp?action=5");
                    break;
                case "updateMeetVet":
                    MeetID = Integer.parseInt(rq.getParameter("MeetID"));
                    rq.getSession().setAttribute("MeetID", MeetID);
                    Consulta obj = new Consulta();
                    obj.setIdConsulta(MeetID);
                    obj.setIdSolicitud(Integer.parseInt(rq.getParameter("BellID")));
                    obj.setFechaConsulta(rq.getParameter("dateMeet"));
                    obj.setDetalle(rq.getParameter("detailMeet"));
                    rq.getSession().setAttribute("newObj", obj);
                    rs.sendRedirect(rq.getContextPath() + "/views/users/common/confirmpage.jsp?action=6");

                    break;

            }
        } catch (Exception e) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        doPost(rq, rs);
    }

    protected void CreateObjectMeet(HttpServletRequest rq, HttpServletResponse rs) {
        Consulta obj = new Consulta();
        obj.setIdConsulta(Integer.parseInt(rq.getParameter("MeetID")));
        obj.setIdSolicitud(Integer.parseInt(rq.getParameter("BellID")));
        obj.setFechaConsulta(rq.getParameter("DateMeet"));
        obj.setDetalle(rq.getParameter("DetailMeet"));
        rq.getSession().setAttribute("newObj", obj);
    }

    private void CreateObjectBell(HttpServletRequest rq, HttpServletResponse rs) {
        Solicitud obj = new Solicitud();
        obj.setIdSolicitud(Integer.parseInt(rq.getParameter("BellID")));
        obj.setIdCliente(Integer.parseInt(rq.getParameter("ClientID")));
        obj.setIdVeterinario(rq.getParameter("VetID"));
        obj.setIdMascota(Integer.parseInt(rq.getParameter("PetID")));
        obj.setIdPrioridad(Integer.parseInt(rq.getParameter("PriorityID")));
        obj.setIdEstado(Integer.parseInt(rq.getParameter("StatusID")));
        obj.setFecha(rq.getParameter("Date"));
        obj.setDescripcion(rq.getParameter("Details"));
        rq.getSession().setAttribute("newObj", obj);
    }

}
