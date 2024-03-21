<%-- 
    Document   : RegistrationPage
    Created on : Mar. 14, 2024, 8:03:52 p.m.
    Author     : Aaref, Tony
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
            
        </header>
        <main>
            <div>
                <form action="RegistrationServlet" method="post">
                    
                    <h1>Register</h1>
                    
                    <div>
                        <input type="text" name="username" id="username" placeholder="Username" required>
                    </div>
                    
                    <div>
                        <input type="email" name="email" id="email" placeholder="Email" required>
                    </div>
                    
                    <div>
                        <input type="password" name="password" id="password" placeholder="Password" required>
                    </div>
                    
                    <div>
                        <input type="password" name="password" id="password2" placeholder="Confirm Password" required>
                    </div>
                    
                    <div>
                        <select name="usertype" id="usertype" required>
                            <option value="" disabled selected>Select your User Type</option>
                            <option value="Consumer">Consumer</option>
                            <option value="Retailer">Retailer</option>
                            <option value="Charitable Organization">Charitable Organization</option>
                        </select>
                    </div>
                    
                    <button type="submit" name="submit" id="Register">Register</button> <br>
                    <a href="LoginPage.jsp" target="target">Login</a>
                </form>
            </div>
        </main>
        <footer>
            
        </footer>
    </body>
</html>
