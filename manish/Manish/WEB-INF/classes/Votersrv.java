import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Votersrv extends HttpServlet{

    public void  service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        String name= req.getParameter("name");
        int age=Integer.parseInt(req.getParameter("age"));
        if(age>=18)
        {   
        pw.println("<font color='green' size='4'>"+name+"You are eligible to vote</font>");
    }
        else
        pw.println("<font color='red' size='4'>"+name+"You are not eligible to vote</font>");
        pw.println("<br><br><a href='index.html'>home</a>");
        pw.close();
}
}