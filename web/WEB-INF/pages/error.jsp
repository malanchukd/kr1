<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <% int id =  Integer.parseInt(request.getParameter("id"));
       String url = (String) request.getAttribute("url");
    %>
    <%=request.getAttribute("message") != null ? request.getAttribute("message") : ""%>
    <h1>Error</h1>
    <h2>With this ID '<%=id%>' not fount anything</h2>

</body>
</html>
