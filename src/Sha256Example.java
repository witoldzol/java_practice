import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Sha256Example {
  public static void main(String[] args) throws NoSuchAlgorithmException {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    MessageDigest md = MessageDigest.getInstance("SHA-256");
    md.update(input.getBytes());
    byte[] digest = md.digest();
    for (byte b : digest) {
      System.out.format("%02x", b);
    }
  }
}
