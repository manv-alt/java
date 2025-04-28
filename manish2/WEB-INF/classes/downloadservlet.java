import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class downloadservlet extends HttpServlet{

    public void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        String filename ="good.txt";
        String filepath = "C:\\Users\\ASUS\\OneDrive\\Documents\\";
         response.setContentType("APPLICATION/OCTET-STREAM");
         response.setHeader("ContentDisposition","attachment; filename=\""+filename+"\" ");
         FileInputStream fileInputStream = new FileInputStream(filepath + filename);
         int i;
         while((i=fileInputStream.read())!=-1)
         {
            out.write(i);
            }
            fileInputStream.close();
            out.close();

}
}