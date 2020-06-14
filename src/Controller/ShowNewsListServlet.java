package Controller;

import Entity.News;
import Service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShowNewsListServlet")
public class ShowNewsListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        NewsService newsService = new NewsService();
       try{
           List<News> listNews  = newsService.QueryNews();
           request.setAttribute("listNews",listNews);
           request.getRequestDispatcher("ShowNewsList.jsp").forward(request,response);
       }catch (SQLException e)
       {
           e.printStackTrace();
       }
    }
}
