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
        <title>カート</title>
    </head>
    <body>
        <a href="Login">ログアウト</a> <a href="Mydata">マイページ</a>　<a href="Cart">カート</a>
        <br>
        <%if(cart.size() == 0){
            out.print("カートに商品はありません<br><br>");
        }else{
        for(int i = 0;i<cart.size();i++){%>
            <img src=<%=cart.get(i).get("Image").get("Medium")%>/><br>
            商品名： <a href="Item?ID=<%=i%>"><%=cart.get(i).get("Name")%></a><br>
            価格　：<%=cart.get(i).get("Price").get("_value")%>円<br>
            <form action="Cart" method="POST">
                <input type="hidden" name="cartid" value="<%=i%>">
            <input type="submit" value="カートから削除"/><br>
         </form><br><br>
        <%
            }%>
        <form action="BuyConfirm" method="POST">
            <input type="submit" value="購入手続きに進む"/><br>
         </form>
        <%}%>
    </body>
    <%=jh.home()%>
</html>
