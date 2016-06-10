<%@page import="jums.UserData"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserData udb = (UserData)request.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        ユーザー名　　：<%= udb.getName()%><br>
        パスワード　　：<%= udb.getPass()%><br>
        メールアドレス：<%= udb.getMail()%><br>
        住所　　　　　：<%= udb.getJusyo()%><br>
        以上の内容で登録しました。<br>
    </body>
    <%=jh.home()%>
</html>
