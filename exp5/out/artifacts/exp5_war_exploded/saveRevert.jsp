<%--
  Created by IntelliJ IDEA.
  User: 彭浩
  Date: 2021/5/5
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>回帖处理页面</title>
</head>
<body>
    <h1>回帖处理页面</h1>
    <hr>
    <br>
    <%
        request.setCharacterEncoding("utf-8");
        response.setHeader("refresh","2;URL=Message?status=selectid&messageid="+request.getAttribute("messageid"));
        boolean b = ((Boolean)request.getAttribute("flag")).booleanValue();
        if(b){
    %>
        留言添加成功，两秒后跳转到留言列表!!<br>
        如果没有跳转请按<a href="Message?status=selectid&messageid=<%=request.getAttribute("messageid")%>">这里</a>
    <%
    }else{
    %>
        留言添加失败，两秒后跳转到留言列表页 ！！！<br/>
        如果没有跳转，请按<a href="Message?status=selectid&messageid=<%=request.getAttribute("messageid")%>">这里</a>！！！
    <%
        }
    %>
</body>
</html>
