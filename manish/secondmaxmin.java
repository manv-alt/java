import java.util.*;
public class secondmaxmin {

    public static void main(String[] args) {
        Integer[]number={5,2,8,1,9,3,7,4,6};
        List<Integer>numberList =Arrays.asList(number);
        Collections.sort(numberList);
        Integer secondMin =numberList.get(1);
        Integer secondMax =numberList.get(numberList.size()-2);
        System.out.println("Second minimum"+secondMin);
        System.out.println("Second minimum"+secondMax);
    }
}