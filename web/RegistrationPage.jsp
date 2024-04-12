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
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f8f9fa;
                margin: 0;
                padding: 0;
                color: #333; /* Text color */
            }

            header, footer {
                text-align: center;
                padding: 10px 0;
                background-color: #007bff; /* Header and footer background color */
                color: #fff; /* Header and footer text color */
            }

            main {
                max-width: 400px;
                margin: 50px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            }

            h1 {
                font-size: 24px;
                margin-bottom: 20px;
                color: #007bff; /* Heading color */
            }

            input[type="text"],
            input[type="email"],
            input[type="password"],
            select {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border-radius: 5px;
                border: 1px solid #ccc;
            }

            button[type="submit"] {
                width: 100%;
                padding: 10px;
                background-color: #007bff;
                border: none;
                color: #fff;
                font-size: 18px;
                cursor: pointer;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            button[type="submit"]:hover {
                background-color: #0056b3;
            }

            a {
                text-decoration: none;
                color: #007bff; /* Link color */
            }

            a:hover {
                text-decoration: underline;
            }

        </style>
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
