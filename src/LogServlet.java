import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LogServlet")
public class LogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=GB2312");
        request.setCharacterEncoding("GB2312");
        PrintWriter out = response.getWriter(); //获得输出流
        //从请求对象中获得指定参数的值
        String strName = request.getParameter("txtName");
        String strPwd = request.getParameter("txtPwd");
        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        PreparedStatement pstmt;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=Education","sa","123456cyl");
            String  sql = "select * from tb_user where username=? and password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, strName);
            pstmt.setString(2, strPwd);
            rs=pstmt.executeQuery();
            if (rs.next())
            {

                out.println("您好！" + strName + " "+strPwd + "<br>");

                Cookie cookieUserName= new Cookie("username", strName);//创建一个键值对的cookie对象
                cookieUserName.setMaxAge(60*60*24*30);//设置cookie的生命周期
                response.addCookie(cookieUserName);//添加到response中

                Cookie cookiePwd= new Cookie("password", strPwd);//创建一个键值对的cookie对象
                cookiePwd.setMaxAge(60*60*24*30);//设置cookie的生命周期
                response.addCookie(cookiePwd);//添加到response中

                HttpSession session = request.getSession(true);

                response.sendRedirect("page/index.html");
              //  request.getRequestDispatcher("/page/index.html").forward(request,response);

            }
            else {

                out.println("错误的用户名和密码");
            }
            rs.close();
            conn.close();
            pstmt.close();
        } catch (Exception e)
        {
            System.out.println(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
