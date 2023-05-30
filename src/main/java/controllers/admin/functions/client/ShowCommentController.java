package controllers.admin.functions.client;

import DataObjects.DAO.CalificacionDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Calificacion;

@WebServlet(name = "ShowCommentController", urlPatterns = {"/ShowCommentController"})
public class ShowCommentController extends HttpServlet {

    private CalificacionDAO DataScoreComment = new CalificacionDAO();
    private List<Calificacion> list;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        int ClientID = Integer.parseInt(rq.getParameter("ClientID"));
        int issue = Integer.parseInt(rq.getParameter("issue"));
        switch (issue) {
            case 1:
                //Lista Solo los comentarios realizados a la pagina
                break;
            case 2:
                /**
                 * Lista solo los comentarios realizados a los veterinarios por
                 * un cliente
                 */
                list = DataScoreComment.ListOne(ClientID);
                rq.getSession().setAttribute("DataComment", list);
                rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/dataComment.jsp?id=" + ClientID);
                break;

            default:
                //Lista todos los comentarios registrados
                break;
        }

    }

}
