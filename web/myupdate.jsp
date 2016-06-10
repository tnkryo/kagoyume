<%@page import="jums.UserData"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserData udb = (UserData)hs.getAttribute("user");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>更新ページ</title>
    </head>
    <body>
        <a href="Login">ログアウト</a> <a href="Mydata">マイページ</a>　<a href="Cart">カート</a>
        <br>
        <form action="MyupdateResult" method="POST">
            ユーザー名　　：<input type="text" name="txtID" value="<%= udb.getName()%>"><br>
            パスワード　　：<input type="text" name="txtPass" value="<%= udb.getPass()%>"><br>
            メールアドレス：<input type="text" name="txtMail" value="<%= udb.getMail()%>"><br>
            住所　　　　　：<input type="text" name="txtJusyo" value="<%= udb.getJusyo()%>"><br>
        <input type="submit" value="変更">
        </form>
    </body>
    <%=jh.home()%>
</html>
