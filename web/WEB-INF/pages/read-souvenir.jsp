<%@ page import="model.Souvenir" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read existing Souvenir</title>
</head>
<body>
<table>
  <%@include file="header.html"%>
  <h1>Current Souvenir</h1>
  <%
    Souvenir souvenir = (Souvenir) request.getAttribute("souvenir");
  %>

  <tr>
    <td>Id:</td>
    <td><strong><%=souvenir.getId()%></strong></td>
  </tr>
  <tr>
    <td>Name:</td>
    <td><strong><%=souvenir.getName()%></strong></td>
  </tr>
  <tr>
    <td>ManufactoryName:</td>
    <td><strong><%=souvenir.getManufactoryName()%></strong></td>
  </tr>
  <tr>
    <td>ReleaseDate:</td>
    <td><strong><%=souvenir.getReleaseDate()%></strong></td>
  </tr>
  <tr>
    <td>Price:</td>
    <td><strong><%=souvenir.getPrice()%></strong></td>
  </tr>
</table>
</body>
</html>
