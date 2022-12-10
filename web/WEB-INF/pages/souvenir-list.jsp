<%@ page import="model.Souvenir" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Souvenir</title>
</head>
<body>
<%@include file="header.html"%>
<h2>List of Souvenir</h2>
<%
  List<Souvenir> souvenirs = (List<Souvenir>) request.getAttribute("souvenir");
  if(!souvenirs.isEmpty()) {
%>
<table border="2">
  <tr>
    <th>No.</th>
    <th>Name</th>
    <th>Manufactory Name</th>
    <th>Release Date</th>
    <th>Price</th>
    <th colspan="3">Operation</th>
  </tr>
  <%
    for (int i = 0; i < souvenirs.size(); i++) {
  %>
  <tr>
    <td><%=i + 1%></td>
    <td><%=souvenirs.get(i).getName()%></td>
    <td><%=souvenirs.get(i).getManufactoryName()%></td>
    <td><%=souvenirs.get(i).getReleaseDate()%></td>
    <td><%=souvenirs.get(i).getPrice()%></td>
    <td><a href="/read-souvenir?id=<%=souvenirs.get(i).getId()%>">Read</a></td>
    <td><a href="/edit-souvenir?id=<%=souvenirs.get(i).getId()%>">Edit</a></td>
    <td><a href="/delete-souvenir?id=<%=souvenirs.get(i).getId()%>">Delete</a></td>
  </tr>
  <%
    }
  %>

</table>
<%
  }
%>

</body>
</html>
