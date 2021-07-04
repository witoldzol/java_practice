import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicList {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    List<Integer> list = new ArrayList<>();
    //get values
    for (int i = 0; i < n; i++) {
      list.add(i, scanner.nextInt());
    }
    //get number of queries
    int q = scanner.nextInt();
    for (int i = 0; i < q; i++) {
      scanner.nextLine();
      String operation = scanner.nextLine();
      int x = scanner.nextInt();
      if (operation.equals("Insert")) {
        int y = scanner.nextInt();
        list.add(x, y);
      } else {
        list.remove(x);
      }
    }
    list.forEach(x -> System.out.print(x + " "));
  }
}
