package controllers.admin.meetcontrollers;

import DataObjects.DAO.ConsultaDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Consulta;

@WebServlet(name = "ShowMeetController", urlPatterns = {"/ShowMeetController"})
public class ShowMeetController extends HttpServlet {

    private ConsultaDAO DataMeet = new ConsultaDAO();
    private Consulta Meet = new Consulta();
    private List<Consulta> list;
    private String InfoID = "";
    private int MeetID = 0;
    private int typeUser;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try {
            typeUser = Integer.parseInt(rq.getParameter("typeUser"));
            if (typeUser == 1) {
                ShowMeetVet(rq, rs);
            } else if (typeUser == 2) {
                ShowMeetClient(rq, rs);
            }
            rq.getSession().setAttribute("DataMeet", list);
            rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/dataMeet.jsp?id=" + InfoID);

        } catch (Exception ex) {

        }
    }

    private void ShowMeetVet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        InfoID = rq.getParameter("UserInfoID");
        list = DataMeet.ListOne(InfoID, 1);
    }

    private void ShowMeetClient(HttpServletRequest rq, HttpServletResponse rs) {
        InfoID = rq.getParameter("ClientID");
        list = DataMeet.ListOne(InfoID, 2);
    }

}
