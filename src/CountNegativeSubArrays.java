import java.io.*;
import java.util.*;
public class CountNegativeSubArrays {
  // three nested loops
  // first defines starting point
  // second defines end point ( inclusive )
  // last one iterates from start to end point & sums up values
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int arraySize = scanner.nextInt();
    int[] arr = new int[arraySize];
    for(int i=0;i<arraySize;i++){
      arr[i]=scanner.nextInt();
    }
    int negativeSubarray = 0;
    //start
    for(int i=0; i<arr.length; i++){
      //end
      for(int k=i; k<arr.length;k++){
        int sum = 0;
        for(int j=i; j<=k;j++){
          sum += arr[j];
        }
        if (sum < 0) negativeSubarray++;
      }
    }
    System.out.println(negativeSubarray);
  }
}
