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
import models.Veterinario;

@WebServlet(name = "AdminController", value = {"/GetData", "/RidData"})
public class AdminController extends HttpServlet {

    private final ConexionDAO DataConnection = new ConexionDAO();
    private final ClienteDAO DataClient = new ClienteDAO();
    private final MascotaDAO DataPet = new MascotaDAO();
    private final SolicitudDAO DataBell = new SolicitudDAO();
    private final UsuarioDAO DataUser = new UsuarioDAO();
    private final VeterinarioDAO DataVet = new VeterinarioDAO();
    private Usuario CurrentUser = new Usuario();

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        CurrentUser = (Usuario) rq.getSession().getAttribute("CurrentUser");
        if (CurrentUser.getIdRol() != 1) {
            rs.sendRedirect(rq.getContextPath() + "/CheckController");
        }

        switch (rq.getServletPath()) {
            case "/GetData":
                String param = rq.getParameter("action");
                if (param == null) {
                    GetResumeContent(rq, rs);
                } else {
                    switch (param) {
                        case "2":
                            //lista de usuarios
                            GetListUserContent(rq, rs);
                            break;
                        case "3":
                            //Informacion de un usuario
                            GetUserInfo(rq, rs);
                            break;
                    }
                }
                break;
            case "RidData":
                //Para eliminar datos
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        switch (rq.getServletPath()) {
            case "/GetData":
                String param = rq.getParameter("action");
                switch (param) {
                    case "1":
                        //Resumen de estadisticas de la pagina
                        GetResumeContent(rq, rs);
                        break;
                    case "2":
                        //lista de usuarios
                        GetListUserContent(rq, rs);
                        break;
                    case "3":
                        //Listado de veterinarios
                        GetListVetContent(rq, rs);
                        break;
                    case "4":
                        //Listado de clientes
                        break;
                    case "5":
                        //Listado de solicitudes
                        break;
                    case "6":
                        //Listado de comentarios
                        break;
                    case "7":
                        //Listado de peticiones
                        break;
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
        List<Usuario> list = new ArrayList<>();
        list = DataUser.read();
        rq.getSession().setAttribute("listUsers", list);
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/DataListUser.jsp");
    }

    protected void GetUserInfo(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        int InfoID = Integer.parseInt(rq.getParameter("UserInfoID").toString());
        rq.getSession().setAttribute("UserInfo", DataUser.showUser(InfoID));
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/user.jsp");
    }

    private void GetListVetContent(HttpServletRequest rq, HttpServletResponse rs)throws ServletException, IOException {
        List<Veterinario> list = new ArrayList<>();
        list = DataVet.listVet();
        rq.getSession().setAttribute("listUsers", list);
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/DataListVet.jsp");
    }

}
