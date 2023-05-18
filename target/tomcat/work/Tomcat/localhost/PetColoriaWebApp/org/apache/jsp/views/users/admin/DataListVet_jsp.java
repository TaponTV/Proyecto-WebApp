/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-05-18 16:23:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.users.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import models.Veterinario;
import models.Usuario;
import java.io.*;
import java.util.*;

public final class DataListVet_jsp extends org.apache.jasper.runtime.HttpJspBase
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

            String name = "", email = "";
            if (request.getSession(false) == null || request.getSession().getAttribute("CurrentUser") == null) {
                request.getRequestDispatcher("/CheckController").forward(request, response);
            } else {
                Usuario currentUser = (Usuario) request.getSession().getAttribute("CurrentUser");
                if (currentUser != null && currentUser.getIdRol() == 1) {
                    name = ((Usuario) request.getSession().getAttribute("CurrentUser")).getNombre() + " "
                            + ((Usuario) request.getSession().getAttribute("CurrentUser")).getApPaterno()
                            + ((Usuario) request.getSession().getAttribute("CurrentUser")).getApMaterno();
                    email = ((Usuario) request.getSession().getAttribute("CurrentUser")).getEmail();
                } else {
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                }
            }
        
      out.write("\n");
      out.write("        <div class=\"sidebar\">\n");
      out.write("            <div class=\"sidebar-brand\">\n");
      out.write("                <div class=\"brand-flex\">\n");
      out.write("                    <img src=\"");
      out.print( request.getContextPath());
      out.write("/assets/img/logo.png\" width=\"40px\" alt=\"\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"sidebar-main\">\n");
      out.write("                <div class=\"sidebar-user\">\n");
      out.write("                    <img src=\"");
      out.print( request.getContextPath());
      out.write("/assets/img/logo1.jpg\" width=\"40px\" alt=\"\">\n");
      out.write("                    <div>\n");
      out.write("                        <h3>");
      out.print( name);
      out.write("</h3>\n");
      out.write("                        <span>");
      out.print( email);
      out.write("</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"sidebar-menu\">\n");
      out.write("                    <div class=\"menu-head\">\n");
      out.write("                        <span><b>DashBoard</b></span>\n");
      out.write("                    </div>\n");
      out.write("                    <ul>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\" class=\"slide\">\n");
      out.write("                                <span class=\"las la-user-circle\"></span>\n");
      out.write("                                Perfil\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"");
      out.print( request.getContextPath());
      out.write("/GetData?action=1\" class=\"slide\">\n");
      out.write("                                <span class=\"las la-chart-pie\"></span>\n");
      out.write("                                Estadísticas \n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    <div class=\"menu-head\">\n");
      out.write("                        <span><b>Operaciones</b></span>\n");
      out.write("                    </div>\n");
      out.write("                    <ul>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"DataListVet.jsp\" class=\"slide\">\n");
      out.write("                                <span class=\"las la-stethoscope\"></span>\n");
      out.write("                                Veterinarios\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"DataListClient.jsp\" class=\"slide\">\n");
      out.write("                                <span class=\"las la-users\"></span>\n");
      out.write("                                Clientes\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\" class=\"slide\">\n");
      out.write("                                <span class=\"las la-file-alt\"></span>\n");
      out.write("                                Informe de Solicitudes\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\" class=\"slide\">\n");
      out.write("                                <span class=\"las la-comments\"></span>\n");
      out.write("                                Comentarios\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\" class=\"slide\">\n");
      out.write("                                <span class=\"las la-envelope-open\"></span>\n");
      out.write("                                Peticiones\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\" class=\"slide\">\n");
      out.write("                                <span class=\"las la-question\"></span>\n");
      out.write("                                Ayuda\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"main-content\">\n");
      out.write("            <header>\n");
      out.write("                <div class=\"menu-toggle\">\n");
      out.write("                    <label>\n");
      out.write("                        <span class=\"las la-bars\"></span>\n");
      out.write("                    </label>\n");
      out.write("                </div>\n");
      out.write("                <span class=\"bars\"></span>\n");
      out.write("                <div class=\"header-icons\">\n");
      out.write("                    <span class=\"las la-search\"></span>\n");
      out.write("                    <span class=\"las la-bookmark\"></span>\n");
      out.write("                    <span class=\"las la-sms\"></span>\n");
      out.write("                </div>\n");
      out.write("            </header>\n");
      out.write("            <main>\n");
      out.write("                <div class=\"page-header\">\n");
      out.write("                    <div>\n");
      out.write("                        <h1>Listado de Veterinarios Registrados</h1>\n");
      out.write("                        <small> Este es un listado que muestra un resumen de los veterinarios registrados</small>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"header-actions\">\n");
      out.write("                        <form action=\"");
      out.print( request.getContextPath());
      out.write("/GetData?action=2&option=1\" method=\"post\">\n");
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
      out.write("                            <td> ID Usuario </td>\n");
      out.write("                            <td> Nombre </td>\n");
      out.write("                            <td> Apellidos </td>\n");
      out.write("                            <td> Pais Origen </td>\n");
      out.write("                            <td> Residencia </td>\n");
      out.write("                            <td> Correo </td>\n");
      out.write("                            <td>    </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");
 List<Veterinario> listUsers = (List<Veterinario>) request.getSession().getAttribute("listUsers");

                            if (listUsers != null) {
                                for (Veterinario user : listUsers) {
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print( user.getIdUser());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( user.getNombre());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( user.getApPaterno());
      out.write(' ');
      out.print( user.getApMaterno());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( user.getCedula());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( user.getEspecialidad());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( user.getFechaTitulacion());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( user.getUniversidad());
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <form action=\"");
      out.print( request.getContextPath());
      out.write("/GetData?action=4&option=1\" method=\"post\">\n");
      out.write("                                    ");
 request.getSession().setAttribute("data" + user.getIdUser(), user);
      out.write("\n");
      out.write("                                    <input type=\"text\" value=\"");
      out.print( user.getIdUser());
      out.write("\" name=\"UserInfoID\" hidden>\n");
      out.write("                                    <input type=\"submit\" value=\"Mostrar Conexiones\">\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <form action=\"");
      out.print( request.getContextPath());
      out.write("/GetData?action=5&option=1\" method=\"post\">\n");
      out.write("                                    ");
 request.getSession().setAttribute("data" + user.getIdUser(), user);
      out.write("\n");
      out.write("                                    <input type=\"text\" value=\"");
      out.print( user.getCedula());
      out.write("\" name=\"UserInfoID\" hidden>\n");
      out.write("                                    <input type=\"submit\" value=\"Mostrar Citas\">\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <form action=\"");
      out.print( request.getContextPath());
      out.write("/GetData?action=3&option=1\" method=\"post\">\n");
      out.write("                                    ");
 request.getSession().setAttribute("data" + user.getIdUser(), user);
      out.write("\n");
      out.write("                                    <input type=\"text\" value=\"");
      out.print( user.getIdUser());
      out.write("\" name=\"UserInfoID\" hidden>\n");
      out.write("                                    <input type=\"submit\" value=\"Mostrar Solicitudes\">\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <form action=\"");
      out.print( request.getContextPath());
      out.write("/GetData?action=3&option=1\" method=\"post\">\n");
      out.write("                                    ");
 request.getSession().setAttribute("data" + user.getIdUser(), user);
      out.write("\n");
      out.write("                                    <input type=\"text\" value=\"");
      out.print( user.getIdUser());
      out.write("\" name=\"UserInfoID\" hidden>\n");
      out.write("                                    <input type=\"submit\" value=\"Mostrar información completa\">\n");
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
