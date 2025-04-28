<%@ page language="java" contentType="text/html;"%>

<html>
    <head>
        
        <title>Fibonacci and prime numbers</title>
    </head                              >
    <body>
        <h2>First 10 fibonacci numbers:</h2>
        <%
        int n1=0,n2=1,n3,count=10;
        out.print(n1+ " " +n2);
        for(int i=2; i<count;++i){
            n3=n1+n2;
            out.print(" " +n3);
            n1=n2;
            n2=n3;
        }
        %>
        <br><br>
        <h2>First 10 prime numbers:</h2>
        <%
        int num=2;
        int primeCount=0;
        while(primeCount<10){
            boolean isPrime=true;
            for(int i=2; i<= Math.sqrt(num); i++){
                if(num % i==0) {
                    isPrime=false;
                    break;
                }
            }
            if(isPrime) {
                out.print(num+" ");
                primeCount++;
            }
            num++;
        }
        %>
    </body>
</html>