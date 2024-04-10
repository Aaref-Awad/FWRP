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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddFoodItemServlet
 *
 * This servlet handles the addition of food items by retailers.
 * It receives POST requests from a form in the retailer's page and adds the food item to the inventory.
 * 
 * @author Aaref
 */
public class AddFoodItemServlet extends HttpServlet {

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
            out.println("<title>Servlet AddFoodItemServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddFoodItemServlet at " + request.getContextPath() + "</h1>");
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
        RetailerInventoryBusinessLogic retailerInventoryBusinessLogic = new RetailerInventoryBusinessLogic();
        RetailerInventoryDTO inventory = new RetailerInventoryDTO();
        
        // Assuming that the UserID is stored in the session
        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("userId");
        
        try{

            inventory.setUserID(userId);
            inventory.setFoodAmount(Integer.parseInt(request.getParameter("FoodAmount")));
            inventory.setExpirationDate(Date.valueOf(request.getParameter("ExpirationDate")));  
            inventory.setSurplusType(request.getParameter("SurplusType"));
            inventory.setFoodName(request.getParameter("FoodName"));
            inventory.setPrice(0.0);

            
            retailerInventoryBusinessLogic.addInventory(inventory);
            response.sendRedirect("views/RetailerPage.jsp");
        }catch(Exception e){
            e.printStackTrace();
        }finally{

        }
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for adding food items by retailers";
    }// </editor-fold>

}
