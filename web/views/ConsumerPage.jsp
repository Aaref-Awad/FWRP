<%@page import="businesslayer.UserBusinessLogic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="businesslayer.RetailerInventoryBusinessLogic"%>
<%@page import="DTO.RetailerInventoryDTO"%>
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
                RetailerInventoryBusinessLogic retailerInventoryBusinessLogic = new RetailerInventoryBusinessLogic();
                List<RetailerInventoryDTO> inventories = retailerInventoryBusinessLogic.getAllInventories();

                // Display the inventories in a table
                out.println("<table border='1'>");
                out.println("<th>Food Name</th><th>Food Amount</th><th>Expiration Date</th><th>Price</th><th>Purchase</th></tr>");
                for (RetailerInventoryDTO inventory : inventories) {
                    out.println("<tr>");
                    out.println("<td>" + inventory.getFoodName() + "</td>");
                    out.println("<td>" + inventory.getFoodAmount() + "</td>");
                    out.println("<td>" + inventory.getExpirationDate() + "</td>");
                    out.println("<td>" + inventory.getPrice() + "</td>");
                    // Add update button with inventory ID as parameter
                    out.println("<td>");
                    out.println("<form action='../BuyFoodItemServlet' method='post'>");
                    out.println("<input type='hidden' name='inventoryId' value='" + inventory.getInventoryID() + "' />");
                    out.println("<input type='submit' value='Buy' />");
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
