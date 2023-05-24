package controllers.admin.meetcontrollers;

import DataObjects.DAO.ConsultaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Consulta;

@WebServlet(name = "DataMeetController", urlPatterns = {"/DataMeetController"})
public class DataMeetController extends HttpServlet {

    private ConsultaDAO DataMeet = new ConsultaDAO();
    private Consulta Meet = new Consulta();
    private int MeetID = 0;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        DataMeetVet(rq, rs);
    }

    private void DataMeetVet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        MeetID = Integer.parseInt(rq.getParameter("MeetID"));
        Meet = DataMeet.show(MeetID);
        rq.getSession().setAttribute("Meet", Meet);
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/showMeet.jsp");
    }

}
