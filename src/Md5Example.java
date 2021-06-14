import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.security.MessageDigest;

public class Md5Example {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(input.getBytes());
    byte[] digest = md.digest();

    for( byte b: digest){
      System.out.format("%02x", b);
    }
  }
}
