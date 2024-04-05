/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

//import DAO.InventoryDAO;
//import DAO.InventoryDAOImpl;
//import DTO.InventoryDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luke
 */
@WebServlet(name = "ClaimDonationServlet", urlPatterns = {"/claimDonation"})
public class ClaimDonationServlet extends HttpServlet {

//    @Override
//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    String[] foodIds = request.getParameterValues("foodId"); // Assuming "foodId" is the name of your checkboxes
//    if (foodIds != null) {
//        InventoryDAO inventoryDAO = new InventoryDAOImpl(); // Instantiate your DAO
//        for (String foodId : foodIds) {
//            
//            int foodIdInt = Integer.parseInt(foodId); // Convert the foodId to an int if needed
//            InventoryDTO food = inventoryDAO.getFoodById(foodIdInt); // Get the food item from the database
//            if (food != null) {
//                
//                // Update the food item as needed
//                food.setFoodAmount(food.getFoodAmount() + 1);
//                inventoryDAO.updateFood(food); // Update the food item in the database
//            }
//        }
//    }
//    // Redirect back to the charitable organization page
//    response.sendRedirect("/views/CharityOrgPage.jsp");
//}
//
//
//    @Override
//protected void doGet(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//    InventoryDAO inventoryDAO = new InventoryDAOImpl(); // Instantiate your DAO
//    List<InventoryDTO> donations = inventoryDAO.getAllFoodItems(); // Assuming you have a method to retrieve all available donations
//
//    request.setAttribute("donations", donations);
//    request.getRequestDispatcher("/views/CharityOrgPage.jsp").forward(request, response);
//}


    @Override
    public String getServletInfo() {
        return "Short description";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClaimDonationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClaimDonationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
