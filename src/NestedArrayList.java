import java.io.*;
import java.util.*;

public class NestedArrayList {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int rows = scanner.nextInt();
    List<ArrayList<Integer>> list = new ArrayList<>();
    for(int i=0;i<rows;i++){
      int rowSize = scanner.nextInt();

      ArrayList<Integer> row = new ArrayList<>();
      //insert values into row
      for(int j=0;j<rowSize;j++){
        int number = scanner.nextInt();
        row.add(number);
      }
      //add row to list
      list.add(row);
    }

    int numberOfQueries = scanner.nextInt();
    for(int i=0;i<numberOfQueries;i++){
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      resolveQuery(list,x-1,y-1);
    }
  }

  private static void resolveQuery(List<ArrayList<Integer>> list, int x, int y){
    try {
      System.out.println(list.get(x).get(y));
    } catch (Exception e){
      System.out.println("ERROR!");
    }
  }
}
