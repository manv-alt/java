public class studentview {
    public void displayStudentDetails(student student) {
        System.out.println("Student Details:");
        System.out.println("Roll Number: " + student.getRollNo());
        System.out.println("Name: " + student.getName());
        System.out.println("Marks in Subject 1: " + student.getMarks1());
        System.out.println("Marks in Subject 2: " + student.getMarks2());
        System.out.println("Marks in Subject 3: " + student.getMarks3());
        System.out.println("Percentage: " + student.getPercentage() + "%");
        System.out.println("Grade: " + student.getGrade());
    }
}