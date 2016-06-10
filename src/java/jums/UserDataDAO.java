package jums;

import base.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author kobayashi
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化する処理
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,password,mail,address,total,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPass());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getJusyo());
            st.setInt(5, ud.getTotal());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * ユーザー名とパスワードによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを所持しているJavaBeans
     * @return 検索結果
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public UserDataDTO search(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE name = ? AND password = ?";
            st =  con.prepareStatement(sql);
            
            
            st.setString(1, ud.getName());
            st.setString(2, ud.getPass());
            
            
            ResultSet rs = st.executeQuery();
            
            UserDataDTO resultUd = new UserDataDTO();
            while(rs.next()){
            resultUd.setUserID(rs.getInt("userID"));
            resultUd.setName(rs.getString("name"));
            resultUd.setPass(rs.getString("password"));
            resultUd.setMail(rs.getString("mail"));
            resultUd.setJusyo(rs.getString("address"));
            resultUd.setTotal(rs.getInt("total"));
            resultUd.setNewDate(rs.getTimestamp("newDate"));
            }
            
            System.out.println("search completed");
            
            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void buyinsert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO buy_t(userID,total,type,buyDate) VALUES(?,?,?,?)");
            st.setInt(1, ud.getUserID());
            st.setInt(2, ud.getSumtotal());
            st.setInt(3, ud.getType());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    /**
     * 購入額をユーザーのトータル情報に加算する処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 
     */
    public void totalupdate(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user_t SET total = ? WHERE userID = ?");
            st.setInt(1, ud.getTotal());
            st.setInt(2, ud.getUserID());
            st.executeUpdate();
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    /**
     * ユーザー情報の更新処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 
     */
    public void update(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user_t SET name = ?,password = ?,mail = ?,address = ? WHERE userID = ?");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPass());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getJusyo());
            st.setInt(5, ud.getUserID());
            st.executeUpdate();
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    /**
     * ユーザーIDによる1件のデータの削除処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void delete(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "DELETE FROM user_t WHERE userID = ?";
            st =  con.prepareStatement(sql);
            
            st.setInt(1, ud.getUserID());
            
            st.executeUpdate();
            
            System.out.println("Delete completed");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
}
