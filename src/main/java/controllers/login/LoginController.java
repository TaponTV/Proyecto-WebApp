package controllers.login;

import DataObjects.DAO.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rs.sendRedirect("./index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {

        String userEmail = rq.getParameter("userEmail");
        String userPswrd = rq.getParameter("userPswrd");
        int isExist = new UsuarioDAO().validate(userEmail, userPswrd); //isExist containt idUser
        if (isExist != 0) {
            int currentUser = new UsuarioDAO().currentUser(isExist);
            if (currentUser == 1) {
                rq.setAttribute("isAdmin", isExist);
                rq.getRequestDispatcher("./views/users/admin/menu.jsp").forward(rq, rs);
            } else {
                if (currentUser == 2) {
                    rq.setAttribute("isVet", isExist);
                    rq.getRequestDispatcher("./views/users/vet/menu.jsp").forward(rq, rs);
                }
                if (currentUser == 3) {
                    rq.setAttribute("isClient", isExist);
                    rq.getRequestDispatcher("./views/users/client/menu.jsp").forward(rq, rs);
                }
            }
        } else {
            rq.setAttribute("notFoundUser", 1);
            rq.getRequestDispatcher("./views/login/login.jsp").include(rq, rs);
            //rs.sendRedirect("./views/login/login.jsp");
        }

    }

}
