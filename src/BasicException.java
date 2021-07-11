import java.util.Scanner;

public class BasicException {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      System.out.println(x/y);
    } catch (ArithmeticException e){
      System.out.println(e.getClass().getCanonicalName() + ": / by zero");
    } catch (Exception e){
      System.out.println(e.getClass().getCanonicalName());
    }
  }
}
