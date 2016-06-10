package jums;

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
public class MyupdateResult extends HttpServlet {

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
            
            //フォームからの入力を取得して、JavaBeansに格納
            UserData udbx = new UserData();
            udbx.setName(request.getParameter("txtID"));
            udbx.setPass(request.getParameter("txtPass"));
            udbx.setMail(request.getParameter("txtMail"));
            udbx.setJusyo(request.getParameter("txtJusyo"));
            request.setAttribute("udbx", udbx);
            
                //未入力がないかチェックする
                ArrayList<String> chkList = udbx.chkproperties();
                
                if(chkList.size() == 0){
                UserDataDTO Update = new UserDataDTO();
                UserData udb = (UserData)session.getAttribute("user");
                
                //入力された情報をDTOに入れてUPDATEする
                udb.UD2DTOMapping(Update);
                udbx.UD2DTOMapping(Update);
                UserDataDAO .getInstance().update(Update);
                
                //更新したものをUserDataBeansに逆マッピングする
                udb.UD2BeansMapping(Update);
                }
                else{
                    log l = new log();
                    l.logs("myupdateresultに遷移");
                    request.getRequestDispatcher("/myupdateresult.jsp").forward(request, response);
                }
            log l = new log();
            l.logs("myupdateresultに遷移");
            request.getRequestDispatcher("/myupdateresult.jsp").forward(request, response);
            
        }catch(Exception e){
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
