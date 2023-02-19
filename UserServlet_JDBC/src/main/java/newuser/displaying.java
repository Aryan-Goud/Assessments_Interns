package newuser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class displaying extends HttpServlet {
    public Connection connect;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        connectionjdbc cj=new connectionjdbc();
        connect=cj.setConnection();
        PrintWriter wr = resp.getWriter();
        String que = "Select * from Users";
        Statement statement = null;
        try {
            statement = connect.createStatement();
            ResultSet result = statement.executeQuery(que);
            wr.println("<html><head><title>Users details</title></head><body>");
            while (result.next()) {
                String username = result.getString(1);
                String userpassword = result.getString(2);
                String details = "User name is " + username + " and password is " + userpassword;
                wr.println("<h3>" + details + "</h3>");

            }
            wr.println("</body></html>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

