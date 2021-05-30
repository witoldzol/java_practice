import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;



public class ProbablePrime {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String n = bufferedReader.readLine();
    boolean isPrime = new BigInteger(n).isProbablePrime(1);
    if(isPrime) System.out.println("prime");
    else System.out.println("not prime");

    bufferedReader.close();
  }
}
