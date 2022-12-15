<%@ page import="model.Manufactory" %>
<%@ page import="model.Country" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit existing Manufactory</title>
</head>
<body>
    <%@include file="header.html"%>
    <h2>Edit existing Manufactory</h2>
    <form action="/edit-manufactory" method="post">
      <%
        Manufactory manufactory = (Manufactory) request.getAttribute("manufactory");
        String message = (String) request.getAttribute("error");
      %>

      <p style="color:black"><%= message %></p>

      <table>
        <tr>
          <td><label for="id">Id: </label></td>
          <td><input type="text" id="id" name="id" value="<%=manufactory.getId()%>" disabled></td>
        </tr>
        <tr>
          <td><label for="name">Name: </label></td>
          <td><input type="text" id="name" name = "name" value="<%=manufactory.getName()%>"></td>
        </tr>
        <tr>
          <td><label for="country">Country:</label></td>
          <td>
            <select id="country" name="country">
              <option value="<%=Country.UKRAINE.toString()%>">Ukraine</option>
              <option value="<%=Country.USA.toString()%>">USA</option>
              <option value="<%=Country.GERMANY.toString()%>">Germany</option>
              <option value="<%=Country.POLAND.toString()%>">Poland</option>
              <option value="<%=Country.FRANCE.toString()%>">France</option>
              <option value="<%=Country.UNITEDKINKDOM.toString()%>">UnitedKingdom</option>
            </select>
          </td>
        </tr>
        <tr>
          <td><input type="submit" value="Update"></td>
          <td><input type="submit" value="Clear"></td>
        </tr>
      </table>
    </form>
</body>
</html>
