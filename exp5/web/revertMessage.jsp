<%@ page import="com.vo.Message" %>
<%@ page import="com.vo.Revert" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 彭浩
  Date: 2021/5/5
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖子及其回复页面</title>
</head>
<body>
    <h3><a href="Message?status=selectall">返回帖子列表页面</a></h3>
    <%
        request.setCharacterEncoding("utf-8");
        Message message = (Message) request.getAttribute("message");
        List<Revert> allRevert =(List<Revert>) request.getAttribute("allRevert");
    %>
    <h1>帖子详情</h1>
    <table border="2">
        <tr><th>帖子id:</th><td><%=message.getMessageID()%></td></tr>
        <tr><th>标题</th><td><%=message.getTitle()%></td></tr>
        <tr><th>楼主名字:</th><td><%=message.getWriter()%></td></tr>
        <tr><th>内容:</th><td><%=message.getContent()%></td></tr>
        <tr><th>发帖时间:</th><td><%=message.getWriteDate()%></td></tr>
    </table>
    <hr>
    <br>
    <h1>回帖详情</h1>
    <table border="2">
        <tr><th>楼层</th><th>回帖ID</th><th>回帖人</th><th>回帖时间</th><th>删除</th></tr>
        <%
            for(int i = 0;i<allRevert.size();i++){

        %>
            <tr>
                <td><%=allRevert.get(i).getRevertID()%></td><td><%=allRevert.get(i).getMessageID()%></td>
                <td><%=allRevert.get(i).getContent()%></td><td><%=allRevert.get(i).getWriter()%></td>
                <td><%=allRevert.get(i).getWriteDate()%></td>
                <%
                    if(allRevert.get(i).getWriter().equals(session.getAttribute("uname"))||message.getWriter().equals(session.getAttribute("uname"))){
                %>
                <td><a href="Revert?statusRevert=deletebyid&revertid=<%=allRevert.get(i).getRevertID()%>&messageid=<%=message.getMessageID()%>">删除</a> </td>
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
    <hr>
    <br>
    <h1>回帖</h1>
    <form action="Revert" method="post">
        <table>
            <input type="hidden" name = "writer" value="<%=session.getAttribute("uname")%>">
            <input type="hidden" name = "messageid" value="<%=message.getMessageID()%>">
            <input type="hidden" name = "statusRevert" value="insert">
            <tr>
                <td>内容:</td>
                <td><textarea name = "content" cols="30" rows = "6"></textarea></td>
            </tr>
            <tr>
                <td><input type="submit" value="回帖"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>
</body>
</html>
