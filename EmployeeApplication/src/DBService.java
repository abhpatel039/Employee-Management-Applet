import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBService {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static String username = "root";
    private static String password = "abhi";
    Connection connection;
    public DBService()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public boolean deleteEmploy(Employ employ)
    {
        boolean b = false;
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where e_id = ?");
            preparedStatement.setInt(1,employ.getE_id());
            int x = preparedStatement.executeUpdate();
            if(x>0)
            {
                b= true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       return b;
    }
    public boolean addEmploy(Employ employ)
    {
        boolean b = false;
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?)");
            preparedStatement.setInt(1,employ.getE_id());
            preparedStatement.setString(2, employ.getName());
            preparedStatement.setString(3, employ.getPost());
            preparedStatement.setDouble(4,employ.getSalary());
            int x = preparedStatement.executeUpdate();
            if(x>0)
            {
                b= true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return b;
    }


    public boolean updateEmploy(Employ employ)
    {
        boolean b = false;
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("update employee set name = ?,post =?,salary=? where e_id=? ");
            preparedStatement.setInt(4,employ.getE_id());
            preparedStatement.setString(1, employ.getName());
            preparedStatement.setString(2, employ.getPost());
            preparedStatement.setDouble(3,employ.getSalary());
            int x = preparedStatement.executeUpdate();
            if(x>0)
            {
                b= true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return b;
    }

    public Employ searchEmploy(Employ employ)
    {

        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where e_id = ?");
            preparedStatement.setInt(1,employ.getE_id());
            ResultSet  resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                employ.setE_id(resultSet.getInt("e_id"));
                employ.setName(resultSet.getString("name"));
                employ.setPost(resultSet.getString("post"));
                employ.setSalary(resultSet.getDouble("salary"));
            }
            else
            {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employ;
    }


    public int numberOfEmploy(Employ employ)
    {

        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(" select count(e_id) from employee;");
            ResultSet  resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
             return(resultSet.getInt("count(e_id)"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }
}

