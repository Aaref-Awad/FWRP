/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DTO.FoodDTO;
import DTO.RetailerInventoryDTO;
import businesslayer.FoodBusinessLogic;
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
        RetailerInventoryBusinessLogic retailerInventoryBusinessLogic = new RetailerInventoryBusinessLogic();
        FoodBusinessLogic foodBusinessLogic = new FoodBusinessLogic();
        RetailerInventoryDTO inventory = new RetailerInventoryDTO();
        FoodDTO foodItem = new FoodDTO();

        // Assuming that the UserID is stored in the session
        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("userId");

        foodItem.setFoodName(request.getParameter("FoodName"));
        
        try{
            foodBusinessLogic.addFood(foodItem);
            foodItem.setFoodID(foodBusinessLogic.getFoodByName(foodItem.getFoodName()).getFoodID());
        }catch(Exception e){
            e.printStackTrace();
        } finally{

        }

        inventory.setUserID(userId);
        inventory.setFoodID(foodItem.getFoodID());
        inventory.setFoodAmount(Integer.parseInt(request.getParameter("FoodAmount")));
        inventory.setExpirationDate(Date.valueOf(request.getParameter("ExpirationDate")));  // java.sql.Date is used here
        inventory.setSurplusType(request.getParameter("SurplusType"));

        try{
            retailerInventoryBusinessLogic.addInventory(inventory);
            response.sendRedirect("views/RetailerPage.jsp");
        }catch(Exception e){
            e.printStackTrace();
        } finally{

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
