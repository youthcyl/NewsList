package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SqlHelper {
    private static Connection  getCoonection()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=Education",
                    "sa",
                    "123456cyl");

            return conn;
        }

        catch(Exception e)
        {
            e.printStackTrace();
            System.out.print("----------------连接失败");
        }
        return null;
    }
    //select
    public static ResultSet  executeQuery(String SQL)
    {
        try

        {

            Connection conn=getCoonection();
            System.out.println("---------------连接数据库成功");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            return  rs;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.print("----------------查询失败");
        }
        return null;
    }
    //insert update delete
    public static boolean  executeUpdate(String SQL)
    {
        try
        {
            Connection conn=getCoonection();
            System.out.println("---------------连接数据库成功");

            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(SQL);
            if(result>0)
                return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.print("----------------更新失败");
        }
        return false;
    }
}
