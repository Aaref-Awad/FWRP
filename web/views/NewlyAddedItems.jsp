<%@page import="DTO.UserDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="businesslayer.UserBusinessLogic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="businesslayer.RetailerInventoryBusinessLogic"%>
<%@page import="DTO.RetailerInventoryDTO"%>
<%@page import="java.util.List"%> 
<%@page import="java.sql.Timestamp"%>
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

</head>
<body>
    <header>
        <%@ include file="../header.jsp" %>
    </header>
    
    <main>
        <h2>Newly Added Items</h2>
        <!-- Hidden popup -->
        <button id="closePopup">Close</button>
        <div>
            <%
              Integer userId = (Integer) session.getAttribute("userId");
              String username = (String) session.getAttribute("userName");
              String password = (String) session.getAttribute("password");

              out.println("User ID: " + userId); // Debug info
              out.println("Username: " + username); // Debug info
              out.println("Password: " + password); // Debug info

              UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
              UserDTO user = userBusinessLogic.getUserByLogin(username, password);

              out.println("User Last Login: " + user.getLastLogin()); // Debug info

              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              String lastLoginFormatted = dateFormat.format(user.getLastLogin());

              // Fetch newly added items from servlet
              RetailerInventoryBusinessLogic retailerInventoryBusinessLogic = new RetailerInventoryBusinessLogic();
              List<RetailerInventoryDTO> items = retailerInventoryBusinessLogic.getNewlyAddedItems(userId, user.getLastLogin());

              out.println("Number of items: " + items.size()); // Debug info

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
          %>
        </div>
            
        Last Login <input value="<%= lastLoginFormatted %>">
        User : <input value="<%= user.getUsername() %>">
    </main>

    <footer>

    </footer>
    
</body>
</html>
