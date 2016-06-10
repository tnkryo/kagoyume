<%@page import="jums.UserData"%>
<%
    HttpSession hs = request.getSession();
    UserData udb = (UserData)hs.getAttribute("user");
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>top</title>
    </head>
    <body>
        <%if(hs.getAttribute("user")==null){%>
        <a href="Login?p=top">ログイン</a>
                <%}else{%>
        <a href="Login">ログアウト</a> <a href="Mydata">マイページ</a>　<a href="Cart">カート</a>
        <%}%>
        <form action="Search" method="POST">
        
        キーワード検索：
        <input type="text" name="query"/>
        <input type="submit" value="Yahooショッピングで検索"/>
        </form>
    </body>
</html>
