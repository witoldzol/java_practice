import java.util.stream.IntStream;

public class AddDivisors {
  public static void main(String[] args) {
    int n = 116;
    int result = IntStream.rangeClosed(1,n/2).filter(i->n%i==0).sum()+n;
    System.out.println(result);
  }
}
