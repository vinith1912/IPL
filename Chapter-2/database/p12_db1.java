import java.io.*; import java.util.*; import javax.servlet.*;
import javax.servlet.http.*; import java.sql.*;
import java.sql.DriverManager; import java.sql.Connection; import java.sql.SQLException;

public class p12_db1 extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html"); Connection conn=null;
Statement stmt=null;
 
PrintWriter out = response.getWriter(); try
{
Class.forName("com.mysql.jdbc.Driver");

//out.println("<h1> into class</h1>");
//create a database connection using jdbc , port no used here is 3307
// database name is college and username is root , there is no password conn =
DriverManager.getConnection("jdbc:mysql://localhost:3306/player","root", ""); if(conn!=null)
{
out.println("<h1> Players Information</h1>");
}
stmt = conn.createStatement(); String sql;
//display all player information
sql = "SELECT * FROM players";

ResultSet rs = stmt.executeQuery(sql);
// Extract data from result set

while(rs.next())
{
//out.println("<h1> into while loop</h1>");
//Retrieve by column name

String pid = rs.getString("pid"); String name = rs.getString("name");
String country = rs.getString("country"); String pos = rs.getString("position"); String club = rs.getString("club");

//Display values
out.println("<hr><p> <b>Player ID :</b> " + pid + "<br>"); out.println("<b>Name : </b>" + name + "<br>"); out.println("<b>Country : </b>" + country + "<br>"); out.println("<b>Position : </b>" + pos + "<br>"); out.println("<b>Club : </b>" + club + "<br></p>");
}
out.println("</body></html>");
// Clean-up environment rs.close();
 
stmt.close();
conn.close();
}
catch(Exception e)
{
System.out.print("Do not connect to DB - Error:"+e);
}
}
}
