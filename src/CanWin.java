import java.util.*;

public class CanWin {
  public static boolean canWin(int leap, int[] game) {
    int l = game.length;
    if(leap>=l) return true;

    int counter = 0;
    int max = 0;

    for(int i=1;i<l;i++){
      if(game[i] == 1) counter++;
      else counter = 0;
      if(counter>max) max = counter;
    }
    return leap>max;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int q = scan.nextInt();
    while (q-- > 0) {
      int n = scan.nextInt();
      int leap = scan.nextInt();

      int[] game = new int[n];
      for (int i = 0; i < n; i++) {
        game[i] = scan.nextInt();
      }

      System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
    }
    scan.close();
  }
}
