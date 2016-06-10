package jums;

import java.sql.Timestamp;

/**
 *
 * @author kobayashi
 */
public class UserDataDTO {
    private int userID;
    private String name;
    private String pass;
    private String mail;
    private String jusyo;
    private int total;
    private Timestamp newDate;
    private int buyID;
    private int sumtotal;
    private int type;
    private Timestamp buyDate;
    
    
    
    public int getUserID(){
        return userID;
    }
    
    public void setUserID(int userID){
        this.userID = userID;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getPass(){
        return pass;
    }
    
    public void setPass(String pass){
        this.pass = pass;
    }
    
    public String getMail(){
        return mail;
    }
    
    public void setMail(String mail){
        this.mail = mail;
    }
    
    public String getJusyo(){
        return jusyo;
    }
    
    public void setJusyo(String jusyo){
        this.jusyo = jusyo;
    }
    
    public int getTotal(){
        return total;
    }
    
    public void setTotal(int total){
        this.total = total;
    }
    
    public Timestamp getNewDate(){
        return newDate;
    }
    
    public void setNewDate(Timestamp newDate){
        this.newDate = newDate;
    }
    
    public int getBuyID(){
        return buyID;
    }
    
    public void setBuyID(int buyID){
        this.buyID = buyID;
    }
    
    public int getSumtotal(){
        return sumtotal;
    }
    
    public void setSumtotal(int sumtotal){
        this.sumtotal = sumtotal;
    }
    
    public int getType(){
        return type;
    }
    
    public void setType(int type){
        this.type = type;
    }
    
    public Timestamp getBuyDate(){
        return buyDate;
    }
    
    public void setBuyDate(Timestamp buyDate){
        this.buyDate = buyDate;
    }
}
