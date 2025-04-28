import java.io.DataInputStream;
import java.io.IOException;
public class studentapp {
    public static void main(String[] args) {
        student model = new student();
        studentview view = new studentview();
        studentcontroller controller = new studentcontroller(model, view);
        DataInputStream db = new DataInputStream(System.in);
        try {
            System.out.println("Enter Roll Number:");
            String rollNo = db.readLine();
            System.out.println("Enter Name:");
            String name = db.readLine();
            System.out.println("Enter Marks in Subject 1:");
            double marks1 = Double.parseDouble(db.readLine());
            System.out.println("Enter Marks in Subject 2:");
            double marks2 = Double.parseDouble(db.readLine());
            System.out.println("Enter Marks in Subject 3:");
            double marks3 = Double.parseDouble(db.readLine());
            controller.setStudentDetails(rollNo, name, marks1, marks2, marks3);
            controller.calculateResultAndGrade();
            controller.displayStudentDetails();
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }
}