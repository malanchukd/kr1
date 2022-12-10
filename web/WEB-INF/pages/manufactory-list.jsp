<%@ page import="model.Manufactory" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Manufactory</title>
</head>
<body>
<%@include file="header.html"%>
<h2>List of Manufactory</h2>
<%
  List<Manufactory> manufactories = (List<Manufactory>) request.getAttribute("manufactory");
  if(!manufactories.isEmpty()) {
%>
<table border="2">
  <tr>
    <th>No.</th>
    <th>Name</th>
    <th>Country</th>
    <th colspan="3">Operation</th>
  </tr>
  <%
    for (int i = 0; i < manufactories.size(); i++) {
  %>
    <tr>
      <td><%=i + 1%></td>
      <td><%=manufactories.get(i).getName()%></td>
      <td><%=manufactories.get(i).getCountry()%></td>
      <td><a href="/read-manufactory?id=<%=manufactories.get(i).getId()%>">Read</a></td>
      <td><a href="/edit-manufactory?id=<%=manufactories.get(i).getId()%>">Edit</a></td>
      <td><a href="/delete-manufactory?id=<%=manufactories.get(i).getId()%>">Delete</a></td>
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
