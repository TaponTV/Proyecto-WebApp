package controllers.login;

import DataObjects.DAO.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import models.Usuario;

@WebServlet(name = "LoginController", /*urlPatterns = {"/LoginController"},*/ value = {"/login", "/logout"})
public class LoginController extends HttpServlet {

    private Usuario user = new Usuario();
    private String tmp = "";

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rs.sendRedirect("./index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        switch (rq.getServletPath()) {
            case "/login":
                String userEmail = rq.getParameter("userEmail");
                String userPswrd = rq.getParameter("userPswrd");
                int isExist = new UsuarioDAO().validate(userEmail, userPswrd); //isExist containt idUser
                if (isExist != 0) {
                    int rol = new UsuarioDAO().currentUser(isExist);
                    rq.getSession().setAttribute("rolUser", rol);
                    rq.getSession().setAttribute("CurrentUser", isExist);
                    switch (rol) {
                        case 1:
                            tmp = "./views/users/admin/menu.jsp";
                            break;
                        case 2:
                            tmp = "./views/users/vet/menu.jsp";
                            break;
                        case 3:
                            tmp = "./views/users/client/menu.jsp";
                            break;
                    }
                    rs.sendRedirect(tmp);
                    //rq.getRequestDispatcher(tmp).forward(rq, rs);
                } else {
                    rq.setAttribute("notFoundUser", 1);
                    rq.getRequestDispatcher("./views/login/login.jsp").include(rq, rs);
                    //rs.sendRedirect("./views/login/login.jsp");
                }
                break;
            case "/logout":
                rq.getSession().invalidate();
                rs.sendRedirect("./index.jsp");
                break;
                
        }

    }

}
