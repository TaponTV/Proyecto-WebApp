package controllers.admin;

import DataObjects.DAO.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShowDataUserController", value = {"/ShowData","/RipDataVet"})
public class ShowDataUserController extends HttpServlet {

    private UsuarioDAO DataUser = new UsuarioDAO();
    
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try {
            int typeUser = Integer.parseInt(rq.getParameter("typeUser"));
            switch (rq.getServletPath()) {
                case "/ShowData":
                    int InfoID = Integer.parseInt(rq.getParameter("UserInfoID"));
                    rq.getSession().setAttribute("UserInfo", DataUser.showUser(InfoID));
                    rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/user.jsp?typeUser=" + typeUser);
                    break;
                case "/RipDataUser":
                    break;

            }
        } catch (Exception ex) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    }

}
