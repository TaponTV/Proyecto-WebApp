/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.admin;

import DataObjects.DAO.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name="RipDataUser", urlPatterns="/RipDataUser")
public class RipDataUser extends HttpServlet{

    private UsuarioDAO data = new UsuarioDAO();
    
    
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        int id = Integer.parseInt(rq.getParameter("UID"));
        String msg ="";
        boolean isDelete = data.delete(id);
        if(isDelete){
            msg = "<script>alert('Se elimino correctamente este usuario');</script>";
            rq.getSession().setAttribute("msg", msg);
        }else{
            msg = "<script>alert('Intenta mas tarde');</script>";
        }
        rs.sendRedirect(rq.getContextPath() + "/GetData?action=1");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
}
