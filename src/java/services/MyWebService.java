/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
import objects.Inventory;

/**
 * REST Web Service
 *
 * @author Canyon
 */
@Path("webservice")
public class MyWebService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MyWebService
     */
    public MyWebService() {
    }

    /**
     * Retrieves representation of an instance of services.MyWebService
     * @param userid
     * @param password
     * @return an instance of java.lang.String
     */
    @GET
    @Path("verifyUser")
    @Consumes("application/json")
    @Produces("application/json")
    public Response VerifyUser(
        @QueryParam("userid") String userid,
        @QueryParam("password") String password) {
        
        try {
            //step 1 load driver
                Class.forName("com.mysql.jdbc.Driver");
            
            //step 2 create and prepare connection url
                String connURL = "jdbc:mysql://localhost/onlineshop?user=root&password=12345";
            //step 3 establish connection
                Connection conn = DriverManager.getConnection(connURL);
            //step 4 create query statement or update statement
                //prepare statement string
                String sqlStr = "SELECT password from login WHERE userid =? ";
                PreparedStatement pstmt = conn.prepareStatement(sqlStr);
                //set the variables of the statement
                pstmt.setString(1, userid);
            //step 5 execute
                ResultSet rs = pstmt.executeQuery();
            //step 6 process result
                //if password is correct
                while (rs.next()) {
                    if (password.equals(rs.getString("password"))) {
                        //return OK response and keep the userid
                        //return Response.status(Response.Status.OK).entity(userid).build();
                        return Response.status(Response.Status.OK).entity("true").build();
                        //return "User found";
                    }
                    else {
                        //send invalid response due to username and/or password
                        return Response.status(Response.Status.OK).entity("false").build();
                        //return "Login info is incorrect";
                    }
                }
            //step 7 close connection
                conn.close();
                
            
            } catch (Exception e) {
                //return Response.status(Response.Status.OK).entity("false").build();
                return Response.status(Response.Status.OK).entity("Error retrieving information").build();
            }
        //return Response.status(Response.Status.OK).entity("false").build();
        //keeps coming here
        
        return Response.status(Response.Status.OK).entity("false").build();
    }

    
    @GET
    @Path("searchInventory")
    @Consumes("application/json")
    @Produces("application/json")
    public Response searchInventory(@QueryParam("searchString") String searchString) {
        //want to return an Inventory object
        //return Response.status(Response.Status.OK).entity("Tried to search").build();
        
        try {
            //step 1 load driver
            Class.forName("com.mysql.jdbc.Driver");
            //step 2 create and prepare connection url
            String connURL = "jdbc:mysql://localhost/onlineshop?user=root&password=12345";
            //step 3 establish connection
            Connection conn = DriverManager.getConnection(connURL);
            //step 4 create query statement or update statement
            //prepare statement string
            String sqlStr = "SELECT * from inventory WHERE Functions LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(sqlStr);
            //set the variables of the statement
            pstmt.setString(1, searchString);
            //step 5 execute
            ResultSet rs = pstmt.executeQuery();
            //step 6 process result
            ArrayList<objects.Inventory> result_list = new ArrayList<>();
            while (rs.next()) {
                //create an inventory object
                int phone_ID = Integer.parseInt(rs.getString("ID"));
                String phone_Brand = rs.getString("Brand");
                String phone_Model = rs.getString("Model");
                String phone_Functions = rs.getString("Functions");
                int phone_Quantity = Integer.parseInt(rs.getString("Quantity"));
                   
                Inventory current_phone = new Inventory(phone_ID,phone_Brand,phone_Model,phone_Functions,phone_Quantity);
                    
                //add it into arraylist
                result_list.add(current_phone);
                //then return whole thing as a response entity
            } 
            //step 7 close connection
            conn.close();
            return Response
                .status(Response.Status.OK)
                .entity(result_list).build();
                
            
            } catch (Exception e) {
                //return Response.status(Response.Status.OK).entity("false").build();
                return Response.status(Response.Status.OK).entity("Error retrieving information").build();
            }
        //return Response.status(Response.Status.OK).entity("false").build();
        //keeps coming here
        
        
        
    }

    
    
    
    /**
     * PUT method for updating or creating an instance of MyWebService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
