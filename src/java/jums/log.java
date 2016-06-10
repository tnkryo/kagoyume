package jums;

import java.util.*;
import java.io.*;
import java.text.*;

/**
 *
 * @author kobayashi
 */
public class log {
    public void logs(String t){
        try{
            File txt = new File("C:\\Users\\kobayashi\\Documents\\NetBeansProjects\\kagoyume\\web\\WEB-INF\\log\\log.txt");
            FileWriter fw = new FileWriter(txt,true);
            BufferedWriter bw = new BufferedWriter(fw);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒");
            String sdate = sdf.format(date);
            bw.write(t+sdate);
            bw.newLine();
            bw.flush();
            bw.close();
        }catch(IOException e){
            System.out.printf(e.getMessage());
        }
    }
}
