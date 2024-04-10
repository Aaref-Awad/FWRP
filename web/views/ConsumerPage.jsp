<%@page import="businesslayer.CharityInventoryBusinessLogic"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="businesslayer.FavoriteInventoryBusinessLogic" %>
<%@ page import="DTO.FavoriteInventoryDTO" %>
<%@ page import="DTO.UserDTO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="businesslayer.UserBusinessLogic" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="businesslayer.RetailerInventoryBusinessLogic" %>
<%@ page import="DTO.RetailerInventoryDTO" %>
<%@ page import="java.util.List" %>
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
                // Check if UserId is null in the session, if yes, redirect to LoginPage.jsp
                    Integer userId = (Integer) session.getAttribute("userId");
                    String username = (String) session.getAttribute("userName");
                    String password = (String) session.getAttribute("password");

                    UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
                    UserDTO user = userBusinessLogic.getUserByLogin(username, password);

                    // Fetch newly added items from servlet
                    RetailerInventoryBusinessLogic retailerInventoryBusinessLogic = new RetailerInventoryBusinessLogic();
                    List<RetailerInventoryDTO> items = new ArrayList<>();

                    if (userId != null) {
                        items = retailerInventoryBusinessLogic.getNewlyAddedItems(userId, user.getLastLogin());
                    }

                    if (items.isEmpty()) { %>
                        <p>No newly added items.</p>
                        <%
                    } else {
                        for (RetailerInventoryDTO item : items) { %>
                            <div>
                                <% 
                                    UserDTO user2 = userBusinessLogic.getUserById(item.getUserID());
                                    if (retailerInventoryBusinessLogic.isFoodNameAndRetailerExists(item.getFoodName(), user2.getUsername() )){
                                %>
                                <p>Food Name: <%= item.getFoodName() %></p>
                                <p>Food Amount: <%= item.getFoodAmount() %></p>
                                <p>Expiration Date: <%= item.getExpirationDate() %></p>
                                <p>Price: <%= item.getPrice() %></p>
                                <% } %>
                            </div>
                            <%
                        }
                    }
                    userBusinessLogic.updateUserLastLogin(userId, new Date());
            %>
        </div>
    </div>

    <%
            // Retrieve inventories related to the current user
            List<RetailerInventoryDTO> inventories = retailerInventoryBusinessLogic.getAllInventories();
            UserDTO currentUser = userBusinessLogic.getUserById((Integer) session.getAttribute("userId"));
    %>
    <!-- Display the inventories in a table -->
    <table border='1'>
        <th>Food Name</th>
        <th>Food Amount</th>
        <th>Expiration Date</th>
        <th>Price</th>
        <th>Retailer</th>
        <th>Purchase</th>
        <th>Favorite</th>
        <%
            for (RetailerInventoryDTO inventory : inventories) {
                user = userBusinessLogic.getUserById(inventory.getUserID());

                FavoriteInventoryBusinessLogic favoriteInventoryBusinessLogic = new FavoriteInventoryBusinessLogic();
                
                if (!(inventory.getSurplusType().equals("Charity") && retailerInventoryBusinessLogic.isSurPlus(inventory)) ){
        %>
        <tr>
            <td><%= inventory.getFoodName() %></td>
            <td><%= inventory.getFoodAmount() %></td>
            <td><%= inventory.getExpirationDate() %></td>
            <% if (inventory.getSurplusType().equals("Sale") && retailerInventoryBusinessLogic.isSurPlus(inventory) ){ %>
                <td><%= inventory.getPrice()/2%></td>
            <%}else{%>
            <td><%= inventory.getPrice()%></td>
            <%}%>
            <td><%= user.getUsername() %></td>
            <!-- Add update button with inventory ID as parameter -->
            <td>
                <form action='../BuyFoodItemServlet' method='post'>
                    <input type='hidden' name='inventoryId' value='<%= inventory.getInventoryID() %>' />
                    <input type='submit' value='Buy' />
                </form>
            </td>
            <!-- Checkbox for favorite -->
            <td>
                <form action='../UpdateFavoriteServlet' method='post'>
                    <input type='hidden' name='inventoryId' value='<%= inventory.getInventoryID() %>' />
                    <input type='hidden' name='FoodName' value='<%= inventory.getFoodName() %>' />
                    <input type='hidden' name='RetailerName' value='<%= user.getUsername() %>' />
                    <input type='checkbox' name='favorite' onchange="this.form.submit()"
                           id='favoriteCheckbox<%= inventory.getInventoryID() %>'
                        <%
                        if (favoriteInventoryBusinessLogic.isFavorite(inventory.getInventoryID(), currentUser.getUserID())) { %>
                            checked
                            <%
                        } %>
                    />
                </form>
            </td>
        </tr>
        <%
            }
         }
        %>
    </table>

    <!-- Subscription button -->
    <form action='../UpdateSubscriptionServlet' method='post'>
        <%
            if (session.getAttribute("userId") == null) {
            response.sendRedirect("../LoginPage.jsp");
        } else {
            if (user.isSubed()) { %>
                <input type='hidden' name='userId' value='<%= userId %>' />
                <input type='hidden' name='isSubscribed' value='false' />
                <input type='submit' value='Unsubscribe' />
                <%
            } else { %>
                <input type='hidden' name='userId' value='<%= userId %>' />
                <input type='hidden' name='isSubscribed' value='true' />
                <input type='submit' value='Subscribe' />
                <%
            }
        }
        %>
    </form>
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
        <%
    } %>

<%
    String closePopup = request.getParameter("closePopup");
    if (closePopup != null && closePopup.equals("true")) {
        %>
        <script>
            document.getElementById('popup').style.di splay = 'none';
        </script>
        <%
    } %>
</body>
</html>
