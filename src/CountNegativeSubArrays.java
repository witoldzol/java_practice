import java.util.Scanner;

public class CountNegativeSubArrays {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int arraySize = scanner.nextInt();
    int[] arr = new int[arraySize];
    for (int i = 0; i < arraySize; i++) {
      arr[i] = scanner.nextInt();
    }
    int count = 0;
    for (int start = 0; start < arr.length; start++) {
      int sum = 0;
      for (int end = start; end < arr.length; end++) {
        sum += arr[end];
        if (sum < 0) count++;
      }
    }
    System.out.println(count);
  }
}
