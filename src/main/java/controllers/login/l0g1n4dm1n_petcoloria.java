package controllers.login;

import DataObjects.DAO.AdminDataObject;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.admin;

/**
 *
 * @author Admin
 */
@WebServlet(name="l0g1n4dm1n_petcoloria", urlPatterns={"/l0g1n4dm1n_petcoloria"})
public class l0g1n4dm1n_petcoloria extends HttpServlet{
    
    protected AdminDataObject data = new AdminDataObject();
    protected admin currentadmin = new admin();
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try{
            String AdminUser = rq.getParameter("id");
            
        }catch(Exception e){
            
        }
    }
    
}
