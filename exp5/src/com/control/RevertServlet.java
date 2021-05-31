package com.control;

import com.factory.DAOFactory;
import com.vo.Message;
import com.vo.Revert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/Revert")
public class RevertServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("utf-8");
        String path = "errors.jsp";
        String statusRevert = request.getParameter("statusRevert");
        if(statusRevert!=null){
            if(statusRevert.equals("selectid")){
                Message message = (Message) request.getAttribute("message");//可能不需要
                request.setAttribute("message",message);
                int id = Integer.parseInt(request.getParameter("messageid"));
                System.out.println(id);
                try {
                    request.setAttribute("allRevert", DAOFactory.getRevertDAOInstance().queryBymessageID(id));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                path = "revertMessage.jsp";
            }
            if(statusRevert.equals("insert")){
                int messageid = Integer.parseInt(request.getParameter("messageid"));
                String writer = request.getParameter("writer");
                String content = request.getParameter("content");
                java.sql.Date writerDate = new java.sql.Date(new java.util.Date().getTime());
                Revert revert = new Revert();
                revert.setMessageID(messageid);
                revert.setWriter(writer);
                revert.setWriteDate(writerDate);
                revert.setContent(content);
                System.out.println(revert.toString());
                boolean flag = false;
                try {
                    DAOFactory.getRevertDAOInstance().insertBymessageID(revert);
                    flag = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.setAttribute("flag",flag);
                request.setAttribute("messageid",messageid);
                path = "saveRevert.jsp";
            }
            if(statusRevert.equals("deletebyid")){
                int revertid = Integer.parseInt(request.getParameter("revertid"));
                int messageid = Integer.parseInt(request.getParameter("messageid"));
                System.out.println("1:"+messageid);
                boolean flag = false;
                try {
                    DAOFactory.getRevertDAOInstance().deleteByRevertID(revertid);
                    flag = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.setAttribute("flag",flag);
                request.setAttribute("messageid",messageid);
                path = "delRevert.jsp";
            }
        }else{
        }
        request.getRequestDispatcher(path).forward(request,response);
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        this.doPost(request,response);
    }
}
