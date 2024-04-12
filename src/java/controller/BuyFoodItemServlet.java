/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DTO.RetailerInventoryDTO;
import DTO.UserDTO;
import businesslayer.RetailerInventoryBusinessLogic;
import businesslayer.UserBusinessLogic;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet responsible for buying food items from a retailer's inventory.
 * This servlet handles both GET and POST requests.
 *
 * @author Aaref, Luke, Tony
 */
@WebServlet(name = "BuyFoodItemServlet", urlPatterns = {"/BuyFoodItemServlet"})
public class BuyFoodItemServlet extends HttpServlet {

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
            out.println("<title>Servlet BuyFoodItemServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuyFoodItemServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        try {
            // Create a RetailerInventoryDTO object with updated information
            RetailerInventoryDTO updatedInventory = new RetailerInventoryDTO();
            if (userId != null) {
                updatedInventory.setUserID(userId);
            }

            // Update inventory in the database
            RetailerInventoryBusinessLogic retailerInventoryBusinessLogic = new RetailerInventoryBusinessLogic();
            updatedInventory = retailerInventoryBusinessLogic.getInventoryById(Integer.parseInt(request.getParameter("inventoryId")));
            UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
            UserDTO user = userBusinessLogic.getUserById(userId);
            double OriginalPrice = updatedInventory.getPrice();

            
             if (updatedInventory.getSurplusType().equals("Sale") && retailerInventoryBusinessLogic.isSurPlus(updatedInventory) ){
               updatedInventory.setPrice(OriginalPrice/2);
               session.setAttribute("discountPrice", OriginalPrice/2);
              }else{
                updatedInventory.setPrice(OriginalPrice);
            }
            
            updatedInventory.setFoodAmount(updatedInventory.getFoodAmount() - 1);
            user.setBalance(user.getBalance() - updatedInventory.getPrice());
                if (updatedInventory.getFoodAmount() == 0) {
                    retailerInventoryBusinessLogic.deleteInventory(updatedInventory);
                } else {
                    retailerInventoryBusinessLogic.updateInventoryFoodAmount(updatedInventory);
                    if(user.getBalance() < 0){
                        user.setBalance(0);
                    }
                    userBusinessLogic.updateUser(user);
                }
            

            // Redirect back to the consumer.jsp page
            response.sendRedirect("views/ConsumerPage.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cleanup code if needed
        }
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
