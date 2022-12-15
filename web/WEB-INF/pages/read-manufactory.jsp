<%@ page import="model.Manufactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read existing Manufactory</title>
</head>
<body>
    <table>
      <%@include file="header.html"%>
      <h1>Current Manufactory</h1>
      <%
        Manufactory manufactory = (Manufactory) request.getAttribute("manufactory");
      %>

      <tr>
        <td>Id:</td>
        <td><strong><%=manufactory.getId()%></strong></td>
      </tr>
      <tr>
        <td>Name:</td>
        <td><strong><%=manufactory.getName()%></strong></td>
      </tr>
      <tr>
        <td>Country:</td>
        <td><strong><%=manufactory.getCountry()%></strong></td>
      </tr>
    </table>
</body>
</html>
