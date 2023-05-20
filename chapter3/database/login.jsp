<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>
<%
Connection conn=null; Statement stmt=null;
String uname = request.getParameter("uname"); Cookie ck = new Cookie("username", uname); response.addCookie(ck);
out.println("<a href='logout.jsp' target='_blank' style='text-align:right
;'>Logout</a><br><hr style='border:3px solid black;'> "); try {
Class.forName("com.mysql.jdbc.Driver"); conn =
DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shop", "root", ""); if(conn==null) {
out.println("<h1> Issues in Connection</h1>");
}
String sql;
stmt = conn.createStatement();
sql = "SELECT * FROM product"; ResultSet rs = stmt.executeQuery(sql);
%>
<h3>Products Available</h3>
<form action='total.jsp' method='post'>
<table cellspacing='0' width='350px' border='1'>
<tr>
<td> Product Name </td>
<td> Product Price </td>
<td> Checked </td>
</tr>
<%
String name = ""; String price = ""; while(rs.next()) {
 
name = rs.getString("name"); price = rs.getString("price");
%>
<tr>
<td><%= name %></td>
<td><%= price %></td>
<td><input type='checkbox' name='selected' value = '<%= name
%>'></td>
</tr>
<%
}
rs.close();
stmt.close();
conn.close();
} catch(Exception e) {
System.out.print("Do not connect to DB - Error:"+e);
}
out.println("</table>");
out.println("<br><input type='submit' value='Calculate Total'></form>");
%>
</body>
</html>
