import java.util.*;

public class Solution {

  public static boolean canWin(int leap, int[] game) {
    int l = game.length;
    if(leap>=l) return true;
    int curr = 0;
    //go as far as you can by one space
    for(int i=1;i<l;i++){
      if(game[leap])
        if(game[i] == 0) curr = i;
        else break
    }

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
