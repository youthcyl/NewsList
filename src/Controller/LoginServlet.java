package Controller;

import Entity.User;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        User user = new User();
        user.setUsername(request.getParameter("txtName"));
        user.setPassword(request.getParameter("txtPwd"));
        UserService userService = new UserService();
        if(userService.QueryUser(user))
        {
            Cookie cookieUserName = new Cookie("username", user.getUsername());//创建一个键值对的cookie对象
            cookieUserName.setMaxAge(60*60*24*30);//设置cookie的生命周期
            response.addCookie(cookieUserName);//添加到response中

            Cookie cookiePwd= new Cookie("password", user.getPassword());//创建一个键值对的cookie对象
            cookiePwd.setMaxAge(60*60*24*30);//设置cookie的生命周期
            response.addCookie(cookiePwd);//添加到response中

            HttpSession session = request.getSession(true);

            response.sendRedirect("page/index.html");

        }

        else{
            out.println("错误的用户名和密码");

        }

    }
}
