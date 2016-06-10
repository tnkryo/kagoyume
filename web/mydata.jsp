<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserData"%>
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
        <title>マイページ</title>
    </head>
    <body>
        <a href="Login">ログアウト</a> <a href="Mydata">マイページ</a>　<a href="Cart">カート</a>
        <br>
        ユーザー名　　：<%= udb.getName()%><br>
        メールアドレス：<%= udb.getMail()%><br>
        住所　　　　　：<%= udb.getJusyo()%><br>
        合計購入額　　：<%= udb.getTotal()%><br>
        <form action="Myupdate" method="POST">
      <input type="submit" name="update" value="変更">
    </form>
    <form action="Mydelete" method="POST">
      <input type="submit" name="delete" value="削除">
    </form>
    <br>
    </body>
    <%=jh.home()%>
</html>
