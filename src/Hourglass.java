import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Hourglass {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    List<List<Integer>> arr = new ArrayList<>();

    IntStream.range(0, 6).forEach(i -> {
      try {
        arr.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < 4; i++) {
      for (int k = 0; k < 4; k++) {
        int result = calculateHourglas(i, k, arr);
        if (result > max) max = result;
      }
    }
    System.out.println(max);
  }

  private static int calculateHourglas(int x, int y, List<List<Integer>> arr) {
    int sum = arr.get(x).get(y) + arr.get(x).get(y + 1) + arr.get(x).get(y + 2) +
                                  arr.get(x + 1).get(y + 1) +
          arr.get(x + 2).get(y) + arr.get(x + 2).get(y + 1) + arr.get(x + 2).get(y + 2);
    return sum;
  }
}
