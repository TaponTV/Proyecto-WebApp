/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-05-20 18:24:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.users.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sidebar_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<div class=\"sidebar-menu\">\n");
      out.write("    <div class=\"menu-head\">\n");
      out.write("        <span><b>DashBoard</b></span>\n");
      out.write("    </div>\n");
      out.write("    <ul>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"#\" class=\"slide\">\n");
      out.write("                <span class=\"las la-user-circle\"></span>\n");
      out.write("                Perfil\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"");
      out.print( request.getContextPath());
      out.write("/GetData?action=1\" class=\"slide\">\n");
      out.write("                <span class=\"las la-chart-pie\"></span>\n");
      out.write("                Estadísticas \n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("    </ul>\n");
      out.write("\n");
      out.write("    <div class=\"menu-head\">\n");
      out.write("        <span><b>Operaciones</b></span>\n");
      out.write("    </div>\n");
      out.write("    <ul>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"");
      out.print( request.getContextPath());
      out.write("/GetData?action=3\" class=\"slide\">\n");
      out.write("                <span class=\"las la-stethoscope\"></span>\n");
      out.write("                Veterinarios\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"");
      out.print( request.getContextPath());
      out.write("/GetData?action=4\" class=\"slide\">\n");
      out.write("                <span class=\"las la-users\"></span>\n");
      out.write("                Clientes\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"#\" class=\"slide\">\n");
      out.write("                <span class=\"las la-file-alt\"></span>\n");
      out.write("                Informe de Solicitudes\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"#\" class=\"slide\">\n");
      out.write("                <span class=\"las la-comments\"></span>\n");
      out.write("                Comentarios\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"#\" class=\"slide\">\n");
      out.write("                <span class=\"las la-envelope-open\"></span>\n");
      out.write("                Peticiones\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"#\" class=\"slide\">\n");
      out.write("                <span class=\"las la-question\"></span>\n");
      out.write("                Ayuda\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("    </ul>\n");
      out.write("</div>");
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