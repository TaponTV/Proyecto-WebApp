package controllers.admin.meetcontrollers;

import DataObjects.DAO.ConsultaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Consulta;
import models.Usuario;

@WebServlet(name = "RipMeetController", urlPatterns = {"/RipMeetController"})
public class RipMeetController extends HttpServlet {

    private ConsultaDAO DataMeet = new ConsultaDAO();
    private int MeetID = 0;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        RipMeet(rq, rs);
    }

    private void RipMeet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        MeetID = Integer.parseInt(rq.getSession().getAttribute("MeetID").toString());
        int rol = ((Usuario) rq.getSession().getAttribute("CurrentUser")).getIdRol();
        rq.getSession().setAttribute("idMeet", MeetID);
        rq.getSession().removeAttribute("MeetID");
        if (rq.getParameter("option").equals("yes")) {
            boolean isUpdate = DataMeet.delete(MeetID);
            if (isUpdate) {
                if (rol == 2) {
                    rs.sendRedirect(rq.getContextPath() + "/DiaryController");
                } else {
                    rs.sendRedirect(rq.getContextPath() + "/GetData?action=1");
                }

            }
            //Añadir un mensaje algún día
        } else {
            if (rol == 2) {
                rs.sendRedirect(rq.getContextPath() + "/MeetVetController");
            } else {
                rq.getSession().setAttribute("Meet", rq.getSession().getAttribute("Meet"));
                rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/showMeet.jsp");
            }
        }
    }

}
