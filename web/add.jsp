<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="Login">ログアウト</a> <a href="Mydata">マイページ</a>　<a href="Cart">カート</a>
        <br>
        <h1>カートに追加しました！</h1><br>
        <form action="search.jsp" method="POST">
             <input type="submit" value="買い物を続ける"/>
        </form><br>
        <%=jh.home()%>
    </body>
</html>
