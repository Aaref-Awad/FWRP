<%-- 
    Document   : CharityOrgPage
    Created on : Mar. 14, 2024, 9:57:15 p.m.
    Author     : Aaref, Luke
--%>

<%@page import="businesslayer.UserBusinessLogic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DTO.CharityInventoryDTO"%>
<%@page import="businesslayer.CharityInventoryBusinessLogic"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <header>
        <%@ include file="../header.jsp" %>
    </header>
    
    <main>
        <%
            // Check if UserId is null in the session, if yes, redirect to LoginPage.jsp
            if (session.getAttribute("userId") == null) {
                response.sendRedirect("../LoginPage.jsp");
            } else {
                // Get the user ID from the session
                int userId = (Integer) session.getAttribute("userId");

                // Retrieve inventories related to the current user
                CharityInventoryBusinessLogic charityInventoryBusinessLogic = new CharityInventoryBusinessLogic();
                List<CharityInventoryDTO> inventories = charityInventoryBusinessLogic.getAllInventories();

                // Display the inventories in a table
                out.println("<table border='1'>");
                out.println("<th>Food Name</th><th>Food Amount</th><th>Expiration Date</th><th>Claim</th></tr>");
                for (CharityInventoryDTO inventory : inventories) {
                    out.println("<tr>");
                    out.println("<td>" + inventory.getFoodName() + "</td>");
                    out.println("<td>" + inventory.getQuantity() + "</td>");
                    out.println("<td>" + inventory.getExpirationDate() + "</td>");
                    // Add update button with inventory ID as parameter
                    out.println("<td>");
                    out.println("<form action='../ClaimDonationServlet' method='post'>");
                    out.println("<input type='hidden' name='inventoryId' value='" + inventory.getInventoryID() + "' />");
                    out.println("<input type='submit' value='Claim' />");
                    out.println("</form>");
                    out.println("</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                
                UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
                userBusinessLogic.updateUserLastLogin(userId, new Date());
            }
        %>
    </main>

    <footer>

    </footer>
    </body>
</html>
