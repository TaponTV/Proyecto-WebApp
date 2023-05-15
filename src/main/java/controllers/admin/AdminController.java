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

@WebServlet(name = "AdminController", value = {"/GetData"})
public class AdminController extends HttpServlet {

    private final ConexionDAO DataConnection = new ConexionDAO();
    private final ClienteDAO DataClient = new ClienteDAO();
    private final MascotaDAO DataPet = new MascotaDAO();
    private final SolicitudDAO DataBell = new SolicitudDAO();
    private final UsuarioDAO DataUser = new UsuarioDAO();
    private final VeterinarioDAO DataVet = new VeterinarioDAO();
    private List<Usuario> list = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        switch (rq.getServletPath()) {
            case "/GetData":
                String param = rq.getParameter("action");
                if(param!=null)
                    GetListUserContent(rq, rs);
                GetResumeContent(rq, rs);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        switch (rq.getServletPath()) {
            case "/GetData":
                String param = rq.getParameter("action");
                if (param.equals("1")) {
                    GetResumeContent(rq, rs);
                } else if (param.equals("2")) {
                    GetListUserContent(rq, rs);
                }
                break;
        }

    }

    protected void GetResumeContent(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rq.getSession().setAttribute("DataUser", DataUser.count());
        rq.getSession().setAttribute("DataVet", DataVet.count());
        rq.getSession().setAttribute("DataClient", DataClient.count());
        rq.getSession().setAttribute("DataConnection", DataConnection.count());
        rq.getSession().setAttribute("DataPet", DataPet.count());
        rq.getSession().setAttribute("DataBell", DataBell.count());
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/menu.jsp");
    }

    protected void GetListUserContent(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        list = DataUser.read();
        System.out.println(list);
        rq.getSession().setAttribute("listUsers", list);
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/UserControl.JS");
    }

}
