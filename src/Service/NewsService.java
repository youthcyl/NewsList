package Service;
import DAL.SqlHelper;
import Entity.News;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class NewsService {
    public void AddNews(){}
    public void DeleteNews(){}
    public void UpdateNews(){}
    public List<News> QueryNews() throws SQLException {
        String sql="Select * from News";
        ResultSet rs;
        rs= SqlHelper.executeQuery(sql);
        List<News> listNews=new ArrayList<News>();
        while (rs.next()){
            News news = new News();
            news.setNewsid(rs.getInt("newsid"));
            news.setCategory(rs.getString("category"));
            news.setTitle(rs.getString("title"));
            news.setContents(rs.getString("contents"));
            news.setAuthor(rs.getString("author"));
            news.setNewsdate(rs.getDate("newsdate"));
            listNews.add(news);
        }
        return listNews;
    }
    public void GetNews(){}
}
