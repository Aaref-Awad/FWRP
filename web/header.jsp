<%-- 
    Document   : header
    Created on : Apr 5, 2024, 9:01:17 AM
    Author     : Aaref
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Header</title>
    <style>
        /* CSS for header bar */
        .header-bar {
            background-color: #333;
            color: white;
            padding: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
    </style>
</head>
<body>
<header class="header-bar" onload="window.location.href='../LogoutServlet'">
    <div>
        User Name: <%= session.getAttribute("userName") != null ? session.getAttribute("userName").toString() : "" %>
        <input type="hidden" name="UserId" value=<%= session.getAttribute("userId")%>>
    </div>
    <div><a href="../LogoutServlet">Logout</a></div>
<header class="header-bar">
    <div>
        User Name: <%= session.getAttribute("userName") != null ? session.getAttribute("userName").toString() : "" %>
        <input type="hidden" name="UserId" value=<%= session.getAttribute("userId")%>>
    </div>
    <div><a href="../LoginPage.jsp">Logout</a></div>
</header>
<main>
    <!-- This is where the content of the page will be included -->
</main>
<footer>
    <!-- Footer content goes here if needed -->
</footer>
</body>
</html>
