<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログインページ</title>
    </head>
    <body>
        <%if(request.getAttribute("er") != null){%>
        <h1>ログインに失敗しました。</h1>
        <%}%>
    <form action="LoginResult" method="POST">
        ユーザー名：<input type="text" name="txtID"><br>
        パスワード：<input type="text" name="txtPass"><br>
        <input type="submit" value="ログイン"/><br>
        </form>
    <a href="Registration">新規会員登録</a><br>
    </body>
    <%=jh.home()%>
</html>
