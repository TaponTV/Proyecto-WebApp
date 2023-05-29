package controllers.common;

import DataObjects.DAO.MascotaDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Cliente;
import models.Mascota;
import models.Usuario;

/**
 *
 * @author TaponTV
 *
 * Este metodo es utilizado para mostrar una lista completa de las mascotas
 * registradas por un Cliente seleccionado
 */
@WebServlet(name = "listPets", urlPatterns = {"/listPets"})
public class listPets extends HttpServlet {

    private MascotaDAO DataPet = new MascotaDAO();
    private Cliente client = new Cliente();
    private List<Mascota> list;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        Usuario user = ((Usuario) rq.getSession().getAttribute("CurrentUser"));
        client.setIdUser(user.getIdUser());
        client.setIdCliente();
        int idcliente = client.getIdCliente();
        try {
            list = DataPet.read(idcliente);
            rq.getSession().setAttribute("DataPet", list);
            rs.sendRedirect(rq.getContextPath() + "/views/users/client/menu.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
