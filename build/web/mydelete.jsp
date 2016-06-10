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
        <title>ユーザー削除</title>
    </head>
    <body>
        <a href="Login">ログアウト</a> <a href="Mydata">マイページ</a>　<a href="Cart">カート</a>
        <br>
        ユーザー名　　：<%= udb.getName()%><br>
        メールアドレス：<%= udb.getMail()%><br>
        住所　　　　　：<%= udb.getJusyo()%><br>
        合計購入額　　：<%= udb.getTotal()%><br>
        このユーザーをマジで削除しますか？<br>
        <form action="MydeleteResult" method="POST">
      <input type="submit" name="YES" value="はい">
    </form>
    <form action="top.jsp" method="POST">
        <input type="hidden" name="mode" value="REINPUT">
      <input type="submit" name="NO" value="いいえ">
    </form>
    </body>
    <%=jh.home()%>
</html>
