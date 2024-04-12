<%-- 
    Document   : AddRetailerFoodItem
    Created on : Mar. 22, 2024, 9:30:53 a.m.
    Author     : Aaref
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                -webkit-appearance: none;
                -moz-appearance: none;
                background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24'%3E%3Cpath d='M7 10l5 5 5-5H7z'/%3E%3C/svg%3E");
                background-repeat: no-repeat;
                background-position: right 10px top 50%;
                background-size: 20px auto;
                padding-right: 40px;
            }
            
            button {
                padding: 10px 20px;
                background-color: #007bff; /* Button background color */
                color: #fff; /* Button text color */
                border: none;
                cursor: pointer;
                border-radius: 5px;
                transition: background-color 0.3s ease;
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
            
            <% 
                if (session.getAttribute("userId") == null) {
                response.sendRedirect("../LoginPage.jsp");
                }
            %>
            
            <div>
                <form action="../AddFoodItemServlet" method="post">
                    <h1>Add Food Item</h1>
                    <div>
                        <input type="text" name="FoodName" id="foodName" placeholder="Food Name" required>
                    </div>
                    <div>
                        <input type="number" name="FoodAmount" id="foodAmount" placeholder="Food Amount" required>
                    </div>
                    <div>
                        <input type="Date" name="ExpirationDate" id="expirationDate" placeholder="Expiration Date" required>
                    </div>
                    <div>
                        <select name="SurplusType" id="surplusType" required>
                            <option value="" disabled selected>Select The Surplus Type</option>
                            <option value="Charity">Charity</option>
                            <option value="Sale">Sale</option>
                        </select>
                    </div>
                    <button type="submit" name="Add" id="AddItem">Add Item</button> <br>
                </form>
            </div>
        </main>

        <footer>
            
        </footer>
    </body>
</html>
