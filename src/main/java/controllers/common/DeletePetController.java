package controllers.common;

import DataObjects.DAO.MascotaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TaponTV
 */
@WebServlet(name = "DeletePetController", urlPatterns = {"/DeletePetController"})
public class DeletePetController extends HttpServlet {

    private MascotaDAO DataPet = new MascotaDAO();
    private int PetID;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try {
            String msg;
            PetID = Integer.parseInt(rq.getSession().getAttribute("PetID").toString());
            rq.getSession().removeAttribute("PetID");
            if (rq.getParameter("option").equals("yes")) {
                boolean isUpdate = DataPet.delete(PetID);
                if(isUpdate){
                    msg = "<script>alert('Mascota eliminada :( ');</script>";
                }else{
                    msg = "<script>alert('No fue posible realizar la eliminación, intentalo más tarde');</script>";
                }
                rq.getSession().setAttribute("msg", msg);
            }
            rs.sendRedirect(rq.getContextPath()+"/CheckController");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
