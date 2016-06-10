<%@page import="jums.JumsHelper"%>
<%@page import="com.fasterxml.jackson.databind.JsonNode"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    JsonNode k = (JsonNode)hs.getAttribute("kekka");
    String s = (String)hs.getAttribute("id");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品詳細</title>
    </head>
    <body>
        <%if(hs.getAttribute("user")==null){%>
        <a href="Login?p=item">ログイン</a>
                <%}else{%>
        <a href="Login">ログアウト</a> <a href="Mydata">マイページ</a>　<a href="Cart">カート</a>
        <%}%><br>
         <img src=<%=k.get("ResultSet").get("0").get("Result").get(s).get("Image").get("Medium")%>/><br>
         商品名：<%=k.get("ResultSet").get("0").get("Result").get(s).get("Name")%><br>
         概要　：<%=k.get("ResultSet").get("0").get("Result").get(s).get("Description")%><br>
         評価　：<%=k.get("ResultSet").get("0").get("Result").get(s).get("Review").get("Rate")%>(
         <%=k.get("ResultSet").get("0").get("Result").get(s).get("Review").get("Count")%>件のレビュー)<br>
         価格　：<%=k.get("ResultSet").get("0").get("Result").get(s).get("Price").get("_value")%>円
         <form action="Add" method="POST">
             <%if(hs.getAttribute("user")!=null){%>
             <input type="submit" value="カートに入れる"/>
             <%}%>
         </form>
    </body>
    <%=jh.home()%>
</html>
