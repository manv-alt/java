import java.io.*;
import java.sql.*;

public class partb1 {
 public static void main(String[] args) throws Exception {
    DataInputStream db = new DataInputStream(System.in);
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet res;
    int ch,no,flag=0;
    String name,dob,address,stClass,course;
    try {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     con = DriverManager.getConnection("jdbc:odbc:studentdb","","");
    do{
        System.out.println("Menu");
        System.out.println("1. Add new Student");
        System.out.println("2. Delete a specified Student record");
        System.out.println("3. Update student adress specified Student record");
        System.out.println("4. Search for a particular student");
        System.out.println("5. exit");
        System.out.println("Enter your choice");
        ch = Integer.parseInt(db.readLine());   
        switch(ch){
            case 1:
            System.out.println("Enter student number");
            no=Integer.parseInt(db.readLine());
            System.out.println("Enter student name");
            name=db.readLine();
            System.out.println("Enter student dob");
            dob=db.readLine();
            System.out.println("Enter student address");
            address=db.readLine();
            System.out.println("Enter student class");
            stClass=db.readLine();
            System.out.println("Enter student course");
            course=db.readLine();
            ps = con.prepareStatement("insert into student values(?,?,?,?,?)");
            ps.setInt(1,no);
            ps.setString(2,name);
            ps.setString(3,dob);
            ps.setString(4,address);
            ps.setString(5,stClass);
            ps.setString(6,course);
            ps.executeUpdate();
            System.out.println("Record is added");
            break;
            case 2:
            System.out.println("Enter the student number to be delete");
            no=Integer.parseInt(db.readLine());
            ps = con.prepareStatement("DELETE FROM student WHERE StRegNo = ?");
            ps.setInt(1,no);
            int deletdRows = ps.executeUpdate();
            if(deletdRows>0){
                System.out.println("Record is deleted");
            }
            else{
                System.out.println("No such student number");
            }
            break;
            case 3:
            System.out.println("Enter the student number to update address");
             no =Integer.parseInt(db.readLine());
             System.out.println("Enter the new address");
             address=db.readLine();
             ps = con.prepareStatement("UPDATE student SET StAddress = ? WHERE StRegNo = ?");
             ps.setString(1,address);
             ps.setInt(2,no);
             int updatedRows = ps.executeUpdate();
             if(updatedRows>0){
                System.out.println("Address updated sucessfully");
                }
                else{
                    System.out.println("No such student number");
                    }
                    break;
            case 4:
            System.out.println("Enter the student number to search");
            no=Integer.parseInt(db.readLine());
            ps = con.prepareStatement("SELECT * FROM student WHERE StRegNo = ?");
            ps.setInt(1,no);
            res = ps.executeQuery();
            if(res.next()){
                flag =1;
                System.out.println("StRegno: "+res.getInt(1));
                System.out.println("StName: "+res.getString(2));
                System.out.println("StDob: "+res.getString(3));
                System.out.println("StAddress: "+res.getString(4));
                System.out.println("StClass: "+res.getString(5));
                System.out.println("StCourse: "+res.getString(6));
            }
            if(flag==0){
                System.out.println("No record found");
            }
            break;
        case 5:
        System.out.println("exiting");
        break;
        default:
        System.out.println("Invalid choice");
        break;
        }
        } 
    while (ch!=5);
        con.close();
        
    
 }catch(IOException | SQLException e) {
    e.printStackTrace();
}
}
}
