/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-06-03 17:07:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.users.admin.userInfo.client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.Cliente;
import models.Usuario;

public final class UserClientData_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<main>\r\n");
      out.write("    <div class=\"page-header\">\r\n");
      out.write("        <div>\r\n");
      out.write("            <h1>Listado de Usuarios Registrados</h1>\r\n");
      out.write("            <small> Este es un listado que muestra un resumen de los usuarios registrados</small>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"header-actions\">\r\n");
      out.write("            <form action=\"");
      out.print( request.getContextPath());
      out.write("/GetData?action=2&option=2\" method=\"post\">\r\n");
      out.write("                <button type=\"submit\">\r\n");
      out.write("                    <span class=\"las la-spinner\"></span>\r\n");
      out.write("                    Regresar\r\n");
      out.write("                </button>\r\n");
      out.write("            </form>\r\n");
      out.write("            <form action=\"");
      out.print( request.getContextPath());
      out.write("/logout\" method=\"post\">\r\n");
      out.write("                <button type=\"submit\" value =\"Cerrar Sesion\">\r\n");
      out.write("                    <span class=\"las la-sign-out-alt\"></span>\r\n");
      out.write("                    Cerrar Sesión\r\n");
      out.write("                </button>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");

        Usuario user = (Usuario) request.getSession().getAttribute("UserInfo");
        Cliente client = (Cliente) request.getSession().getAttribute("data" + user.getIdUser());
        if (user != null) {
      out.write("\r\n");
      out.write("    <label> Nombre </label>\r\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getNombre());
      out.write("\"><br>\r\n");
      out.write("    <label> Apellido Paterno </label>\r\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getApPaterno());
      out.write("\"><br>\r\n");
      out.write("    <label> Apellido Materno </label>\r\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getApMaterno());
      out.write("\"><br>\r\n");
      out.write("    <label> Edad </label>\r\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getEdad());
      out.write("\"><br>\r\n");
      out.write("    <label> País </label>\r\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getPais());
      out.write("\"><br>\r\n");
      out.write("    <label> Estado </label>\r\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getEstado());
      out.write("\"><br>\r\n");
      out.write("    <label> Ciudad </label>\r\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getCiudad());
      out.write("\"><br>\r\n");
      out.write("    <label> Celular </label>\r\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getCelular());
      out.write("\"><br>\r\n");
      out.write("    <label> Telefono </label>\r\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getTelefono());
      out.write("\"><br>\r\n");
      out.write("    <label> Email </label>\r\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getEmail());
      out.write("\"><br>\r\n");
      out.write("    <label> Tipo de Usuario </label>\r\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getRol());
      out.write("\"><br>\r\n");
      out.write("\r\n");
      out.write("    <form method=\"post\" action=\"/RipDataUser\">\r\n");
      out.write("        <input type=\"text\" value=\"");
      out.print( user.getIdUser());
      out.write("\" name=\"UID\" hidden>\r\n");
      out.write("        <button type=\"submit\">Eliminar Usuario</button>\r\n");
      out.write("    </form>\r\n");
      out.write("    <form method=\"post\" action=\"/ModifyDataUser\">\r\n");
      out.write("        <input type=\"text\" value=\"");
      out.print( user.getIdUser());
      out.write("\" name=\"UID\" hidden>\r\n");
      out.write("        <button type=\"submit\">Aplicar Cambios</button>\r\n");
      out.write("    </form>\r\n");
      out.write("    <form action=\"");
      out.print( request.getContextPath());
      out.write("/ConnectionListController?typeuser=2\" method=\"post\">\r\n");
      out.write("        <input type=\"text\" value=\"");
      out.print( user.getIdUser());
      out.write("\" name=\"UserInfoID\" hidden>\r\n");
      out.write("        <input type=\"submit\" value=\"Mostrar Conexiones\">\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("    <form action=\"");
      out.print( request.getContextPath());
      out.write("/ShowMeetController?typeUser=2\" method=\"post\">\r\n");
      out.write("        <input type=\"text\" value=\"");
      out.print( client.getIdCliente());
      out.write("\" name=\"ClientID\" hidden>\r\n");
      out.write("        <input type=\"submit\" value=\"Mostrar Citas\">\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("    <form action=\"");
      out.print( request.getContextPath());
      out.write("/ShowBellController?typeUser=2\" method=\"post\">\r\n");
      out.write("        <input type=\"text\" value=\"");
      out.print( client.getIdCliente());
      out.write("\" name=\"ClientID\" hidden>\r\n");
      out.write("        <input type=\"submit\" value=\"Mostrar Solicitudes\">\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("    <form action=\"");
      out.print( request.getContextPath());
      out.write("/ShowPetController\" method=\"post\">\r\n");
      out.write("        <input type=\"text\" value=\"");
      out.print( client.getIdCliente());
      out.write("\" name=\"ClientID\" hidden>\r\n");
      out.write("        <input type=\"submit\" value=\"Mascotas Registradas\">\r\n");
      out.write("    </form>\r\n");
      out.write("    ");

        }
    
      out.write("\r\n");
      out.write("</tbody>\r\n");
      out.write("</main>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
