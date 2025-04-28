import java.util.Scanner;
public class studentcontroller {
    private student model;
    private studentview view;
    
    public studentcontroller(student model, studentview view) {
        this.model = model;
        this.view = view;
    }  
    
    public void setStudentDetails(String rollNo, String name, double marks1, double marks2, double marks3) {
        model.setRollNo(rollNo);
        model.setName(name);
        model.setMarks1(marks1);
        model.setMarks2(marks2);
        model.setMarks3(marks3);
    }
    
    public void calculateResultAndGrade() {
        model.calculateResultAndGrade();
    }
    
    public void displayStudentDetails() {
        view.displayStudentDetails(model);
    }
}