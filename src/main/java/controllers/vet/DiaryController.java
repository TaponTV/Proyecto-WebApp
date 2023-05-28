/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.vet;

import DataObjects.DAO.ConsultaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Consulta;
import models.Usuario;

/**
 *
 * @author Admin
 */
@WebServlet(name="DiaryController", urlPatterns={"/DiaryController"})
public class DiaryController extends HttpServlet{

    private ConsultaDAO data = new ConsultaDAO();
    private List<Consulta> list = new ArrayList<>();
    private Usuario user = new Usuario();
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
       user = (Usuario) rq.getSession().getAttribute("CurrentUser");
       String id = rq.getSession().getAttribute("vetID").toString();
       list = data.ListOne(id, 1);
       rq.getSession().setAttribute("datalist", list);
       rs.sendRedirect(rq.getContextPath()+"/views/users/vet/menu.jsp?section=2");
    }
    
    
}
