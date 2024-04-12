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
        <style>
            /* Text color */
            body {
                font-family: Arial, sans-serif;
                background-color: #f8f9fa;
                margin: 0;
                padding: 0;
                color: #333; 
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
            input[type="password"] {
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

            .text--center {
                text-align: center;
            }

        </style>
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
