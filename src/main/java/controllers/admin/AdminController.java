package controllers.admin;

import DataObjects.DAO.ClienteDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DataObjects.DAO.*;
import java.util.ArrayList;
import java.util.List;
import models.Usuario;

@WebServlet(name = "AdminController", value = {"/getdata", "/AdminController", "/setDataContent"})
public class AdminController extends HttpServlet {

    private ConexionDAO DataConnection = new ConexionDAO();
    private ClienteDAO DataClient = new ClienteDAO();
    private MascotaDAO DataPet = new MascotaDAO();
    private SolicitudDAO DataBell = new SolicitudDAO();
    private UsuarioDAO DataUser = new UsuarioDAO();
    private VeterinarioDAO DataVet = new VeterinarioDAO();
    private List<Usuario> list = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        switch (rq.getServletPath()) {
            case "/getdata":
                doGet(rq, rs);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        switch (rq.getServletPath()) {
            case "/setDataContent":
                list = DataUser.read();
                rq.getSession().setAttribute("listUsers", list);
                rs.sendRedirect(rq.getContextPath() + "/views/users/admin/UserControl.jsp");
                break;
            default:
                rq.getSession().setAttribute("DataUser", DataUser.count());
                rq.getSession().setAttribute("DataVet", DataVet.count());
                rq.getSession().setAttribute("DataClient", DataClient.count());
                rq.getSession().setAttribute("DataConnection", DataConnection.count());
                rq.getSession().setAttribute("DataPet", DataPet.count());
                rq.getSession().setAttribute("DataBell", DataBell.count());
                rs.sendRedirect(rq.getContextPath() + "/views/users/admin/menu.jsp");
                break;
        }

    }

}
