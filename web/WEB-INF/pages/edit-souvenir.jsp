<%@ page import="model.Souvenir" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit existing Souvenir</title>
</head>
<body>
<%@include file="header.html"%>
<h2>Edit existing Souvenir</h2>
<form action="/edit-souvenir" method="post">
  <%
    Souvenir souvenir = (Souvenir) request.getAttribute("souvenir");
    String message = (String) request.getAttribute("error");
  %>

  <p style="color:black"><%= message %></p>

  <table>
    <tr>
      <td><label for="id">Id: </label></td>
      <td><input type="text" id="id" name="id" value="<%=souvenir.getId()%>" disabled></td>
    </tr>
    <tr>
      <td><label for="name">Name: </label></td>
      <td><input type="text" id="name" name = "name" value="<%=souvenir.getName()%>"></td>
    </tr>
    <tr>
      <td><label for="manufactoryName">ManufactoryName: </label></td>
      <td><input type="text" id="manufactoryName" name="manufactoryName" value="<%=souvenir.getManufactoryName()%>"></td>
    </tr>
    <tr>
      <td><label for="releaseDate">ReleaseDate: </label></td>
      <td><input type="text" id="releaseDate" name="releaseDate" value="<%=souvenir.getReleaseDate()%>"></td>
    </tr>
    <tr>
      <td><label for="price">ManufactoryName: </label></td>
      <td><input type="text" id="price" name="price" value="<%=souvenir.getPrice()%>"></td>
    </tr>
    <tr>
      <td><input type="submit" value="Update"></td>
      <td><input type="submit" value="Clear"></td>
    </tr>
  </table>
</form>
</body>
</html>
