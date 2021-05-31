import java.util.*;
import java.math.BigInteger;

public class AddBigIntegers {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String a  = scanner.nextLine();
    String b  = scanner.nextLine();

    BigInteger bi1 = new BigInteger(a);
    BigInteger bi2 = new BigInteger(b);

    System.out.println(bi1.add(bi2));
    System.out.println(bi1.multiply(bi2));
  }
}
