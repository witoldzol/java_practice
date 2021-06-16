import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int arraySize = scanner.nextInt();
    int[] arr = new int[arraySize];
    for(int i=0;i<arraySize;i++){
      arr[i]=scanner.nextInt();
    }

    int maxSizeOfSubArray = (int) arraySize/2;
    int negativeSubArrays = 0;

    for(int i=1;i<=maxSizeOfSubArray;i++){
      negativeSubArrays += countNegativeSubArrays(arr,i);
    }

    System.out.println(negativeSubArrays);
  }

  private static int countNegativeSubArrays(int[] arr, int subArraySize){
    int negativeCount = 0;
    for(int i=0;i<arr.length;i+=subArraySize){
      int sum = 0;
      for(int k=0;k<subArraySize;k++){
        sum += arr[i+k];
      }
      if(sum<0) negativeCount++;
    }
    return negativeCount;
  }
}
