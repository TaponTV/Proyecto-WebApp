/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-06-06 08:08:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.users.admin.content;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.IOException;
import models.Usuario;

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

      out.write("\r\n");
      out.write("\r\n");

    String name = "", email = "";
    if (response.isCommitted()) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    } else if (request.getSession(false) == null || request.getSession().getAttribute("CurrentUser") == null) {
        request.getRequestDispatcher("/CheckController").forward(request, response);
    } else {
        Usuario currentUser = (Usuario) request.getSession().getAttribute("CurrentUser");
        if (currentUser != null && currentUser.getIdRol() == 1) {
            String msg = "";
            if (request.getSession().getAttribute("msg") != null) {
                msg = request.getSession().getAttribute("msg").toString();
                out.print(msg);
                request.getSession().removeAttribute("msg");
            }
            name = currentUser.getNombre() + " " + currentUser.getApPaterno() + currentUser.getApMaterno();
            email = currentUser.getEmail();
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
    }

      out.write("\r\n");
      out.write("<div class=\"sidebar\">\r\n");
      out.write("    <div class=\"sidebar-brand\">\r\n");
      out.write("        <div class=\"brand-flex\">\r\n");
      out.write("            <img src=\"");
      out.print( request.getContextPath());
      out.write("/assets/img/logo.png\" width=\"40px\" alt=\"\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"sidebar-main\">\r\n");
      out.write("        <div class=\"sidebar-user\">\r\n");
      out.write("            <img src=\"");
      out.print( request.getContextPath());
      out.write("/assets/img/logo1.jpg\" width=\"40px\" alt=\"\">\r\n");
      out.write("            <div>\r\n");
      out.write("                <h3>");
      out.print( name);
      out.write("</h3>\r\n");
      out.write("                <span>");
      out.print( email);
      out.write("</span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"sidebar-menu\">\r\n");
      out.write("        <div class=\"menu-head\">\r\n");
      out.write("            <span><b>DashBoard</b></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"");
      out.print( request.getContextPath());
      out.write("/GetData?action=1\" class=\"slide\">\r\n");
      out.write("                    <span class=\"las la-chart-pie\"></span>\r\n");
      out.write("                    Estadísticas \r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <div class=\"menu-head\">\r\n");
      out.write("            <span><b>Operaciones</b></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"");
      out.print( request.getContextPath());
      out.write("/GetData?action=3\" class=\"slide\">\r\n");
      out.write("                    <span class=\"las la-stethoscope\"></span>\r\n");
      out.write("                    Veterinarios\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"");
      out.print( request.getContextPath());
      out.write("/GetData?action=4\" class=\"slide\">\r\n");
      out.write("                    <span class=\"las la-users\"></span>\r\n");
      out.write("                    Clientes\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
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
