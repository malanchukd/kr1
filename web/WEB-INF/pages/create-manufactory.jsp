<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Manufactory</title>
</head>
<body>
    <%@include file="header.html"%>
    <h2>Create new Manufactory</h2>
    <form action="create-manufactory" method="post">
        <% String atr = (String) request.getAttribute("atr"); %>
        <% if(atr!=null) {%>
        <p><%=atr%></p>
        <% }%>

        <table>
            <tr>
                <td><label for="name">Name :</label></td>
                <td><input type="text" id="name" name="name" value="Manufactory #3"></td>
            </tr>
            <tr>
                <td><label for="country">Country</label></td>
                <td>
                    <select name="country" id="country">
                        <option value="Ukraine" selected>Ukraine</option>
                        <option value="USA">USA</option>
                        <option value="Germany">Germany</option>
                        <option value="Poland">Poland</option>
                        <option value="France">France</option>
                        <option value="UniteKingdom">UniteKingdom</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Create"></td>
                <td><input type="reset" value="Clear"></td>
            </tr>
        </table>

    </form>
</body>
</html>
