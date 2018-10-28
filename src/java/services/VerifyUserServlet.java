/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Canyon
 */
@WebServlet(name = "VerifyUserServlet", urlPatterns = {"/VerifyUserServlet"})
public class VerifyUserServlet extends HttpServlet {

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
            out.println("<title>Servlet VerifyUserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VerifyUserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            //time to handle the response
            String userid = request.getParameter("userid");
            String password = request.getParameter("password");
            //create new client object to handle the request
            Client client = ClientBuilder.newClient();
            WebTarget target = 
                    client
                    .target("http://localhost:8080/OnlineShop_WS/webresources/webservice")
                    .path("verifyUser")
                    .queryParam("userid",userid)
                    .queryParam("password",password);
            
            //Now what is this step?
            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
            //get response
            Response response1;
            response1 = invocationBuilder.get();
            
            String verified;
            verified = response1.readEntity(String.class);
            //verified = (String) response1.readEntity(String.class);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
//            dispatcher.forward(request, response);
            
            //if true, redirect to SearchForm.jsp
            if (verified.equalsIgnoreCase("true")) {
                //do something
                response.sendRedirect("index.html");
            }
            else if (verified.equalsIgnoreCase("false")) {
                //something
                response.sendRedirect("login.jsp");
            }
            
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
