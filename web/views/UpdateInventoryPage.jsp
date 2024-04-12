<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="businesslayer.RetailerInventoryBusinessLogic"%>
<%@page import="DTO.RetailerInventoryDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    
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
        text-align: center;
    }

    form {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }

    h1 {
        margin-bottom: 20px;
        color: #007bff; /* Header color */
    }

    input[type="text"],
    input[type="number"],
    input[type="date"],
    select {
        width: 100%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    select {
        appearance: none;
        
        background-position: right 10px top 50%;
        background-size: 20px auto;
        padding-right: 40px;
    }

    button {
        padding: 10px 20px;
        background-color: #007bff; 
        color: #fff; 
        border: none;
        cursor: pointer;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }
    
    button:hover {
        background-color: #0056b3; /* Button hover background color */
    }
    
    </style>
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update Inventory</title>
</head>
<body>
    <header>
        <%@ include file="../header.jsp" %>
        <input type="hidden" name="UserId" value=<%= session.getAttribute("userId")%>>

    </header>
    <main>
        
        <% 
            if (session.getAttribute("userId") == null) {
                response.sendRedirect("../LoginPage.jsp");
            }
        %>
        
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
            <div>
                        <select name="surplusType" id="surplusType" required>
                            <option value="" disabled selected>Select The Surplus Type</option>
                            <option value="Charity">Charity</option>
                            <option value="Sale">Sale</option>
                        </select>
            </div>
            <label for="price">Price:</label>
            <input type="number" name="price" value="<%= inventory.getPrice() %>"><br>
            <button type="submit">Apply Changes</button>
        </form>
    </main>
    <footer>
                
    </footer>
</body>
</html>
