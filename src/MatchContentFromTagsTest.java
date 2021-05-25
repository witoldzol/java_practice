import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchContentFromTagsTest {

  @Test
  public void printsInnerText() {
    String[] inputs = new String[]{"<h1>Nayeem loves counseling</h1>",
            "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>",
            "<Amee>safat codes like a ninja</amee>",
            "<SA premium>Imtiaz has a secret crush</SA premium>"
    };
    MatchContentFromTags classUnderTest = new MatchContentFromTags();
    List<String> result = classUnderTest.printInnerText(inputs);
    List<String> expected = new ArrayList<>(Arrays.asList("Nayeem loves counseling",
            "Sanjay has no watch",
            "So wait for a while",
            "None",
            "Imtiaz has a secret crush"
    ));
    assertEquals(expected, result);
  }
}
