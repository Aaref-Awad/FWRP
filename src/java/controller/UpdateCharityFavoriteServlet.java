/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DTO.FavoriteInventoryDTO;
import businesslayer.FavoriteInventoryBusinessLogic;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet responsible for updating the favorite status of an inventory item for a charity organization.
 * This servlet handles both GET and POST requests.
 * Upon receiving a POST request with the updated favorite status, it adds or deletes the favorite record
 * in the database accordingly and redirects the user back to the Charity Organization page.
 * 
 * @author Aaref, Luke, Tony
 */
public class UpdateCharityFavoriteServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateCharityFavoriteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCharityFavoriteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
                // Retrieve inventoryId and userId from request parameters
        int inventoryId = Integer.parseInt(request.getParameter("inventoryId"));
        int userId = (Integer) request.getSession().getAttribute("userId");

        // Initialize FavoriteInventoryBusinessLogic object
        FavoriteInventoryBusinessLogic favoriteLogic = new FavoriteInventoryBusinessLogic();
        int favoriteId = favoriteLogic.getFavoriteIdByInventoryIdAndUserId(inventoryId, userId);

        // Check if the favorite already exists for the given inventoryId and userId
        boolean isFavorite = favoriteLogic.isFavorite(inventoryId, userId);

        // If the checkbox is checked, add the favorite; otherwise, delete the favorite
        if (request.getParameter("favorite") != null) {
            if (!isFavorite) {
                // Create FavoriteInventoryDTO object and add the favorite
                FavoriteInventoryDTO favorite = new FavoriteInventoryDTO();
                favorite.setUserID(userId);
                favorite.setInventoryID(inventoryId);
                favorite.setFoodName(request.getParameter("FoodName")); // Set the food name if needed
                favorite.setRetailerName(request.getParameter("RetailerName")); // Set the retailer name if needed
                favoriteLogic.addFavorite(favorite);
            }
        } else {
            if (isFavorite) {
                // Delete the favorite
                favoriteLogic.deleteFavorite(favoriteId);
            }
        }

        // Redirect back to the same page
        response.sendRedirect(request.getContextPath() + "/views/CharityOrgPage.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
