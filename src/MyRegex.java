import java.util.Scanner;

class Solution{

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    while(in.hasNext()){
      String IP = in.next();
      System.out.println(IP.matches(new MyRegex().pattern));
    }

  }
}
class MyRegex {
  //0-99 \\d{1,2}
  //099 - 199 (0|1)\\{2}
  //249 2[0-4]\\d
  //255 25[0-5]
  String pattern = "((\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])(\\.|$)){4}";
}
