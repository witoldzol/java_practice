import java.util.*;

public class DequeUnique {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Deque<Integer> deque = new ArrayDeque<>();
    Set<Integer> occurances = new HashSet<>();
    int n = in.nextInt();
    int m = in.nextInt();
    int max = 0;

    for (int i = 0; i < n; i++) {
      int num = in.nextInt();
      deque.add(num);
      occurances.add(num);
      if (max == m) break;

      if (deque.size() == m) {
        if (occurances.size() > max) max = occurances.size();
        int first = deque.remove();
        if (!deque.contains(first)) occurances.remove(first);
      }
    }
    System.out.println(max);
  }
}
