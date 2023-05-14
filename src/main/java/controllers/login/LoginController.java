package controllers.login;

import DataObjects.DAO.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import models.Usuario;

@WebServlet(name = "LoginController", /*urlPatterns = {"/LoginController"} */ value = {"/login", "/logout"})
public class LoginController extends HttpServlet {

    private Usuario user = null;
    private UsuarioDAO DataUser = new UsuarioDAO();
    private String tmp = "";

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rq.getRequestDispatcher("/CheckController").forward(rq, rs);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        switch (rq.getServletPath()) {
            case "/login":
                String userEmail = rq.getParameter("userEmail");
                String userPswrd = rq.getParameter("userPswrd");
                int isExist = DataUser.validate(userEmail, userPswrd); //isExist containt idUser
                if (isExist != 0) {
                    user = DataUser.showUser(isExist);
                    rq.getSession().setAttribute("NotFoundUser", null);
                    rq.getSession().setAttribute("CurrentUser", user);
                } else {
                    rq.getSession().setAttribute("NotFoundUser", 1);
                }
                rs.sendRedirect(rq.getContextPath() + "/CheckController");

                break;
            case "/logout":
                rq.getSession().invalidate();
                rs.sendRedirect("./index.jsp");
                break;

        }

    }

}
