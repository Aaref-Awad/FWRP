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
<%@ page import="static java.lang.Double.parseDouble" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>

     <style>
        #popup, #popup2 {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #fff;
            border: 1px solid #000;
            padding: 20px;
            z-index: 9999;
            max-height: 80%;
            overflow-y: auto;
        }

        header {
            background-color: #007bff;
            color: #fff;
            padding: 10px;
            text-align: center;
            overflow: auto; /* Handle overflow */
        }

        header div {
            float: right;
            margin-right: 20px;
            overflow: auto; /* Handle overflow */
        }

        header span {
            margin-right: 10px;
        }

        header button {
            margin-right: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        header button:hover {
            background-color: #0056b3;
        }

        main {
            margin: 20px;
            text-align: center;
        }

        button#showNewItems {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 16px;
            margin-bottom: 20px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        button#showNewItems:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 8px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f2f2f2;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        input[type="checkbox"] {
            cursor: pointer;
        }

        input[type="checkbox"]:checked {
            background-color: #007bff;
            color: #fff;
        }

        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
    </style>

    <script>
        
         <% 
            Integer userId = (Integer) session.getAttribute("userId");
            String username = (String) session.getAttribute("userName");
            String password = (String) session.getAttribute("password");
            UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
            UserDTO currentUser = userBusinessLogic.getUserById((Integer) session.getAttribute("userId"));
        %>
        
        function showPopup() {
            <%if(currentUser.isSubed()){%>
                document.getElementById('popup').style.display = 'block';
            <%}%>
        }

        function closePopup() {
            document.getElementById('popup').style.display = 'none';
            document.getElementById('popup2').style.display = 'none';

        }
        
        function addBalance(){
            document.getElementById('popup2').style.display = 'block';
        }

    </script>

</head>
<body>
<header>
    <%@ include file="../header.jsp" %>
    <div style="float: right; margin-right: 20px;">
        <span style="margin-right: 10px;">Balance: <%= currentUser.getBalance() %> </span>
        <button style="margin-right: 10px;" onclick="addBalance()">Add Balance</button>
    </div>
</header>

<main>
    <!-- Button to trigger the popup -->
    <button id="showNewItems" onclick="showPopup()">Show Newly Added Items</button>

    <!-- Hidden popup -->
    <div id="popup">
        <button id="closePopup" onclick="closePopup()">Close</button>
        <div id="popupContent">
            <%
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
                                <p>Food Name: <%= item.getFoodName() %></p>
                                <p>Food Amount: <%= item.getFoodAmount() %></p>
                                <p>Expiration Date: <%= item.getExpirationDate() %></p>
                                <p>Price: <%= item.getPrice() %></p>
                            </div>
                            <%
                        }
                    }
                    userBusinessLogic.updateUserLastLogin(userId, new Date());
            %>
        </div>
    </div>
        <!<!-- Popup for adding Consumer Balance -->
        <div id="popup2">
        <button id="closePopup" onclick="closePopup()">Close</button>
        <div id="popupContent">
            <form action='../UpdateBalanceServlet' method='post'>
                    <input type='hidden' name='userId' value='<%= currentUser.getUserID() %>' />
                    <input type='number' name='balance'/>
                    <input type='submit' name='addBalance' value=' Add Balance' />

            </form>
        </div>
    </div>
        

    <%
            // Retrieve inventories related to the current user
            List<RetailerInventoryDTO> inventories = retailerInventoryBusinessLogic.getAllInventories();
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
                    <%
                    // Retrieve the discount price from the session attribute
                    Double discountPrice = (Double) session.getAttribute("discountPrice");
                    // Check if the discount price is not null and if the user can buy the item with the discount price
                    if (discountPrice != null && retailerInventoryBusinessLogic.canUserBuyItem(currentUser.getUserID(), discountPrice)) {
                    %>
                    <input type='hidden' name='inventoryId' value='<%= inventory.getInventoryID() %>' />
                    <input type='submit' value='Buy'/>
                    <%
                    } else if ( retailerInventoryBusinessLogic.canUserBuyItem(currentUser.getUserID(), inventory.getPrice()) ){ %>
                    <input type='hidden' name='inventoryId' value='<%= inventory.getInventoryID() %>' />
                    <input type='submit' value='Buy'/>
                    <%}else{ %>
                        <input type='text' value='Cannot Afford' readonly/>
                    <%}%>
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
            if (currentUser.isSubed()) { %>
                <input type='hidden' name='userId' value='<%= currentUser.getUserID() %>' />
                <input type='hidden' name='isSubscribed' value='false' />
                <input type='submit' value='Unsubscribe' />
                <%
            } else { %>
                <input type='hidden' name='userId' value='<%= currentUser.getUserID() %>' />
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

</body>
</html>
