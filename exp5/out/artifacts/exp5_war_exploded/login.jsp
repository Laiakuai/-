<%--
  Created by IntelliJ IDEA.
  User: 彭浩
  Date: 2021/4/30
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登入页面</title>
</head>
<body>
    <%
        if(request.getAttribute("err")!= null){
    %>
        <h2><%=request.getAttribute("err")%></h2>
    <%
        }
    %>
    <h1>留言管理页面--登入页面</h1>
    <hr/>
    <br>
    <form action = "Login" method="post">
        用户ID:<input type = "text" name = "id"/> <br>
        密码:<input type="password" name = "password"/> <br>
        <input type="submit" value="登入"/>
        <input type="reset" value = "重置"/>
    </form>
</body>
</html>
