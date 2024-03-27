import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Keely Miyamoto
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void unorderedStringTest() {
    String[] original = {"bravo", "delta", "foxtrot", "charlie", "alpha"};
    String[] expected = {"alpha", "bravo", "charlie", "delta", "foxtrot"};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // emptyStringArrayTest

  @Test
  public void emptyStringArrayTest() {
    String[] original = {};
    String[] expected = {};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // emptyStringArrayTest

  @Test
  public void singleEltArrayTest() {
    String[] original = {"alpha"};
    String[] expected = {"alpha"};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // singleEltArrayTest

  @Test
  public void arrayWithDuplicatesTest() {
    String[] original = {"foxtrot", "alpha", "foxtrot", "bravo", "bravo", "charlie", "alpha", "delta"};
    String[] expected = {"alpha", "alpha", "bravo", "bravo", "charlie", "delta", "foxtrot", "foxtrot"};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // arrayWithDuplicatesTest

  @Test
  public void equalEltsIntegerArrayText() {
    Integer[] original = {1, 1, 1, 1};
    Integer[] expected = {1, 1, 1, 1};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // arrayWithDuplicatesTest

} // class SortTester
