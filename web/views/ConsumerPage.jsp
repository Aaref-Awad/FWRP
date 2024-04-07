<%@page import="DTO.UserDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
    
    <style>
        #popup {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #fff;
            border: 1px solid #000;
            padding: 20px;
            z-index: 9999;
        }
    </style>

    <!-- Scriptlet to show/hide popup -->
    <%
        String showPopup = request.getParameter("showPopup");
        if (showPopup != null && showPopup.equals("true")) {
    %>
            <script>
                document.getElementById('popup').style.display = 'block';
            </script>
    <% } %>

    <!-- Scriptlet to close popup -->
    <%
        String closePopup = request.getParameter("closePopup");
        if (closePopup != null && closePopup.equals("true")) {
    %>
            <script>
                document.getElementById('popup').style.display = 'none';
            </script>
    <% } %>
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
            }
        %>
    </main>

    <footer>

    </footer>
    
</body>
</html>
