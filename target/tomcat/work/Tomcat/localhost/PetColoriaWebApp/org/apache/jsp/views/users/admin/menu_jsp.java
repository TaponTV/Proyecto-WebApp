/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-05-14 20:01:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.users.admin;

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
      out.write("        <meta name=\"viewport\" content=\"width=devide-width\" initial-scale=\"1\" maximum-scale=\"1\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/admin.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://unpkg.com/boxicons@latest/css/boxicons.min.css\">\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Permanent+Marker&family=Poppins:wght@300;400;500;600;700;800;900&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("        <title>Dashboard</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            //if CurrentUser exists, then check the rol
            if (request.getSession().getAttribute("CurrentUser") == null) {
                request.getRequestDispatcher("/CheckController").forward(request, response);
            }
            String name = ((Usuario) request.getSession().getAttribute("CurrentUser")).getNombre() + " "
                    + ((Usuario) request.getSession().getAttribute("CurrentUser")).getApPaterno()
                    + ((Usuario) request.getSession().getAttribute("CurrentUser")).getApMaterno();
            String email = ((Usuario) request.getSession().getAttribute("CurrentUser")).getEmail();
        
      out.write("\r\n");
      out.write("        <div class=\"sidebar\">\r\n");
      out.write("            <div class=\"sidebar-brand\">\r\n");
      out.write("                <div class=\"brand-flex\">\r\n");
      out.write("                    <img src=\"");
      out.print( request.getContextPath());
      out.write("/assets/img/logo.png\" width=\"40px\" alt=\"\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"sidebar-main\">\r\n");
      out.write("                <div class=\"sidebar-user\">\r\n");
      out.write("                    <img src=\"");
      out.print( request.getContextPath());
      out.write("/assets/img/logo1.jpg\" width=\"40px\" alt=\"\">\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <h3>");
      out.print( name);
      out.write("</h3>\r\n");
      out.write("                        <span>");
      out.print( email);
      out.write("</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"sidebar-menu\">\r\n");
      out.write("                    <div class=\"menu-head\">\r\n");
      out.write("                        <span><b>DashBoard</b></span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"profile.jsp\">\r\n");
      out.write("                                <span class=\"las la-user-circle\"></span>\r\n");
      out.write("                                Perfil\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"menu.jsp\">\r\n");
      out.write("                                <span class=\"las la-chart-pie\"></span>\r\n");
      out.write("                                Estadísticas \r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"menu-head\">\r\n");
      out.write("                        <span><b>Operaciones</b></span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <span class=\"las la-stethoscope\"></span>\r\n");
      out.write("                                Veterinarios\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <span class=\"las la-users\"></span>\r\n");
      out.write("                                Clientes\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <span class=\"las la-file-alt\"></span>\r\n");
      out.write("                                Informe de Solicitudes\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <span class=\"las la-comments\"></span>\r\n");
      out.write("                                Comentarios\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <span class=\"las la-envelope-open\"></span>\r\n");
      out.write("                                Peticiones\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <span class=\"las la-question\"></span>\r\n");
      out.write("                                Ayuda\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <form action=\"");
      out.print( request.getContextPath());
      out.write("/logout\" method=\"post\">\r\n");
      out.write("                                <span class=\"las la-sign-out-alt\"></span>\r\n");
      out.write("                                <input type=\"submit\" value =\"Cerrar Sesion\">\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"main-content\">\r\n");
      out.write("            <header>\r\n");
      out.write("                <div class=\"menu-toggle\">\r\n");
      out.write("                    <label>\r\n");
      out.write("                        <span class=\"las la-bars\"></span>\r\n");
      out.write("                    </label>\r\n");
      out.write("                </div>\r\n");
      out.write("                <span class=\"bars\"></span>\r\n");
      out.write("                <div class=\"header-icons\">\r\n");
      out.write("                    <span class=\"las la-search\"></span>\r\n");
      out.write("                    <span class=\"las la-bookmark\"></span>\r\n");
      out.write("                    <span class=\"las la-sms\"></span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </header>\r\n");
      out.write("            <main>\r\n");
      out.write("                <div class=\"page-header\">\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <h1>Estadisticas de Datos</h1>\r\n");
      out.write("                        <small> Monitoreo General de las estadisticas de la página</small>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"cards\">\r\n");
      out.write("                    <div class=\"card-single\">\r\n");
      out.write("                        <div class=\"card-flex\">\r\n");
      out.write("                            <div class=\"card-info\">\r\n");
      out.write("                                <div class=\"card-head\">\r\n");
      out.write("                                    <span>Usuarios</span>\r\n");
      out.write("                                    <small>Numero de registros</small>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <h2>");
      out.print( request.getSession().getAttribute("DataUser") );
      out.write("</h2>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card-chart\">\r\n");
      out.write("                                <span class=\"las la-chart-line\"></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                            <div class=\"card-single\">\r\n");
      out.write("                        <div class=\"card-flex\">\r\n");
      out.write("                            <div class=\"card-info\">\r\n");
      out.write("                                <div class=\"card-head\">\r\n");
      out.write("                                    <span>Veterinarios</span>\r\n");
      out.write("                                    <small>Numero de registros</small>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <h2>");
      out.print( request.getSession().getAttribute("DataVet") );
      out.write("</h2>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card-chart\">\r\n");
      out.write("                                <span class=\"las la-chart-line\"></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                            <div class=\"card-single\">\r\n");
      out.write("                        <div class=\"card-flex\">\r\n");
      out.write("                            <div class=\"card-info\">\r\n");
      out.write("                                <div class=\"card-head\">\r\n");
      out.write("                                    <span>Clientes</span>\r\n");
      out.write("                                    <small>Numero de registros</small>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <h2>");
      out.print( request.getSession().getAttribute("DataClient") );
      out.write("</h2>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card-chart\">\r\n");
      out.write("                                <span class=\"las la-chart-line\"></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                            <div class=\"card-single\">\r\n");
      out.write("                        <div class=\"card-flex\">\r\n");
      out.write("                            <div class=\"card-info\">\r\n");
      out.write("                                <div class=\"card-head\">\r\n");
      out.write("                                    <span>Conexiones</span>\r\n");
      out.write("                                    <small>Numero de registros</small>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <h2>");
      out.print( request.getSession().getAttribute("DataConnection") );
      out.write("</h2>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card-chart\">\r\n");
      out.write("                                <span class=\"las la-chart-line\"></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                            <div class=\"card-single\">\r\n");
      out.write("                        <div class=\"card-flex\">\r\n");
      out.write("                            <div class=\"card-info\">\r\n");
      out.write("                                <div class=\"card-head\">\r\n");
      out.write("                                    <span>Mascotas</span>\r\n");
      out.write("                                    <small>Numero de registros</small>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <h2>");
      out.print( request.getSession().getAttribute("DataPet") );
      out.write("</h2>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card-chart\">\r\n");
      out.write("                                <span class=\"las la-chart-line\"></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                            <div class=\"card-single\">\r\n");
      out.write("                        <div class=\"card-flex\">\r\n");
      out.write("                            <div class=\"card-info\">\r\n");
      out.write("                                <div class=\"card-head\">\r\n");
      out.write("                                    <span>Solicitudes</span>\r\n");
      out.write("                                    <small>Numero de registros</small>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <h2>");
      out.print( request.getSession().getAttribute("DataBell") );
      out.write("</h2>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card-chart\">\r\n");
      out.write("                                <span class=\"las la-chart-line\"></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </main>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("<!-- Design Code by Code Resource -->\r\n");
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
