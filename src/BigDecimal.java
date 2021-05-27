import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
  public static void main(String[] args) {
    //Input
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] s = new String[n + 2];
    for (int i = 0; i < n; i++) {
      s[i] = sc.next();
    }
    sc.close();

    //Write your code here
    BigDecimal[] arr = new BigDecimal[n];
    for (int i = 0; i < n; i++) {
      arr[i] = new BigDecimal(s[i]);
    }
    Arrays.sort(arr);

    for (int j = 0; j < n / 2; j++) {
      BigDecimal temp = arr[j];
      arr[j] = arr[arr.length - j - 1];
      arr[arr.length - j - 1] = temp;
    }
    for (BigDecimal b : arr) {
      System.out.println(b);
    }
    //Output
    for (int i = 0; i < n; i++) {
      System.out.println(s[i]);
    }
  }
}
