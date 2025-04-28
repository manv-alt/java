package program;
public class swapandtoogle {
    public static void main(String[] var0) {
       String input = "Good Morning everyone";
       String[] words = input.split(" ");
       StringBuilder output1 = new StringBuilder();
       StringBuilder output2 = new StringBuilder();
        
       for(String word : words) {
          
          if (word.length() % 2 == 0) {
             StringBuilder swappedWord = new StringBuilder();
 
             for(int i = 0; i< word.length(); i += 2) {
                swappedWord.append(word.charAt(i+ 1));
                swappedWord.append(word.charAt(i));
             }
 
             output1.append(swappedWord).append(" ");
          }
 
         for(char c:word.toCharArray()){
 
           
             if (Character.isLowerCase(c)) {
                output2.append(Character.toUpperCase(c));
             } else {
                output2.append(Character.toLowerCase(c));
             }
          }
 
          output2.append("");
       }
 
       System.out.println("output1:" + output1.toString().trim());
       System.out.println("output2:" + output2.toString().trim());
    }
 }
 