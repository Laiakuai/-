<%--
  Created by IntelliJ IDEA.
  User: 彭浩
  Date: 2021/5/5
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除帖子处理</title>
</head>
<body>
    <h1>删除帖子处理页面</h1>
    <hr>
    <br>
    <%
        response.setHeader("refresh","2;URL=Message?status=selectall");
        boolean b = ((Boolean)request.getAttribute("flag")).booleanValue();
        if(b){
    %>
    留言删除成功，两秒后跳转到留言列表页！！！<br/>
    如果没有跳转，请按 <a href="Message?status=selectall">这里</a>！！！
    <%
        }else{
    %>
    留言删除失败，两秒后跳转到留言列表页 ！！！<br/>
    如果没有跳转，请按 <a href="Message?status=selectall">这里</a>！！！
    <%
        }
    %>
</body>
</html>
