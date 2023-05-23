package controllers.admin.functions.vet;

import DataObjects.DAO.SolicitudDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Solicitud;

@WebServlet(name = "ShowBellController", value = {"/BellsVetAdmin"})
public class ShowBellController extends HttpServlet {

    private SolicitudDAO DataBell = new SolicitudDAO();

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try {
            switch (rq.getServletPath()) {
                case "/BellsVetAdmin":
                    String InfoID = rq.getParameter("UserInfoID");
                    List<Solicitud> list = DataBell.ListDataVet(InfoID);
                    rq.getSession().setAttribute("DataBell", list);
                    rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/vet/dataBell.jsp");
                    break;
            }

        } catch (Exception ex) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    }

}
