import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

  @Test
  public void returnsStringWithoutDuplicates() {
    String s = "dog dog likes to to run after after cats";
    String expected = "dog likes to run after cats";
    String withoutDuplicates = RemoveDuplicates.removeDuplicates(s);
    System.out.println("result " + withoutDuplicates);
    assert (withoutDuplicates).equals(expected);
  }
}
