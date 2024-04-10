package controller;

import DTO.UserDTO;
import businesslayer.UserBusinessLogic;
import businesslayer.ValidationException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationServlet
 *
 * This servlet handles user registration requests. It adds a new user to the database
 * and redirects the user to the appropriate page based on their user type.
 * If an error occurs during the registration process, it prints the stack trace.
 * 
 * @author Aaref
 */
public class RegistrationServlet extends HttpServlet {

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
            out.println("<title>Servlet RegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrationServlet at " + request.getContextPath() + "</h1>");
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
        UserDTO user = new UserDTO();
        HttpSession session = request.getSession();

        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setUserType(request.getParameter("usertype"));
        
        boolean isValid;
        
       
        try {
            // Validate user
            userBusinessLogic.validateUser(user);
            isValid = true;
            
            
        } catch (ValidationException ex) {
            // If validation fails, send a popup message back to the RegistrationPage.jsp
            isValid = false;
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("RegistrationPage.jsp");
        }   
        
        if(isValid){
        try{
            userBusinessLogic.addUser(user);

            // Set session attributes
            session.setAttribute("userId", userBusinessLogic.getUserByLogin(user.getUsername(), user.getPassword()).getUserID());
            session.setAttribute("userName", user.getUsername());
            session.setAttribute("password", user.getPassword());

            // Redirect to the appropriate page based on user type
            if (user.getUserType().equalsIgnoreCase("Consumer")) {
                response.sendRedirect("views/ConsumerPage.jsp");
            } else if (user.getUserType().equalsIgnoreCase("Charitable Organization")) {
                response.sendRedirect("views/CharityOrgPage.jsp");
            } else {
                response.sendRedirect("views/RetailerPage.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }else{
            request.setAttribute("errMessage", "Make sure Username is not more than 25 characters and password is not less than 8 characters");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/RegistrationPage.jsp");
            dispatcher.forward(request, response);
        }
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for handling user registration requests";
    }// </editor-fold>

}
