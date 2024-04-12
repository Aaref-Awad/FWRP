/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DTO.UserDTO;
import businesslayer.UserBusinessLogic;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 * 
 * This servlet handles user login requests. It authenticates the user credentials
 * and redirects the user to the appropriate page based on their user type.
 * If the user credentials are invalid, it displays an error message.
 * 
 * @author Tony, Aaref, Luke
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDTO user = userBusinessLogic.getUserByLogin(username, password);

        if (user != null) {
            try {
                HttpSession session = request.getSession();
                session.setAttribute("userId", user.getUserID());
                session.setAttribute("userName", user.getUsername());
                session.setAttribute("password", user.getPassword());

                if (user.getUserType().equalsIgnoreCase("Consumer")) {
                    response.sendRedirect("views/ConsumerPage.jsp");
                } else if (user.getUserType().equalsIgnoreCase("Charitable Organization")) {
                    response.sendRedirect("views/CharityOrgPage.jsp");
                } else if (user.getUserType().equalsIgnoreCase("Retailer")) {
                    response.sendRedirect("views/RetailerPage.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // User does not exist in the database, display error message
            request.setAttribute("errMessage", "Invalid user credentials");
            request.getRequestDispatcher("/LoginPage.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for handling user login requests";
    }

}