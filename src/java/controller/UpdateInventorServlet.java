/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DTO.RetailerInventoryDTO;
import businesslayer.RetailerInventoryBusinessLogic;
import businesslayer.UserBusinessLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateInventorServlet
 * 
 * This servlet handles the update of inventory items by retailers.
 * It retrieves the inventory details based on the inventory ID, 
 * then updates the inventory in the database with the values submitted by the retailer.
 * The servlet redirects the user back to the RetailerPage after updating the inventory.
 * 
 * @author Aaref
 */
public class UpdateInventorServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateInventorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateInventorServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        int inventoryId = Integer.parseInt(request.getParameter("inventoryId"));

        Date currentDate = new Date(System.currentTimeMillis());
        // Create a SimpleDateFormat object with the desired format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            // Create a RetailerInventoryDTO object with updated information
            RetailerInventoryDTO updatedInventory = new RetailerInventoryDTO();
            if (userId != null) {
                updatedInventory.setUserID(userId);
            }
            // Retrieve the inventory details based on the ID
            RetailerInventoryBusinessLogic retailerInventoryBusinessLogic = new RetailerInventoryBusinessLogic();
            RetailerInventoryDTO inventory = retailerInventoryBusinessLogic.getInventoryById(inventoryId);

            // Retrieve the values submitted by the user
            String foodName = request.getParameter("foodName");
            int foodAmount = Integer.parseInt(request.getParameter("foodAmount"));
            Date expirationDate = Date.valueOf(request.getParameter("expirationDate"));
            String surplusType = request.getParameter("surplusType");
            double price = Double.parseDouble(request.getParameter("price"));

            // Check if any changes have been made to the inventory information
            boolean changesMade = !inventory.getFoodName().equals(foodName) ||
                                 inventory.getFoodAmount() != foodAmount ||
                                 !inventory.getExpirationDate().equals(expirationDate) ||
                                 !inventory.getSurplusType().equals(surplusType) ||
                                 inventory.getPrice() != price;

            // Update inventory in the database only if changes have been made
            if (changesMade) {
                // Set the new values to the updated inventory object
                updatedInventory.setInventoryID(Integer.parseInt(request.getParameter("inventoryId")));
                updatedInventory.setFoodName(request.getParameter("foodName"));
                updatedInventory.setFoodAmount(Integer.parseInt(request.getParameter("foodAmount")));
                updatedInventory.setExpirationDate(Date.valueOf(request.getParameter("expirationDate")));
                updatedInventory.setSurplusType(request.getParameter("surplusType"));
                updatedInventory.setPrice(Double.parseDouble(request.getParameter("price")));
                updatedInventory.setItemAdded(dateFormat.parse(
                        dateFormat.format(currentDate)
                    ));
                // Update inventory in the database
                retailerInventoryBusinessLogic.updateInventory(updatedInventory);
            }
            response.sendRedirect("views/RetailerPage.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Handle any cleanup or error handling here
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for updating inventory items by retailers";
    }// </editor-fold>

}
