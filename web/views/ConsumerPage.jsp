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
            max-height: 80%; /* Set maximum height */
            overflow-y: auto; /* Enable vertical scrolling if needed */
        }
    </style>

    <script>
        function showPopup() {
            document.getElementById('popup').style.display = 'block';
        }

        function closePopup() {
            document.getElementById('popup').style.display = 'none';
        }
    </script>

</head>
<body>
    <header>
        <%@ include file="../header.jsp" %>
    </header>
    
    <main>
        <!-- Button to trigger the popup -->
        <button id="showNewItems" onclick="showPopup()">Show Newly Added Items</button>
        
        <!-- Hidden popup -->
        <div id="popup">
            <button id="closePopup" onclick="closePopup()">Close</button>
            <div id="popupContent">
                 <%
                  Integer userId = (Integer) session.getAttribute("userId");
                  String username = (String) session.getAttribute("userName");
                  String password = (String) session.getAttribute("password");

                  UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
                  UserDTO user = userBusinessLogic.getUserByLogin(username, password);
                  
                  // Fetch newly added items from servlet
                  RetailerInventoryBusinessLogic retailerInventoryBusinessLogic = new RetailerInventoryBusinessLogic();
                  List<RetailerInventoryDTO> items = retailerInventoryBusinessLogic.getNewlyAddedItems(userId, user.getLastLogin());

                  if (items.isEmpty()) {
              %>
                  <p>No newly added items.</p>
              <% } else {
                  for (RetailerInventoryDTO item : items) {
              %>
                      <div>
                          <p>Food Name: <%= item.getFoodName() %></p>
                          <p>Food Amount: <%= item.getFoodAmount() %></p>
                          <p>Expiration Date: <%= item.getExpirationDate() %></p>
                          <p>Price: <%= item.getPrice() %></p>
                      </div>
              <%  }
                 }
                 userBusinessLogic.updateUserLastLogin(userId, new Date());
              %>
            </div>
        </div>
        <%
            // Check if UserId is null in the session, if yes, redirect to LoginPage.jsp
            if (session.getAttribute("userId") == null) {
                response.sendRedirect("../LoginPage.jsp");
            } else {
                // Get the user ID from the session

                // Retrieve inventories related to the current user
                List<RetailerInventoryDTO> inventories = retailerInventoryBusinessLogic.getAllInventories();
                
                // Display the inventories in a table
                out.println("<table border='1'>");
                out.println("<th>Food Name</th><th>Food Amount</th><th>Expiration Date</th><th>Price</th><th>Retailer</th><th>Purchase</th></tr>");
                for (RetailerInventoryDTO inventory : inventories) {
                    user = userBusinessLogic.getUserById(inventory.getUserID());
                    out.println("<tr>");
                    out.println("<td>" + inventory.getFoodName() + "</td>");
                    out.println("<td>" + inventory.getFoodAmount() + "</td>");
                    out.println("<td>" + inventory.getExpirationDate() + "</td>");
                    out.println("<td>" + inventory.getPrice() + "</td>");
                    out.println("<td>" + user.getUsername() + "</td>");
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
    <%
        String showPopup = request.getParameter("showPopup");
        if (showPopup != null && showPopup.equals("true")) {
    %>
            <script>
                document.getElementById('popup').style.display = 'block';
            </script>
    <% } %>

    <%-- Scriptlet to close popup --%>
    <%
        String closePopup = request.getParameter("closePopup");
        if (closePopup != null && closePopup.equals("true")) {
    %>
            <script>
                document.getElementById('popup').style.display = 'none';
            </script>
    <% } %>
</body>
</html>
