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
public class BuyComplete extends HttpServlet {

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
            //ログインチェック
            if(session.getAttribute("user") == null){
                throw new Exception("不正なアクセスです");
            }
            
            //合計購入金額と発送方法をUDBに格納
            UserData udb = (UserData)session.getAttribute("user");
            udb.setTotal(request.getParameter("sum"));
            udb.setSumtotal(request.getParameter("sum"));
            udb.setType(request.getParameter("type"));
            
            //DTOオブジェクトにマッピング。DB専用のパラメータに変換する処理
            UserDataDTO buyupdata = new UserDataDTO();
            udb.UD2DTOMapping(buyupdata);
            
            //DBへデータの挿入
            UserDataDAO .getInstance().buyinsert(buyupdata);
            UserDataDAO .getInstance().totalupdate(buyupdata);
            
            //成功したのでカートの中を削除
            ArrayList<JsonNode> cart = (ArrayList<JsonNode>)session.getAttribute("cart");
            cart.clear();
                
            log l = new log();
            l.logs("商品を購入");
            l.logs("buycompleteに遷移");
            request.getRequestDispatcher("/buycomplete.jsp").forward(request, response);
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
