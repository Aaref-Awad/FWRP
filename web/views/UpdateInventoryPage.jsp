<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="businesslayer.RetailerInventoryBusinessLogic"%>
<%@page import="DTO.RetailerInventoryDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update Inventory</title>
</head>
<body>
    <header>
        <%@ include file="../header.jsp" %>
        <input type="hidden" name="UserId" value=<%= session.getAttribute("userId")%>>

    </header>
    <main>
         <h1>Update Inventory</h1>
        <% 
            // Retrieve inventory ID from the URL parameter
            int inventoryId = Integer.parseInt(request.getParameter("inventoryId"));

            // Retrieve the inventory details based on the ID
            RetailerInventoryBusinessLogic retailerInventoryBusinessLogic = new RetailerInventoryBusinessLogic();
            RetailerInventoryDTO inventory = retailerInventoryBusinessLogic.getInventoryById(inventoryId);

            // Display editable fields for inventory information
        %>
        <form action="../UpdateInventorServlet" method="post">
            <input type="hidden" name="UserId" value=<%= session.getAttribute("userId")%>>
            <input type="hidden" name="inventoryId" value="<%= inventory.getInventoryID() %>">
            <label for="foodName">Food Name:</label>
            <input type="text" name="foodName" value="<%= inventory.getFoodName() %>"><br>
            <label for="foodAmount">Food Amount:</label>
            <input type="number" name="foodAmount" value="<%= inventory.getFoodAmount() %>"><br>
            <label for="expirationDate">Expiration Date:</label>
            <input type="date" name="expirationDate" value="<%= inventory.getExpirationDate() %>"><br>
            <label for="surplusType">Surplus Type:</label>
            <input type="text" name="surplusType" value="<%= inventory.getSurplusType() %>"><br>
            <label for="price">Price:</label>
            <input type="number" name="price" value="<%= inventory.getPrice() %>"><br>
            <button type="submit">Apply Changes</button>
        </form>
    </main>
    <footer>
                
    </footer>
</body>
</html>
