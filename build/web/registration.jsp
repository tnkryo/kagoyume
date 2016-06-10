<%@page import="jums.UserData"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserData udb = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        udb = (UserData)hs.getAttribute("udb");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員登録ページ</title>
    </head>
    <body>
        <form action="RegistrationConfirm" method="POST">
            ユーザー名　　：<input type="text" name="txtID" value="<% if(reinput){out.print(udb.getName());}%>"><br>
            パスワード　　：<input type="text" name="txtPass" value="<% if(reinput){out.print(udb.getPass());}%>"><br>
            メールアドレス：<input type="text" name="txtMail" value="<% if(reinput){out.print(udb.getMail());}%>"><br>
            住所　　　　　：<input type="text" name="txtJusyo" value="<% if(reinput){out.print(udb.getJusyo());}%>"><br>
        <input type="submit" value="登録">
        </form>
    </body>
    <%=jh.home()%>
</html>
