/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import api.common;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kobayashi
 */
public class Search extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        
        try {
            common c = new common();
            request.setCharacterEncoding("UTF-8");
            String query = "";
            if(!request.getParameter("query").equals("")){
            query = request.getParameter("query");
            }
            if(!query.equals("")){
                String query4url = URLEncoder.encode(query, "UTF-8");
                String urlz = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?appid="+c.appid+"&query="+query4url;
                String result = "";
                
                URL url = new URL(urlz);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.connect();
                BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
                String tmp = "";
                while ((tmp = in.readLine()) != null) {
                result += tmp;
                }
                in.close();
                con.disconnect();
                
                JsonNode head = null;
                JsonFactory jfactory = new JsonFactory();
                JsonParser parser = jfactory.createParser(result);
                ObjectMapper mapper = new ObjectMapper();
                head = mapper.readTree(parser);
                
                session.setAttribute("kekka", head);
                session.setAttribute("kensaku", query);
                
                log l = new log();
                l.logs("searchに遷移");
                request.getRequestDispatcher("/search.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("/top.jsp").forward(request, response);
            }
            }catch(Exception e){
                e.printStackTrace();
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
