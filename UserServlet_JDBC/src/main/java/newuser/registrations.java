package newuser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registrations extends HttpServlet{
    public Connection connect;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String s3=req.getParameter("registers");
            connectionjdbc cj=new connectionjdbc();
            connect=cj.setConnection();
            String name = req.getParameter("name");
            String password = req.getParameter("pass");
            String op = req.getParameter("sub");
            if (op.equals("submit")) {
                String query = "INSERT INTO Users(username,userpass) " + "VALUES(?,?)";
                PreparedStatement pstmt = null;
                try {
                    pstmt = connect.prepareStatement(query);
                    pstmt.setString(1, name);
                    pstmt.setString(2, password);
                    pstmt.executeUpdate();
                    RequestDispatcher requestDispatchers = req.getRequestDispatcher("useradded.html");
                    requestDispatchers.forward(req, resp);

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

    }
}
