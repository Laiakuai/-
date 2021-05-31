<%--
  Created by IntelliJ IDEA.
  User: 彭浩
  Date: 2021/4/30
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖子列表页面</title>
</head>
<body>
    <h1>帖子列表</h1>
    <hr/>
    <br/>
    <%
        if(session.getAttribute("uname")!=null){
    %>
    <h2>登入成功</h2>
    <h2>欢迎<span style="color: bisque";size:12px>
            <%=session.getAttribute("uname")%>
            </span>
        光临贴吧
    </h2>
    <h3><a href="Message?status=selectall">进入帖子管理界面</a></h3>
    <%
        }else{
            response.setHeader("refresh","2;URL = login.jsp");
    %>
            您还未登入，请先登入！！！<br/>
            两秒后跳转到登入页面！！！<br/>
            如果没有跳转请按<a href="login.jsp">这里</a>
    <%
        }
    %>
</body>
</html>
