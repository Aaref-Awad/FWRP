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
            <p>User ID: <%= session.getAttribute("userId")%></p><br>
            <p>User ID: <%= session.getAttribute("userName") %></p>
            <!-- Add a button that redirects to AddRetailerFoodItem.jsp -->
            <button onclick="window.location.href='AddRetailerFoodItem.jsp'">Go to Add Retailer Food Item Page</button>
        </main>
        <footer>
            
        </footer>
    </body>
</html>

