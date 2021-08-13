/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datnq.controller;

import datnq.dao.UserDAO;
import datnq.dto.UserDTO;
import datnq.dto.UserError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Quoc Dat
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    private static final String SUCCESS = "index.html";
    private static final String ERROR = "createUser.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String url = ERROR;
        UserError userError = new UserError();
        try {
            String userID = request.getParameter("userID");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String repassword = request.getParameter("repassword");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            Date createDate = Date.valueOf(request.getParameter("createDate"));
            int roleID = 2;
            int statusID = 1;
            boolean valid = true;
            
            if (userID.length() < 5 || userID.length() > 30) {
                userError.setUserIDError("User must be in [5 - 30]");
                valid = false;
            }if (!password.equals(repassword)){
                userError.setConfirmPasswordError("Hai password ko trung nhau ");
                valid = false;
            }if (phone.length() <10 || phone.length() > 12){
                userError.setPhoneError("Phone number length must be in [10-12]");
                valid = false;
            }if (address.length() < 3 || address.length() > 100){
                userError.setAddressError("Address length must be in [3-100]");
                valid = false;
            }if (name.length() < 3 || name.length() > 25){
              userError.setNameError("Name length must be in [3-12]");
                valid = false;
            }
            
            if (valid){
                UserDAO dao = new UserDAO();                
                boolean check = dao.checkDuplicate(userID);
                if (check){
                    userError.setUserIDError("UserID trung roi kia");
                    request.setAttribute("USER_ERROR", userError);
                }else{
                    UserDTO user = new UserDTO(userID, name, password, phone, address, createDate, roleID, statusID);
                    boolean isInsert = dao.insertUser(user);
                    if (isInsert){
                        url = SUCCESS;
                    }
                }
            }else{
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception e) {
            log("Exception at RegisterController: " + e.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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
