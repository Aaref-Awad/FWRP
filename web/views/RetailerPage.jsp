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
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            color: #333; /* Text color */
        }
        
        header {
            background-color: #007bff; /* Header background color */
            color: #fff; /* Header text color */
            padding: 10px;
            text-align: center;
        }
        
        main {
            margin: 20px;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
        }
        
        th, td {
            padding: 10px;
            border: 1px solid #ddd; /* Border color */
            text-align: left;
        }
        
        th {
            background-color: #007bff; /* Header row background color */
            color: #fff; /* Header row text color */
        }
        
        tr:nth-child(even) {
            background-color: #f2f2f2; /* Alternate row background color */
        }
        
        tr:hover {
            background-color: #ddd; /* Hover row background color */
        }
        
        button {
            padding: 8px 12px;
            background-color: #007bff; /* Button background color */
            color: #fff; /* Button text color */
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        
        button:hover {
            background-color: #0056b3; /* Button hover background color */
        }
    </style>
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
