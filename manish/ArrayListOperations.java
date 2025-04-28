import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int choice;
        do {
            System.out.println("1.ADD ELEMENT");
            System.out.println("2.SORT ELEMENT");
            System.out.println("3.REPLACE AN ELEMENT");
            System.out.println("4.REMOVE AN ELEMENT");
            System.out.println("5.DISPLAY ALL ELEMENTS");
            System.out.println("6.ADD AN ELEMENT BETWEEN TWO ELEMENTS");
            System.out.println("7.EXIT");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("ENTER ELEMENT TO ADD: ");
                    int elementToADD = scanner.nextInt();
                    arrayList.add(elementToADD);
                    System.out.println("ELEMENT ADDED SUCCESFULLY");
                    break;
                case 2:  
                    Collections.sort(arrayList);
                    System.out.println("ELEMENTS ARE SORTED SUCCESFULLY");
                    break;
                case 3:
                    System.out.print("ENTER INDEX TO REPLACE ");
                    int indexToReplace = scanner.nextInt();
                    if (indexToReplace >= 0 && indexToReplace < arrayList.size()) {
                        System.out.print("ENTER NEW ELEMENT ");
                        int newElement = scanner.nextInt();
                        arrayList.set(indexToReplace, newElement);
                        System.out.println("ELEMENT REPLACED SUCCESFULLY");
                    } else {
                        System.out.println("INVALID INDEX");
                    }
                    break;
                case 4:
                    System.out.print("ENTER INDEX TO REMOVE ");
                    int indexToRemove = scanner.nextInt();
                    if (indexToRemove >= 0 && indexToRemove < arrayList.size()) {
                        arrayList.remove(indexToRemove);
                        System.out.println("ELEMENT REMOVED SUCCESFULLY");
                    } else {
                        System.out.println("INVALID INDEX");
                    }
                    break;
                case 5:
                    System.out.println("ELEMENTS ARE:");
                    for (int element : arrayList) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.print("ENTER INDEX TO INSERT AFTER: ");
                    int indexToInsertAfter = scanner.nextInt();
                    if (indexToInsertAfter >= 0 && indexToInsertAfter <= arrayList.size()) {
                        System.out.print("ENTER ELEMENT TO INSERT: ");
                        int elementToInsert = scanner.nextInt();
                        arrayList.add(indexToInsertAfter + 1, elementToInsert);
                        System.out.println("ELEMENT ADDED SUCCESFULLY");
                    } else {
                        System.out.println("INVALID INDEX");
                    }
                    break;
                case 7:
                    System.out.println("EXITING.......");
                    break;
                default:
                    System.out.println("INVALID CHOICE PLEASE ENTER A NUMBER BETWEEN 1 TO 7");
            }
        } while (choice != 7);
        scanner.close();
    }
}




































 