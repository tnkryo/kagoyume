<%@page import="jums.JumsHelper"%>
<%@page import="com.fasterxml.jackson.databind.JsonNode"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    JsonNode k = (JsonNode)hs.getAttribute("kekka");
    String s = (String)hs.getAttribute("kensaku");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索結果一覧</title>
    </head>
    <body>
        <%if(hs.getAttribute("user")==null){%>
        <a href="Login?p=search">ログイン</a>
                <%}else{%>
        <a href="Login">ログアウト</a> <a href="Mydata">マイページ</a>　<a href="Cart">カート</a>
        <%}%><br>
        <%=s%>の検索結果<br>
        <%  String ssize = String.valueOf(k.get("ResultSet").get("totalResultsReturned"));
            int size = Integer.parseInt(ssize);
            out.print(size+"件表示<br>");
            for(int i=0;i<size;i++){
          String p = String.valueOf(i);%>
          <a href="Item?ID=<%=p%>">
              <img src=<%=k.get("ResultSet").get("0").get("Result").get(p).get("Image").get("Medium")%>/>
            <%=k.get("ResultSet").get("0").get("Result").get(p).get("Name")%></a>
            <%=k.get("ResultSet").get("0").get("Result").get(p).get("Price").get("_value")+"円<br>"%>
        <%
            }
            %>
    </body>
    <%=jh.home()%>
</html>
