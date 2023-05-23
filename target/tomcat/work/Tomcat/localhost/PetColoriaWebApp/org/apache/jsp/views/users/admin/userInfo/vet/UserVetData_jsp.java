/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-05-23 06:50:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.users.admin.userInfo.vet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.Veterinario;
import models.Usuario;

public final class UserVetData_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<main>\n");
      out.write("    <div class=\"page-header\">\n");
      out.write("        <div>\n");
      out.write("            <h1>Listado de Usuarios Registrados</h1>\n");
      out.write("            <small> Este es un listado que muestra un resumen de los usuarios registrados</small>\n");
      out.write("        </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "headeractionsVet.jsp", out, false);
      out.write("\n");
      out.write("    </div>\n");
      out.write("    ");

        Usuario user = (Usuario) request.getSession().getAttribute("UserInfo");
        Veterinario vet = (Veterinario) request.getSession().getAttribute("data" + user.getIdUser());
        if (user != null && vet != null) {
      out.write("\n");
      out.write("    <label> Nombre </label>\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getNombre());
      out.write("\"><br>\n");
      out.write("    <label> Apellido Paterno </label>\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getApPaterno());
      out.write("\"><br>\n");
      out.write("    <label> Apellido Materno </label>\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getApMaterno());
      out.write("\"><br>\n");
      out.write("    <label> Edad </label>\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getEdad());
      out.write("\"><br>\n");
      out.write("    <label> País </label>\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getPais());
      out.write("\"><br>\n");
      out.write("    <label> Estado </label>\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getEstado());
      out.write("\"><br>\n");
      out.write("    <label> Ciudad </label>\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getCiudad());
      out.write("\"><br>\n");
      out.write("    <label> Celular </label>\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getCelular());
      out.write("\"><br>\n");
      out.write("    <label> Telefono </label>\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getTelefono());
      out.write("\"><br>\n");
      out.write("    <label> Email </label>\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getEmail());
      out.write("\"><br>\n");
      out.write("    <label> Tipo de Usuario </label>\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( user.getRol());
      out.write("\" readonly><br>\n");
      out.write("    <label> Cedula </label>\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( vet.getCedula());
      out.write("\" readonly><br>\n");
      out.write("    <label> Especialidad </label>\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( vet.getEspecialidad());
      out.write("\" readonly><br>\n");
      out.write("    <label> Fecha de Titulación</label>\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( vet.getFechaTitulacion());
      out.write("\" readonly><br>\n");
      out.write("    <label> Universidad </label>\n");
      out.write("    <input type=\"text\" value=\"");
      out.print( vet.getUniversidad());
      out.write("\" readonly><br>\n");
      out.write("    <form method=\"post\" action=\"/RipDataUser\">\n");
      out.write("        <input type=\"text\" value=\"");
      out.print( user.getIdUser());
      out.write("\" name=\"UID\" hidden>\n");
      out.write("        <button type=\"submit\">Eliminar Usuario</button>\n");
      out.write("    </form>\n");
      out.write("    <form method=\"post\" action=\"/ModifyDataUser\">\n");
      out.write("        <input type=\"text\" value=\"");
      out.print( user.getIdUser());
      out.write("\" name=\"UID\" hidden>\n");
      out.write("        <button type=\"submit\">Aplicar Cambios</button>\n");
      out.write("    </form>\n");
      out.write("    ");

        }
    
      out.write("\n");
      out.write("\n");
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