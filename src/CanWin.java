import java.util.*;

public class Solution {
  // go forward (i+1)
// go back (i -1)
// jump (i + leap)
  private static boolean canSolve(int leap, int[] game, int index){
    //is the current index valid
    if(index < 0 || game[index] == 1) return false;
    //are we at the edge
    if(index >= game.length-1) return true;
    //can we jump to or over the edge
    if(index + leap >= game.length-1) return true;

    //mark current index as 1 to avoid infinite loop
    game[index] = 1;

    return /* back */ canSolve(leap, game, index-1) ||
            /* walk */ canSolve(leap, game, index+1) ||
            /* jump */ canSolve(leap, game, index + leap);
  }

  public static boolean canWin(int leap, int[] game) {
    return canSolve(leap, game,0);
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
