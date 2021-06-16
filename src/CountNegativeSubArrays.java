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
    List<Integer> subArraySizes = new ArrayList<>();
    // create list of valid sub array sizes
    subArraySizes.add(1);
    for(int i=2; i<=maxSizeOfSubArray; i++){
      if(arr.length%i == 0) subArraySizes.add(i);
    }
    subArraySizes.add(arr.length);

    int negativeSubArrays = 0;
    subArraySizes.forEach(subArrSize -> {
      System.out.println(subArrSize);
    });
    //System.out.println(negativeSubArrays);
  }

  private static int countNegativeSubArrays(int[] arr, int subArraySize){
    int negativeCount = 0;
    //[1,2, 3,4,  5,6]
    for(int i=0;i<arr.length - subArraySize;i+=subArraySize){
      int sum = 0;
      for(int k=0;k<subArraySize;k++){
        sum += arr[i+k];
      }
      if(sum<0) negativeCount++;
    }
    return negativeCount;
  }
}
