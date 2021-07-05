import java.io.*;
import java.util.*;
interface PerformOperation {
  boolean check(int a);
}
class MyMath {
  public static boolean checker(PerformOperation p, int num) {
    return p.check(num);
  }

  PerformOperation isOdd(){ return  (int a) -> a%2!=0; }
  PerformOperation isPrime(){ return (int a) -> isNumberPrime(a); }
  PerformOperation isPalindrome() { return (int a) -> isNumberPalindrome(a);}

  private boolean isNumberPalindrome(int a){
    String str = Integer.toString(a);
    int middle = (int) str.length()/2;
    char[] numbers = str.toCharArray();
    for(int i=0;i<middle;i++){
      if(numbers[i] != numbers[numbers.length -1 -i]){
        return false;
      }
    }
    return true;
  }
  private boolean isNumberPrime(int a){
    //no need to check past sq root of number
    int squareRoot = (int) Math.sqrt(a)+1;
    for(int i=2; i<squareRoot;i++){
      if(a%i==0){
        return false;
      }
    }
    return true;
  }
}


class LambdaOne {

  public static void main(String[] args) throws IOException {
    MyMath ob = new MyMath();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    PerformOperation op;
    boolean ret = false;
    String ans = null;
    while (T--> 0) {
      String s = br.readLine().trim();
      StringTokenizer st = new StringTokenizer(s);
      int ch = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());
      if (ch == 1) {
        op = ob.isOdd();
        ret = ob.checker(op, num);
        ans = (ret) ? "ODD" : "EVEN";
      } else if (ch == 2) {
        op = ob.isPrime();
        ret = ob.checker(op, num);
        ans = (ret) ? "PRIME" : "COMPOSITE";
      } else if (ch == 3) {
        op = ob.isPalindrome();
        ret = ob.checker(op, num);
        ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

      }
      System.out.println(ans);
    }
  }
}
