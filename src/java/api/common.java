package api;

import java.util.HashMap;

/**
 *
 * @author kobayashi
 */
public class common {
    public String appid = "dj0zaiZpPU1hTmprRnRyRGNZSCZzPWNvbnN1bWVyc2VjcmV0Jng9ZDA-";
    
    public HashMap<String, String> categories = new HashMap<String, String>(){
        {put("1", "すべてのカテゴリから");
         put("13457", "ファッション");
         put("2498", "食品");
         put("2500", "ダイエット、健康");
         put("2501", "コスメ、香水");
         put("2502", "パソコン、周辺機器");
         put("2504", "AV機器、カメラ");
         put("2505", "家電");
         put("2506", "家具、インテリア");
         put("2507", "花、ガーデニング");
         put("2508", "キッチン、生活雑貨、日用品");
         put("2503", "DIY、工具、文具");
         put("2509", "ペット用品、生き物");
         put("2510", "楽器、趣味、学習");
         put("2511", "ゲーム、おもちゃ");
         put("2497", "ベビー、キッズ、マタニティ");
         put("2512", "スポーツ");
         put("2513", "レジャー、アウトドア");
         put("2514", "自転車、車、バイク用品");
         put("2516", "CD、音楽ソフト");
         put("2517", "DVD、映像ソフト");
         put("10002", "本、雑誌、コミック");}
    };
    
    public HashMap<String, String> sortOrder = new HashMap<String, String>(){
        {put("-score", "おすすめ順");
         put("+price", "商品価格が安い順");
         put("-price", "商品価格が高い順");
         put("+name", "ストア名昇順");
         put("-name", "ストア名降順");
         put("-sold", "売れ筋順");}
    };
}
