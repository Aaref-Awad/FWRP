<%-- 
    Document   : LoginPage
    Created on : Mar. 14, 2024, 8:02:26 p.m.
    Author     : Aaref, Tony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <header>
            
        </header>
        <CENTER>
            <main>
                <div>
                    <form action="LoginServlet" method="post">

                        <h1>Login</h1>

                        <div>
                            <input type="text" name="username" id="username" placeholder="Username" required>
                        </div>

                        <div>
                            <input type="password" name="password" id="password" placeholder="Password" required>
                        </div>
                        
                        <p class="text--center">
                            <span style="color: #4ceaae; text-transform: uppercase; font-weight: 500">
                                <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>
                            </span>
                        </p>

                        <button type="submit" name="submit" id="login">Login</button> <br>
                        <a href="RegistrationPage.jsp" target="target">Register</a>
                    </form>
                </div>
            </main>
        </CENTER>
        <footer>
            
        </footer>
    </body>
</html>
