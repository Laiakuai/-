package com.control;

import com.factory.DAOFactory;
import com.vo.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String path = "login.jsp";
        String id = request.getParameter("id");
        String password =request.getParameter("password");
        Person person = new Person();
        person.setId(id);
        person.setPassword(password);
        try{
            if(DAOFactory.getPersonDAOInstance().login(person)){
                request.getSession().setAttribute("uname",person.getName()); //防盗链功能
                path = "login_success.jsp";
            }else{
                //登入失败
                //设置错误信息
                request.setAttribute("err","错误的ID或密码!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher(path).forward(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        this.doPost(request, response);
    }
}
