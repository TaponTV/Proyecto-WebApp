/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-05-21 01:05:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.users.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.Solicitud;
import java.util.List;
import models.Usuario;
import java.io.*;
import java.util.*;

public final class DataListSolicitudes_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=utf-8");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=devide-width\" initial-scale=\"1\" maximum-scale=\"1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/admin.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://unpkg.com/boxicons@latest/css/boxicons.min.css\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Permanent+Marker&family=Poppins:wght@300;400;500;600;700;800;900&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <title>Dashboard - Veterinarios</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "content/sidebar.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"main-content\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "content/header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            <main>\n");
      out.write("                <div class=\"page-header\">\n");
      out.write("                    <div>\n");
      out.write("                        <h1>Solicitudes en la página</h1>\n");
      out.write("                        <small> Lista de solicitudes registradas dentro de la aplicación</small>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"header-actions\">\n");
      out.write("                        <form action=\"");
      out.print( request.getContextPath());
      out.write("/GetData?action=2&option=3\" method=\"post\">\n");
      out.write("                            <button type=\"submit\">\n");
      out.write("                                <span class=\"las la-spinner\"></span>\n");
      out.write("                                Actualizar Métricas\n");
      out.write("                            </button>\n");
      out.write("                        </form>\n");
      out.write("                        <form action=\"");
      out.print( request.getContextPath());
      out.write("/logout\" method=\"post\">\n");
      out.write("                            <button type=\"submit\" value =\"Cerrar Sesion\">\n");
      out.write("                                <span class=\"las la-sign-out-alt\"></span>\n");
      out.write("                                Cerrar Sesión\n");
      out.write("                            </button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <table>\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <td> ID Solicitud </td>\n");
      out.write("                            <td> Cliente Solicitante </td>\n");
      out.write("                            <td> Veterinario </td>\n");
      out.write("                            <td> Fecha </td>\n");
      out.write("                            <td> Status </td>\n");
      out.write("                            <td colspan=\"4\"> Operaciones   </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");
 List<Solicitud> listBell = (List<Solicitud>) request.getSession().getAttribute("listBell");

                            if (listBell != null) {
                                for (Solicitud bells : listBell) {
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print( bells.getIdSolicitud());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( bells.getNombre());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( bells.getvNombre());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( bells.getFecha());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( bells.getStatus() );
      out.write("</td>\n");
      out.write("                            <td>\n");
      out.write("                                <form action=\"");
      out.print( request.getContextPath());
      out.write("/GetData?action=7&option=1\" method=\"post\">\n");
      out.write("                                    ");
 request.getSession().setAttribute("data" + bells.getIdSolicitud(), bells);
      out.write("\n");
      out.write("                                    <input type=\"text\" value=\"");
      out.print( bells.getIdSolicitud());
      out.write("\" name=\"BellInfoID\" hidden>\n");
      out.write("                                    <input type=\"submit\" value=\"Ver más\">\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                                }
                            }
                        
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </main>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
