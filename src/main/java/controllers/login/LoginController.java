package controllers.login;

import DataObjects.DAO.ConexionDAO;
import DataObjects.DAO.UsuarioDAO;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import models.Conexion;
import models.Usuario;

@WebServlet(name = "LoginController",  value = {"/login", "/logout"})
public class LoginController extends HttpServlet {

    private Usuario user = null;
    private UsuarioDAO DataUser = new UsuarioDAO();
    private ConexionDAO DataConnection = new ConexionDAO();
    private String tmp = "";
    private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private String tmsp;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        sendPath(rq, rs);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        sendPath(rq, rs);
    }

    private void sendPath(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
        switch (rq.getServletPath()) {
            case "/login":
                String userEmail = rq.getParameter("userEmail");
                String userPswrd = rq.getParameter("userPswrd");
                int isExist = DataUser.validate(userEmail, userPswrd);
                if (isExist != 0) {
                    tmsp = fmt.format(new Timestamp(new Date().getTime()));
                    user = DataUser.showUser(isExist);
                    rq.getSession().setAttribute("NotFoundUser", null);
                    rq.getSession().setAttribute("CurrentUser", user);
                    rq.getSession().setAttribute("CurrentTimeConnection", tmsp);
                    DataConnection.create(new Conexion(user.getIdUser(), tmsp, tmsp));
                } else {
                    rq.getSession().setAttribute("NotFoundUser", 1);
                }
                rs.sendRedirect(rq.getContextPath() + "/CheckController");
                break;
            case "/logout":
                if (rq.getSession(false) == null || rq.getSession().getAttribute("CurrentUser") == null) {
                    rq.getRequestDispatcher("/CheckController").forward(rq, rs);
                } else {
                    tmsp = fmt.format(new Timestamp(new Date().getTime()));
                    DataConnection.update(
                            new Conexion(
                                    DataConnection.getRowID(user.getIdUser(), rq.getSession().getAttribute("CurrentTimeConnection").toString()),
                                    user.getIdUser(),
                                    rq.getSession().getAttribute("CurrentTimeConnection").toString(),
                                    tmsp
                            )
                    );
                    rq.getSession().invalidate();
                    rs.sendRedirect(rq.getContextPath() + "/index.jsp");
                }
                break;
            default:
                rs.sendRedirect(rq.getContextPath() + "/index.jsp");
                break;

        }
    }

}
