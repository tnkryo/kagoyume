<%@page import="java.util.ArrayList"%>
<%@page import="com.fasterxml.jackson.databind.JsonNode"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList<JsonNode> cart = (ArrayList<JsonNode>)hs.getAttribute("cart");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購入確認</title>
    </head>
    <body>
        <a href="Login">ログアウト</a> <a href="Mydata">マイページ</a>　<a href="Cart">カート</a>
        <br>
        <%int kei = 0;%>
        <%for(int i = 0;i<cart.size();i++){%>
            <img src=<%=cart.get(i).get("Image").get("Medium")%>/><br>
            商品名：<%=cart.get(i).get("Name")%><br>
            価格　：<%=cart.get(i).get("Price").get("_value")%>円<br><br><br>
            <%
                kei+=Integer.parseInt(String.valueOf(cart.get(i).get("Price").get("_value")).replaceAll("[\"]", ""));
        }%>
        合計額：<%=kei%>円<br><br>
        発送方法<br>
        <form action="BuyComplete" method="POST">
        <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>"<%if(1 == i){out.print("checked");}%>><%=jh.exTypenum(i)%><br>
            <% } %><br>
            <input type="hidden" name="sum" value="<%=kei%>">
            <input type="submit" value="上記の内容で購入する"/><br>
         </form>
    </body>
    <%=jh.home()%>
</html>
