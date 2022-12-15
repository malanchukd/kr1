<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<tr>
    <td><label for="search">Type name of Manufactory: </label></td>
    <td><input type="text" id="search" name="search" value=""></td>
</tr>
<tr>
    <td><input type="submit" value="Search"></td>
</tr>
<table>
    <c:forEach items="${searchList}" var="current">
        <tr>
            <td>  ${current.id}   </td>
            <td>  ${current.name}   </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
