<%@ page import="java.util.List" %>
<%@ page import="com.vo.Message" %><%--
  Created by IntelliJ IDEA.
  User: 彭浩
  Date: 2021/5/5
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MVC+DAO留言管理程序--列表</title>
</head>
<body>
    <h1>全部帖子管理页面</h1>
    <hr>
    <br>
    <%
        request.setCharacterEncoding("utf-8");
        List<Message> all = (List<Message>)request.getAttribute("all");
    %>
    <h3><a href="insert_message.jsp">添加新留言</a></h3>
    <table width="80%" border="1">
        <tr><th>留言ID</th><th>标题</th><th>作者</th><th>内容</th>
            <th>时间</th><th>删除</th></tr>
        <%
            for(int i = 0;i<all.size();i++){
                Message message = all.get(i);
        %>
        <tr>
            <td><%=message.getMessageID()%></td>
            <td><a href="Message?messageid=<%=message.getMessageID()%>&status=selectid"><%=message.getTitle()%></a></td>
            <td><%=message.getWriter()%></td>
            <td><%=message.getContent()%></td>
            <td><%=message.getWriteDate()%></td>
            <%
                if(session.getAttribute("uname").equals(message.getWriter())){
            %>
                <td><a href="Message?messageid=<%=message.getMessageID()%>&status=delete">删除</a></td>
            <%
                }else{
            %>
            <td>不可</td>
            <%
                }
            %>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
