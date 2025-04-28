import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class ViewServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:\\Program Files (x86)\\Apache Software Foundation\\Tomcat 8.5\\webapps\\Employee\\EmployeeDb.accdb";
    private static final String DB_USER = " ";
    private static final String DB_PASSWORD = " ";
    private static final String TABLE_NAME = "Employee";
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        viewEmployees(out);
    }
    
    private void viewEmployees(PrintWriter out) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM " + TABLE_NAME;
            rs = stmt.executeQuery(sql);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>View Employees</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>View Employees</h1>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th></tr>");
            while (rs.next()) {
                String id = rs.getString("ID");
                String name = rs.getString("Name");
                String password = rs.getString("Password");
                String email = rs.getString("Email");
                String country = rs.getString("Country");
                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + password + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("<td>" + country + "</td>");
                out.println("<td><a href='EditServlet?name=" + name + "'>Edit</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("<td><a href='EmployeeServlet'>Home</a></td>");
            out.println("</html>");
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
