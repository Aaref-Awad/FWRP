/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

//import DTO.InventoryDTO;
//import businesslayer.InventoryBusinessLogic;
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
            /* TODO output your page here. You may use following sample code. */
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        InventoryBusinessLogic inventoryBusinessLogic = new InventoryBusinessLogic();
//        List<InventoryDTO> foodItems = null;
//
//        try {
//            foodItems = inventoryBusinessLogic.getAllFoodItems();
//        } catch (SQLException ex) {
//            log(ex.getMessage());
//        }
//
//        request.setAttribute("fooditems", foodItems);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("views/RetailerPage.jsp");
//        dispatcher.forward(request, response);
//    }

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

        try{
            // Create a RetailerInventoryDTO object with updated information
            RetailerInventoryDTO updatedInventory = new RetailerInventoryDTO();
            if (userId != null) {
                updatedInventory.setUserID(userId);
            }
            updatedInventory.setInventoryID(Integer.parseInt(request.getParameter("inventoryId")));
            updatedInventory.setFoodName(request.getParameter("foodName"));
            updatedInventory.setFoodAmount(Integer.parseInt(request.getParameter("foodAmount")));
            updatedInventory.setExpirationDate(Date.valueOf(request.getParameter("expirationDate")));
            updatedInventory.setSurplusType(request.getParameter("surplusType"));
            updatedInventory.setPrice(Double.parseDouble(request.getParameter("price")));

            // Update inventory in the database
            RetailerInventoryBusinessLogic retailerInventoryBusinessLogic = new RetailerInventoryBusinessLogic();
            retailerInventoryBusinessLogic.updateInventory(updatedInventory);

            // Redirect back to the UpdateInventoryPage or any other appropriate page
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
        return "Short description";
    }// </editor-fold>

}
