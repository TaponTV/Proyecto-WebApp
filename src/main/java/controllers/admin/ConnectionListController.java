package controllers.admin;

import DataObjects.DAO.ConexionDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Conexion;

@WebServlet(name = "ConnectionListController", urlPatterns = {"/ConnectionListController"})
public class ConnectionListController extends HttpServlet {

    private ConexionDAO DataConnection = new ConexionDAO();

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try {
            int typeUser = Integer.parseInt(rq.getParameter("typeuser"));
            int InfoID = Integer.parseInt(rq.getParameter("UserInfoID"));
            List<Conexion> list = DataConnection.ListOne(InfoID);
            rq.getSession().setAttribute("UserDataConnection", list);
            rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/dataconnection.jsp?option="+typeUser+"&id="+InfoID);
        } catch (Exception e) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    }

}
