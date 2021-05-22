import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

  @Test
  public void returnsStringWithoutDuplicates() {
    String s = "dog dog likes to to run after after cats";
    String expected = "dog likes to run after cats";
    String withoutDuplicates = RemoveDuplicates.removeDuplicates(s);
    assert (withoutDuplicates).equals(expected);
  }

  @Test
  public void matchNonConsequtiveWords(){
    String s = "dog dog cat dog cat";
    String expected = "dog cat dog cat";
    assertEquals(expected, RemoveDuplicates.removeDuplicates(s));
  }
}
