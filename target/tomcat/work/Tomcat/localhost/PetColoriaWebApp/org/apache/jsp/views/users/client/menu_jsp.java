/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-06-02 21:18:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.users.client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.Usuario;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        ");


            String name = "";
            if (response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else if (request.getSession(false) == null || request.getSession().getAttribute("CurrentUser") == null) {
                request.getRequestDispatcher("/CheckController").forward(request, response);
            } else {
                Usuario currentUser = (Usuario) request.getSession().getAttribute("CurrentUser");
                if (currentUser != null && currentUser.getIdRol() == 3) {
                    String msg = "";
                    if (request.getSession().getAttribute("msg") != null) {
                        msg = request.getSession().getAttribute("msg").toString();
                        out.print(msg);
                        request.getSession().removeAttribute("msg");
                    }
                    name = currentUser.getNombre() + " " + currentUser.getApPaterno() + currentUser.getApMaterno();
                } else {
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                    return;
                }
            }
        
      out.write("\r\n");
      out.write("        <h1> PetColoria - Version beta 1.0 </h1>\r\n");
      out.write("        <h3>Cliente: ");
      out.print( name);
      out.write("</h3>\r\n");
      out.write("        <h3> MENU CLIENTE </h3>\r\n");
      out.write("        <form action=\"");
      out.print( request.getContextPath());
      out.write("/BusquedaServlet\" method=\"post\">\r\n");
      out.write("            <input type=\"submit\" value =\"Buscar Veterinario\">\r\n");
      out.write("        </form>\r\n");
      out.write("        <form action=\"");
      out.print( request.getContextPath());
      out.write("/SolicitudCliente\" method=\"post\">\r\n");
      out.write("            <input type=\"submit\" value =\"Solicitudes pendientes\">\r\n");
      out.write("        </form>\r\n");
      out.write("        <form action=\"");
      out.print( request.getContextPath());
      out.write("/views/users/client/agregarmascota.jsp\" method=\"post\">\r\n");
      out.write("            <input type=\"submit\" value =\"Agregar Mascota\">\r\n");
      out.write("        </form>\r\n");
      out.write("        <form action=\"");
      out.print( request.getContextPath());
      out.write("/views/users/client/mascotas.jsp\" method=\"post\">\r\n");
      out.write("            <input type=\"submit\" value =\"Mostrar mascotas\">\r\n");
      out.write("        </form>\r\n");
      out.write("        <form action=\"");
      out.print( request.getContextPath());
      out.write("/logout\" method=\"post\">\r\n");
      out.write("            <input type=\"submit\" value =\"Cerrar Sesion\">\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
