package com.control;

import com.factory.DAOFactory;
import com.vo.Message;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/Message")
public class MessageServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String path = "error.jsp";
        String status = request.getParameter("status");
        if(status !=null){
            //根据该参数内容来选择合适的方法
            //查询全部的操作
            if(status.equals("selectall")){
                try {
                    request.setAttribute("all", DAOFactory.getmessageDAOInstance().qureyAll());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                path = "list_message.jsp";
            }
            if(status.equals("insert")){
                //接受信息
                String title = request.getParameter("title");
                String writer = request.getParameter("writer");
                String content = request.getParameter("content");
                java.sql.Date writerDate = new java.sql.Date(new Date().getTime());
                //实例化对象
                Message message = new Message();
                message.setTitle(title);
                message.setWriter(writer);
                message.setContent(content);
                message.setWriteDate(writerDate);
                //调用DAO完成数据插入操作
                boolean flag = false;
                try {
                    DAOFactory.getmessageDAOInstance().insert(message);
                    flag = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.setAttribute("flag",flag);
                path = "insert_do.jsp";
            }
            if(status.equals("delete")){
                int messageid = 0;
                messageid = Integer.parseInt(request.getParameter("messageid"));
                boolean flag = false;
                try {
                    DAOFactory.getRevertDAOInstance().deleteByMessageID(messageid);
                    DAOFactory.getmessageDAOInstance().delete(messageid);
                    //还要调用根据帖子id来删除所有回复的DAO
                    flag = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.setAttribute("flag",flag);
                path = "delete_do.jsp";
            }
            if(status.equals("selectid")){
                int id = 0;
                id = Integer.parseInt(request.getParameter("messageid"));
                try {
                    request.setAttribute("message",DAOFactory.getmessageDAOInstance().queryByID(id));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                path = "Revert?statusRevert=selectid&messageid="+id;
            }
        }else{
            //
        }
        request.getRequestDispatcher(path).forward(request,response);
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request,response);
    }
}
