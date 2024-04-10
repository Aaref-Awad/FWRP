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
