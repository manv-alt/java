import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class EditServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:\\Program Files (x86)\\Apache Software Foundation\\Tomcat 8.5\\webapps\\Employee\\EmployeeDb.accdb";
    private static final String DB_USER = " ";
    private static final String DB_PASSWORD = " ";
    private static final String TABLE_NAME = "Employee";
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");
        displayEditForm(out, name);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        updateEmployee(name, password, email, country);
        res.sendRedirect("ViewServlet");
    }
    
    private void displayEditForm(PrintWriter out, String name) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "SELECT * FROM " + TABLE_NAME + " WHERE Name=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                out.println("<html><head><title>Edit Employee</title></head><body>");
                out.println("<h1>Edit Employee</h1>");
                out.println("<form action='EditServlet' method='post'>");
                out.println("Name: <input type='text' name='name' value='" + rs.getString("Name") + "' ><br>");
                out.println("Password: <input type='password' name='password' value='" + rs.getString("Password") + "'><br>");
                out.println("Email: <input type='email' name='email' value='" + rs.getString("Email") + "'><br>");
                out.println("Country: <input type='text' name='country' value='" + rs.getString("Country") + "'><br>");
                out.println("<input type='submit' value='Save'>");
                out.println("</form>");
                out.println("</body></html>");
            } else {
                out.println("Employee not found!");
            }
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
    
    private void updateEmployee(String name, String password, String email, String country) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "UPDATE " + TABLE_NAME + " SET Password=?, Email=?, Country=? WHERE Name=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, password);
            stmt.setString(2, email);
            stmt.setString(3, country);
            stmt.setString(4, name);
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
