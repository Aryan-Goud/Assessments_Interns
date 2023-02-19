package newuser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionjdbc {
    public Connection setConnection() {
        String url = "jdbc:mysql://localhost:3306/Users";
        String user = "root";
        String pass = "aryan";
        Connection connection = null;


            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, pass);
                System.out.println("Connected");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        return connection;
    }

}

