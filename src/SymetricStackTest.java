import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymetricStackTest {

  @Test
  public void returnsTrueWhenSymmetric(){
    String input = "{}()[]";
    SymetricStack stack = new SymetricStack();
    boolean result = stack.solve(input);
    assertEquals(result, true);
  }

  @Test
  public void returnsFalseWhenNotSymmetric(){
   String input = "{([(]))}";
    SymetricStack stack = new SymetricStack();
    boolean result = stack.solve(input);
    assertEquals(result, false);
  }

}
