<%-- 
    Document   : RetailerPage
    Created on : Mar. 14, 2024, 9:56:46 p.m.
    Author     : Aaref
--%>

<%@page import="java.util.List"%>
<%@page import="DTO.InventoryDTO"%>
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
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<InventoryDTO> items = (List<InventoryDTO>) request.getAttribute("fooditems");
                    for (InventoryDTO Inventory : items) {%>
                    <tr>
                        <td>
                            <% if(Inventory.getFoodName() != null && !Inventory.getFoodName().isEmpty()) { %>
                                <%= Inventory.getFoodName() %>
                            <% } %>
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <% }%>
                </tbody>

        </table>
        </main>
        <footer>
            
        </footer>
    </body>
</html>
