<%-- 
    Document   : CharityOrgPage
    Created on : Mar. 14, 2024, 9:57:15 p.m.
    Author     : Aaref, Luke
--%>

<%@page import="DTO.InventoryDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Charitable Organization</title>
    </head>
    <body>
    <header>
        
    </header>
    <main>
        <h1>Available Donations</h1>
    <form action="claimDonation" method="post">
        <%
            // Assuming you have a list of InventoryDTO objects with 'donation' designation
            List<InventoryDTO> donations = (List<InventoryDTO>) request.getAttribute("donations");
            if (donations != null) {
                for (InventoryDTO donation : donations) {
        %>
        <input type="checkbox" name="foodId" value="<%= donation.getFoodID() %>">
        <%= donation.getFoodName() %> - Amount: <%= donation.getFoodAmount() %><br>
        <%
                }
            } else {
                out.println("No donations available.");
            }
        %>
        <input type="submit" value="Claim Selected Donations">
    </form>
    </main>
    <footer>
        
    </footer>
    </body>
</html>
