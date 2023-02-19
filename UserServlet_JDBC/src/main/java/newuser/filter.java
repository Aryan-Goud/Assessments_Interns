package newuser;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class filter implements Filter {
    public Connection connect;

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        connectionjdbc cj=new connectionjdbc();
        connect=cj.setConnection();
        PrintWriter wr=servletResponse.getWriter();
        String que = "Select * from Users";
        Statement statement = null;
        String name = servletRequest.getParameter("name");
        int f=1;
        try {
            statement = connect.createStatement();
            ResultSet result = statement.executeQuery(que);
            while (result.next()) {
                String username = result.getString(1);
                if (username.equals(name)) {
                    f=0;
                    wr.println("<html><head><title>Users details</title></head><body>");
                    String found = "Username is " + username + " already found!!!";
                    wr.println("<h3 style=\"color:red; text-align:center; margin-top:200px;\" >" + found + "</h3>");
                    wr.println("</body></html>");
                    break;
                }
            }
            if (f==1){
                filterChain.doFilter(servletRequest,servletResponse);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {

    }
}
