package cal;
import javax.servlet.http.HttpServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Calci extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter wr=resp.getWriter();
        String s = null;
        Float f1=Float.parseFloat(req.getParameter("txt1"));
        Float f2=Float.parseFloat(req.getParameter("txt2"));
        String op=req.getParameter("a");
//        Integer result=0;
        if (op.equals("+")){
//            result=f1+f2;
//            wr.println("Addition: "+(f1+f2));
            s="Addition of "+f1+"+"+f2+" is: "+(f1+f2);
        }
        else if (op.equals("-")){
//            wr.println("substract: "+(f1-f2));
            s="substract of "+f1+"-"+f2+" is: "+(f1-f2);
        }
        else if (op.equals("x")){
//            wr.println("Addition: "+(f1*f2));
            s="multiply of "+f1+"x"+f2+" is: "+(f1*f2);
        }
        else if (op.equals("/")){
            if (f1==0){
                wr.println("Can't be divided by 0");
            }
            else {
//            wr.println("Addition: "+(f1/f2));
                s = "divide of " + f1 + "/" + f2 + " is: " + (f1 / f2);
            }
        }

//        wr.println("<html><head><title>calculating 2 numbers</title></head><body>");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
        requestDispatcher.include(req,resp);
        wr.println("<h2>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;" +
                "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+s+"</h2>");
        wr.println("</body></html>");
        wr.close();
    }
}
