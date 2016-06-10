/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kobayashi
 */
public class LoginResult extends HttpServlet {

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
                //入力内容をUDBに格納
                UserData udb = new UserData();
                udb.setName(request.getParameter("txtID"));
                udb.setPass(request.getParameter("txtPass"));
                
                //未入力があった場合
                if(udb.getName()==null || udb.getPass()==null){
                    request.setAttribute("er", "error");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }else{
                
                //DTOオブジェクトにマッピング。DB専用のパラメータに変換する処理
                UserDataDTO searchData = new UserDataDTO();
                udb.UD2DTOMapping(searchData);
                
                //該当したアカウントデータをDTOに格納
                UserDataDTO loginData = UserDataDAO .getInstance().search(searchData);
                udb.UD2BeansMapping(loginData);
                
                    //入力内容が何にも該当しなかった場合の処理
                    if(loginData.getName()==null){
                        request.setAttribute("er", "error");
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }else{

                    //ログイン成功
                    //カートのArrayListを作成
                    ArrayList<JsonNode> cart = new ArrayList<JsonNode>();
                    session.setAttribute("cart", cart);
                    session.setAttribute("user", udb);
                    log l = new log();
                    l.logs((String)session.getAttribute("p")+"に遷移");
                    request.getRequestDispatcher("/"+(String)session.getAttribute("p")+".jsp").forward(request, response);
                    }
                }
        } catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
