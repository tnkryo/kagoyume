package jums;

import java.util.ArrayList;

/**
 *
 * @author kobayashi
 */
public class JumsHelper {
    
    //トップへのリンクを定数として設定
    private final String homeURL = "Top";
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //トップへのリンクを返却
    public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
    
    /**
     * 入力されたデータのうち未入力項目がある場合、チェックリストにしたがいどの項目が
     * 未入力なのかのhtml文を返却する
     * @param chkList　UserDataBeansで生成されるリスト。未入力要素の名前が格納されている
     * @return 未入力の項目に対応する文字列
     */
    public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("name")){
                    output += "名前";
                }
                if(val.equals("pass")){
                    output +="パスワード";
                }
                if(val.equals("mail")){
                    output +="メールアドレス";
                }
                if(val.equals("jusyo")){
                    output +="住所";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
    
    /**
     * 種別は数字で取り扱っているので画面に表示するときは日本語に変換
     * @param i
     * @return 
     */
    public String exTypenum(int i){
        switch(i){
            case 1:
                return "宅配便";
            case 2:
                return "クール便";
            case 3:
                return "コンビニ店頭受け取り";
        }
        return "";
    }
}
