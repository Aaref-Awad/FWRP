<%-- 
    Document   : RetailerPage
    Created on : Mar. 14, 2024, 9:56:46 p.m.
    Author     : Aaref
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            
        </header>
        <main>
            <p>User ID: <%= session.getAttribute("userId").toString() %></p><br>
            <p>User ID: <%= session.getAttribute("userName") %></p>
        </main>
        <footer>
            
        </footer>
    </body>
</html>
