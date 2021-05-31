<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 彭浩
  Date: 2021/5/5
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MVC+DAO留言管理程序--添加</title>
</head>
<body>
    <h1>贴吧管理--发新帖子</h1>
    <hr />	<br />
    <form action = "Message" method="post">
        <table>
            <tr><td colspan="2">添加新帖子</td> </tr>
            <tr>
                <td>标题:</td>
                <td><input type="text" name = "title"> </td>
            </tr>
            <tr>
                <td>发帖人:</td>
                <td><%=session.getAttribute("uname")%></td>
                <input type="hidden" name = "writer" value="<%=session.getAttribute("uname")%>">
            </tr>
            <tr>
                <td>内容:</td>
                <td><textarea name = "content" cols="30" rows = "6"></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="hidden" name = "status" value="insert">
                    <input type="submit" value="添加">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
    <h3><a href="list_message.jsp">回到留言列表</a> </h3>
</body>
</html>
