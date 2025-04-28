import java.util.*;

public class menulist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> linkedlist = new LinkedList<>();
        System.out.println("Enter values for the linked list(entere -1 to stop):");
        int value;
        while ((value = sc.nextInt()) != -1) {
            linkedlist.add(value);
        }
        while (true) {
            System.out.println("\n Menu:");
            System.out.println("a. Insert Elemnsts at specified Postion");
            System.out.println("b. swp two Elemnsts ");
            System.out.println("c. IterateLinkedList in Reverse Order");
            System.out.println("d. compare two linkedList");
            System.out.println("e. Convert linkedlist to arraylist");
            System.out.println("f. Exit");
            System.out.println("Enter your choice");
            char choice = sc.next().charAt(0);
            switch (choice) {
                case 'a':
                    insertElements(linkedlist, sc);
                    break;
                case 'b':
                    swapElements(linkedlist, sc);
                    break;
                case 'c':
                    iterateReverse(linkedlist);
                    break;
                case 'd':
                    compareLinkedList(linkedlist, sc);
                    break;
                case 'e':
                convertToArrayList(linkedlist);
                    break;
                case 'f':
                    System.out.println("Exiting program....");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter valid option.");
            }

        }

    }

    public static void insertElements(LinkedList<Integer> list, Scanner sc) {
        System.out.println("Enter the position to insert ");
        int position = sc.nextInt();
        System.out.println("Enter the elemnt to insert ");
        int element = sc.nextInt();
        list.add(position, element);
        System.out.println("Element inserted at position " + position);
        System.out.println("Updated LinkedList:" + list);
    }

    public static void swapElements(LinkedList<Integer> list, Scanner sc) {
        System.out.println("Enter the indices of the element to swap(separted by space):");
        int index1 = sc.nextInt();
        int index2 = sc.nextInt();
        Collections.swap(list, index1, index2);
        System.out.println("Elements swapped sucessfully");
        System.out.println("Updated LinkedList:" + list);
    }

    public static void iterateReverse(LinkedList<Integer> list) {
        System.out.println("  LinkedList elemnts in reverse order:");
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }

        System.out.println();
    }

    public static void compareLinkedList(LinkedList<Integer> list, Scanner sc) {
        LinkedList<Integer> secondList = new LinkedList<Integer>();
        System.out.println("Enter the value for the second LinkedList(enter -1 to stop):");
        int value;
        while ((value = sc.nextInt()) != -1) {
            secondList.add(value);
        }
        boolean isEqual = list.equals(secondList);
        System.out.println("The  LinkedList  are  " + (isEqual ? "equal." : "not equal."));
    }
    public static void  convertToArrayList(LinkedList<Integer> list){
        ArrayList<Integer> list1=new ArrayList<Integer>(list);
        System.out.println("linked list convert to ArrayList: "+list1);

    }
    

}
