import java.sql.*;

/**
 * Created by Administrator on 2018/5/8.
 */
public class Test1
{

    public static void main(String[] args)
    {
        //1.加载数据库驱动到内存
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        //2.获取数据库连接
        Connection conn = null;
        PreparedStatement ps = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/neuedu", "root", "root");
            System.out.println(conn);
            //3.创建preparedstatement
            ps = conn.prepareStatement("insert into sorder values(null,?,?,?,?,?,?,?,?)");
            ps.setInt(1,1);
            ps.setString(2, "openididididdsfsdafa");
            ps.setDouble(3,1000.01);
            ps.setString(4,null);
            ps.setDouble(5,1000.01);
            ps.setString(6,"A");
            //java.sql.date()
            //时间原点：1970年1月1日 0点0分0秒
            Timestamp now = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(7,now);
            ps.setInt(8,1);
            ps.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
