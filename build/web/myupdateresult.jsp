<%@page import="java.util.ArrayList"%>
<%@page import="jums.UserData"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserData udb = (UserData)hs.getAttribute("user");
    UserData udbx = (UserData)request.getAttribute("udbx");
    ArrayList<String> chkList = udbx.chkproperties();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>更新結果</title>
    </head>
    <body>
        <a href="Login">ログアウト</a> <a href="Mydata">マイページ</a>　<a href="Cart">カート</a>
        <br>
        <% if(chkList.size()==0){ %>
        ユーザー名　　：<%=udb.getName()%><br>
        パスワード　　：<%=udb.getPass()%><br>
        メールアドレス：<%=udb.getMail()%><br>
        住所　　　　　：<%=udb.getJusyo()%><br>
        以上の内容で更新しました。
       
        <%}else{%>
        <%=jh.chkinput(chkList) %><br>
        <form action="Myupdate" method="POST">
      <input type="submit" name="NO" value="入力画面に戻る">
      <%}%>
        </form>
    </body>
    <%=jh.home()%>
</html>
