package controllers.admin.functions.client;

import DataObjects.DAO.CalificacionDAO;
import DataObjects.DAO.ComentarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShowCommentController", urlPatterns = {"/ShowCommentController"})
public class ShowCommentController extends HttpServlet {

    private ComentarioDAO DataCommentPage = new ComentarioDAO();
    private CalificacionDAO DataScoreComment = new CalificacionDAO();

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try {
            int ClientID = Integer.parseInt(rq.getParameter("ClientID"));
            int issue = Integer.parseInt(rq.getParameter("issue"));
            switch (issue) {
                case 1:
                    //Lista Solo los comentarios realizados a la pagina
                    break;
                case 2:
                    //Lista solo los comentarios realizados a los veterinarios
                    break;
                default:
                    //Lista todos los comentarios registrados
                    break;
            }
        } catch (Exception e) {

        }

    }

}
