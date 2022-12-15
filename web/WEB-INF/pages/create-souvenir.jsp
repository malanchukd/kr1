<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Souvenir</title>
</head>
<body>
<%@include file="header.html"%>
<h2>Create new Souvenir</h2>
<form action="create-souvenir" method="post">
    <% String atr = (String) request.getAttribute("atr"); %>
    <% if(atr!=null) {%>
    <p><%=atr%></p>
    <% }%>

    <table>
        <tr>
            <td><label for="name">Name :</label></td>
            <td><input type="text" id="name" name="name" value="Souvenir #3"></td>
        </tr>
        <tr>
            <td><label for="nameOfManufacture">ManufactoryName: </label></td>
            <td><input type="text" id="nameOfManufacture" name="nameOfManufacture" value=""></td>
        </tr>
        <tr>
            <td><label for="releaseDate">ReleaseDate</label></td>
            <td><input type="date" id="releaseDate" name="releaseDate" value="yyyy.mm.dd"></td>
        </tr>
        <tr>
            <td><label for="price">Price</label></td>
            <td><input type="number" id="price" name="price" value="100"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Create"></td>
            <td><input type="reset" value="Clear"></td>
        </tr>
    </table>

</form>
</body>
</html>
