/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

//import DAO.InventoryDAO;
//import DAO.InventoryDAOImpl;
//import DTO.InventoryDTO;
import DTO.CharityInventoryDTO;
import DTO.RetailerInventoryDTO;
import businesslayer.CharityInventoryBusinessLogic;
import businesslayer.RetailerInventoryBusinessLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ClaimDonationServlet
 *
 * This servlet handles the claiming of donations by charity organizations.
 * It receives POST requests from the charity organization page and updates the inventory accordingly.
 * 
 * @author Luke
 */
@WebServlet(name = "ClaimDonationServlet", urlPatterns = {"/ClaimDonationServlet"})
public class ClaimDonationServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        
        try{
            // Create a CharityInventoryDTO object with updated information
            CharityInventoryDTO updatedInventory = new CharityInventoryDTO();
            if (userId != null) {
                updatedInventory.setCharityID(userId);
            }

            // Update inventory in the database
            CharityInventoryBusinessLogic charityInventoryBusinessLogic = new CharityInventoryBusinessLogic();
            updatedInventory = charityInventoryBusinessLogic.getInventoryById(Integer.parseInt(request.getParameter("inventoryId")));
            updatedInventory.setQuantity(updatedInventory.getQuantity()-1);
            if(updatedInventory.getQuantity() == 0){
                charityInventoryBusinessLogic.deleteInventory(updatedInventory);
            }else{
                charityInventoryBusinessLogic.updateInventory(updatedInventory);
            }
            // Redirect back to the UpdateInventoryPage or any other appropriate page
             

            response.sendRedirect("views/CharityOrgPage.jsp");
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
        return "Servlet for claiming donations by charity organizations";
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
