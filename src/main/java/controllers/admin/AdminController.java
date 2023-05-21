package controllers.admin;

import DataObjects.DAO.ClienteDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DataObjects.DAO.*;
import java.util.List;
import models.*;

@WebServlet(name = "AdminController", value = {"/GetData", "/RidData"})
public class AdminController extends HttpServlet {

    //Option 0 sera utilizado para determinar a todos los usuarios
    //Option 1 sera utilizado para determinar a solo los veterinarios
    //Option 2 sera utilizado para determinar a solo los clientes
    private final ConexionDAO DataConnection = new ConexionDAO();
    private final ClienteDAO DataClient = new ClienteDAO();
    private final MascotaDAO DataPet = new MascotaDAO();
    private final SolicitudDAO DataBell = new SolicitudDAO();
    private final UsuarioDAO DataUser = new UsuarioDAO();
    private final VeterinarioDAO DataVet = new VeterinarioDAO();
    private final ConsultaDAO DataMeet = new ConsultaDAO();
    private int option;
    private Usuario CurrentUser = new Usuario();

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        option = Integer.parseInt(rq.getParameter("option"));
        CurrentUser = (Usuario) rq.getSession().getAttribute("CurrentUser");
        if (CurrentUser == null && CurrentUser.getIdRol() != 1) {
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
                            //Este bloque es utilizado para realizar los request que generan la lista de un modelo en especifico (SELECT QUERY)
                            if (option == 0) {
                                GetListUserContent(rq, rs);
                            }
                            if (option == 1) {
                                GetListVetContent(rq, rs);
                            }
                            if (option == 2) {
                                GetListClientContent(rq, rs);
                            }
                            if(option == 3){
                                GetListBells(rq, rs);
                            }
                            break;
                        case "3":
                            //Informacion de un usuario
                            GetUserInfo(rq, rs);
                            break;
                        case "4":
                            GetConnectionUserInfo(rq, rs);
                            break;
                        case "5":
                            GetMeetContent(rq, rs);
                            break;
                        case "6":
                            GetBellInfo(rq, rs);
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
                        GetListClientContent(rq, rs);
                        break;
                    case "5":
                        //Listado de solicitudes
                        GetListBells(rq, rs);
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
    
    protected void GetUserInfo(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        int InfoID = Integer.parseInt(rq.getParameter("UserInfoID"));
        rq.getSession().setAttribute("UserInfo", DataUser.showUser(InfoID));
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/user.jsp?option=" + option);
    }
    

    protected void GetListUserContent(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        List<Usuario> list = DataUser.read();
        rq.getSession().setAttribute("listUsers", list);
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/DataListUser.jsp");
    }

    protected void GetListVetContent(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        List<Veterinario> list = DataVet.read();
        rq.getSession().setAttribute("listUsers", list);
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/DataListVet.jsp");
    }

    protected void GetListClientContent(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        List<Cliente> list = DataClient.read();
        rq.getSession().setAttribute("listUsers", list);
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/DataListClient.jsp");
    }
    
    protected void GetListBells(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        List<Solicitud> list = DataBell.read();
        rq.getSession().setAttribute("listBell", list);
        rs.sendRedirect(rq.getContextPath()+"/views/users/admin/DataListSolicitudes.jsp");
    }

    protected void GetConnectionUserInfo(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int InfoID = Integer.parseInt(rq.getParameter("UserInfoID"));
        List<Conexion> list = DataConnection.ListOne(InfoID);
        rq.getSession().setAttribute("UserDataConnection", list);
        if (option == 1) {
            rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/dataconnection.jsp?option=1");
        } else {
            rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/dataconnection.jsp?option=2");
        }
    }

    protected void GetMeetContent(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        String InfoID = rq.getParameter("UserInfoID");
        List<Consulta> list = DataMeet.ListOne(InfoID);
        rq.getSession().setAttribute("DataMeet", list);
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/dataMeet.jsp?option=1");
    }

    protected void GetBellInfo(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        String InfoID = rq.getParameter("UserInfoID");
        List<Solicitud> list = DataBell.ListDataVet(InfoID);
        rq.getSession().setAttribute("DataBell", list);
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/dataBell.jsp?option=1");
    }

    

}
