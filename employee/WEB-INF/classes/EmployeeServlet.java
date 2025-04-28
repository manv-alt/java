import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class EmployeeServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:\\Program Files (x86)\\Apache Software Foundation\\Tomcat 8.5\\webapps\\Employee\\EmployeeDb.accdb";
    private static final String DB_USER = " ";
    private static final String DB_PASSWORD = " ";
    private static final String TABLE_NAME = "Employee";
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Employee Management</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Employee Management</h1>");
        out.println("<h2>Add Employee</h2>");
        out.println("<form action='EmployeeServlet' method='post'>");
        out.println("Name: <input type='text' name='name'><br>");
        out.println("Password: <input type='password' name='password'><br>");
        out.println("Email: <input type='email' name='email'><br>");
        out.println("Country: <input type='text' name='country'><br>");
        out.println("<input type='submit' value='Save'>");
        out.println("</form>");
        out.println("<h2><a href='ViewServlet'>View Employees</a></h2>");
        out.println("</body>");
        out.println("</html>");
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        insertEmployee(name, password, email, country);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Employee Management</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Employee Added Successfully</h1>");
        out.println("<h2><a href='ViewServlet'>View Employees</a></h2>");
        out.println("</body>");
        out.println("</html>");
    }
    
    private void insertEmployee(String name, String password, String email, String country) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "INSERT INTO " + TABLE_NAME + " (Name, Password, Email, Country) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setString(4, country);
            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
