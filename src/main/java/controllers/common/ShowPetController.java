package controllers.common;

import DataObjects.DAO.MascotaDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Mascota;

/**
 *
 * @author TaponTV
 * 
 * Este metodo es utilizado para mostrar una lista completa de las mascotas registradas por un Cliente seleccionado
 */
@WebServlet(name="ShowPetController", urlPatterns={"/ShowPetController"})
public class ShowPetController  extends HttpServlet{

    private MascotaDAO DataPet = new MascotaDAO();
    private List<Mascota> list;
    
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        int ClientID = Integer.parseInt(rq.getParameter("ClientID"));
        try{
            list = DataPet.read(ClientID);
            rq.getSession().setAttribute("DataPet", list);
            rs.sendRedirect(rq.getContextPath() + "/views/users/admin/userInfo/datapet.jsp?id=" + ClientID);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    
}
