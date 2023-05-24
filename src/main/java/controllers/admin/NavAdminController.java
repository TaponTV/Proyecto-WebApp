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

@WebServlet(name = "NavAdminController", value = {"/GetData"})
public class NavAdminController extends HttpServlet {

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
                    }
                }
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
                        GetListComments(rq, rs);
                        break;
                    case "7":
                        //Listado de peticiones
                        GetListAdminBells(rq, rs);
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
        List<Usuario> list = DataUser.read();
        rq.getSession().setAttribute("listUsers", list);
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/datalist/DataListUser.jsp");
    }

    protected void GetListVetContent(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        List<Veterinario> list = DataVet.read();
        rq.getSession().setAttribute("listUsers", list);
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/datalist/DataListVet.jsp");
    }

    protected void GetListClientContent(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        List<Cliente> list = DataClient.read();
        rq.getSession().setAttribute("listUsers", list);
        rs.sendRedirect(rq.getContextPath() + "/views/users/admin/datalist/DataListClient.jsp");
    }
    
    protected void GetListBells(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        List<Solicitud> list = DataBell.read();
        rq.getSession().setAttribute("listBell", list);
        rs.sendRedirect(rq.getContextPath()+"/views/users/admin/datalist/DataListSolicitudes.jsp");
    }

    private void GetListComments(HttpServletRequest rq, HttpServletResponse rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void GetListAdminBells(HttpServletRequest rq, HttpServletResponse rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
