<%@page import="businesslayer.CharityInventoryBusinessLogic"%>
<%@page import="businesslayer.UserBusinessLogic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="businesslayer.RetailerInventoryBusinessLogic"%>
<%@page import="DTO.RetailerInventoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%> <!-- Add import for Date -->

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Inventory Page</title>
</head>
<body>
    <header>
        <%@ include file="../header.jsp" %>
    </header>

<main>
    <button onclick="window.location.href='AddRetailerFoodItem.jsp'">Go to Add Retailer Food Item Page</button>
    <%
        // Check if UserId is null in the session, if yes, redirect to LoginPage.jsp
        if (session.getAttribute("userId") == null) {
            response.sendRedirect("../LoginPage.jsp");
        } else {
            // Get the user ID from the session
            int userId = (Integer) session.getAttribute("userId");

            // Retrieve inventories related to the current user
            RetailerInventoryBusinessLogic retailerInventoryBusinessLogic = new RetailerInventoryBusinessLogic();
            List<RetailerInventoryDTO> inventories = retailerInventoryBusinessLogic.getInventoriesById(userId);
            CharityInventoryBusinessLogic charityInventoryBusinessLogic = new CharityInventoryBusinessLogic();

            // Display the inventories in a table
            out.println("<table border='1'>");
            out.println("<tr><th>Inventory ID</th><th>Food Name</th><th>Food Amount</th><th>Expiration Date</th><th>Surplus Type</th><th>Price</th><th>Update</th></tr>");
            for (RetailerInventoryDTO inventory : inventories) {                
                    out.println("<tr>");
                    out.println("<td>" + inventory.getInventoryID() + "</td>");
                    out.println("<td>" + inventory.getFoodName() + "</td>");
                    out.println("<td>" + inventory.getFoodAmount() + "</td>");
                    out.println("<td>" + inventory.getExpirationDate() + "</td>");
                    out.println("<td>" + inventory.getSurplusType() + "</td>");
                    out.println("<td>" + inventory.getPrice() + "</td>");
                    // Add update button with inventory ID as parameter
                    out.println("<td><button onclick=\"window.location.href='UpdateInventoryPage.jsp?inventoryId=" + inventory.getInventoryID() + "'\">Update</button></td>");
            }
            out.println("</table>");

            // Update last login after displaying the table
            UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
            userBusinessLogic.updateUserLastLogin(userId, new Date());
        }
    %>
</main>

<footer>

</footer>
</body>
</html>
