import java.io.*; import java.util.*; import javax.servlet.*;
import javax.servlet.http.*; import java.sql.*;
import java.sql.DriverManager; import java.sql.Connection; import java.sql.SQLException;

public class p12_db2 extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html"); Connection conn = null;
Statement stmt = null;

PrintWriter out = response.getWriter(); String pid = request.getParameter("pid");

try {
Class.forName("com.mysql.jdbc.Driver");
// create a database connection using jdbc , port no used here is 3307
// database name is college and username is root , there is no password conn =
DriverManager.getConnection("jdbc:mysql://localhost:3306/player", "root", "");

 



form
 
stmt = conn.createStatement(); String sql;
// select data from table where dept matches the value given by user in
 
sql = "SELECT * FROM stats where pid = ?"; PreparedStatement pstmt = conn.prepareStatement(sql); pstmt.setString(1, pid);

ResultSet rs = pstmt.executeQuery();
// Extract data from result set ws3

while (rs.next()) {
// Retrieve by column name
String name=rs.getString("name"); Integer gp = rs.getInt("games"); Integer goals = rs.getInt("goals"); Integer assist = rs.getInt("assist"); Integer fouls = rs.getInt("foul");
// Display values
out.println("<p> <b>Player ID :</b> " + pid + "<br>"); out.println("<b>Name : </b>" + name + "<br><hr style='border: 1px
solid'><br>");
out.println("<b>Games palyed : </b>" + gp + "<br>"); out.println("<b>Goals : </b>" + goals + "<br>"); out.println("<b>Assists : </b>" + assist + "<br>"); out.println("<b>Fouls : </b>" +fouls + "<br></p>");
}
out.println("</body></html>");
// Clean-up environment rs.close();
stmt.close();
conn.close();
} catch (Exception e) {
System.out.print("Do not connect to DB - Error:" + e);
}
}
}
