import java.util.*;
import java.io.*;
enum Units{
    ZERO(""),ONE("ONE"),TWO("TWO"),THREE("THREE"),FOUR("FOUR"),FIVE("FIVE"),SIX("SIX"),SEVEN("SEVEN"),EIGHT("EIGHT"),NINE("NINE");
    private String word;
    Units(String word){
        this.word=word;}
        public String getWord(){
            return word;
        }
        }

enum Teens{
    TEN("TEN"),ELEVEN("ELEVEN"),TWELVE("TWELVE"),THIRTEEN("THIRTEEN"),FOURTEEN("FOURTEEN"),FIFTEEN("FIFTEEN"),SIXTEEN("SIXTEEN"),SEVENTEEN("SEVENTEEN"),EIGHTEEN("EIGHTEEN"),NINETEEN("NINETEEN");
    private String word;
    Teens(String word){
        this.word=word;
}
public String getWord(){
    return word;
}
}
enum Tens{EMPTY(""),TEN(""),TWENTY("TWENTY"),THIRTY("THIRTY"),FORTY("FORTY"),FIFTYb ("FIFTY"),SIXTY("SIXTY"),SEVENTY("SEVENTY"),EIGHTY("EIGHTY"),NINETY("NINETY");
    private String word;
    
    Tens(String word){
        this.word=word;
}
public String getWord(){
    return word;
}
}
public class  NumberToWordsConvertor{
public static void main(String args[])throws Exception{
    DataInputStream db=new DataInputStream(System.in);

    System.out.println("Enter a no 0 to 99999");
    int number=Integer.parseInt(db.readLine());
    if(number<0|| number>99999){
        System.out.println("Plz enter number between 0 and 99999");
    }
    else{
        String words=convertToWords(number);
        System.out.println("Number in Words:" +words);
    }
}
private static String convertToWords(int number){
    if(number==0){
        return "ZERO";}
        String words="";
        int unitsPlace=number%10;
        int tensPlace=(number/10)%10;
        int hundredsPlace=(number/100)%10;
        int thousandPlace=number/1000;
       if(thousandPlace>0){
        int tup=(thousandPlace%10);
        int ttp=(thousandPlace/10)%10;
        if(ttp==1){
            words+=Teens.values()[tup].getWord();
        }
       else{
        words+=Tens.values()[ttp].getWord()+Units.values()[tup].getWord();
    }
words+="THOUSAND";
       }
       if(hundredsPlace>0){
        words+=Units.values()[hundredsPlace].getWord()+"HUNDRED";
       }
       if(tensPlace==1){
        words+=Teens.values()[unitsPlace].getWord();
       }
       else{
        words+=Tens.values()[tensPlace].getWord()+Units.values()[unitsPlace].getWord();
       }
       return words.trim();
        }
       } 
    


