package com.chl.webserver.session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 当前这个示例运行时。相关文件已经包装为一个webapp项目，利用tomcat的加载器进行加载启动运行。详见myapp目录
 * @author chenhailong
 *
 */
@SuppressWarnings("serial")
public class SessionServlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    System.out.println("SessionServlet -- service");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>SessionServlet</title></head>");
    out.println("<body>");
    String value = request.getParameter("value");
    HttpSession session = request.getSession(true);
    out.println("<br>the previous value is " + 
      (String) session.getAttribute("value"));
    out.println("<br>the current value is " + value);
    session.setAttribute("value", value);
    out.println("<br><hr>");
    out.println("<form>");
    out.println("New Value: <input name=value>");
    out.println("<input type=submit>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
}
