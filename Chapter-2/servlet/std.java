import javax.servlet.*; import java.io.*;
import javax.servlet.http.*;
public class std extends HttpServlet
{
private String message; String regi;
public void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException {
try
{
response.setContentType("text/html"); PrintWriter out =response.getWriter(); String name=request.getParameter("name"); out.println("Welcome "+name);
}
catch(Exception e)
{
e.printStackTrace();
}
}
}
