import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import java.util.Random;

/**
 * Tests of Sorter objects.
 *
 * @author Keely Miyamoto
 * @author Samuel Rebelsky
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

  /**
   * This test generates of an Integer array of a random length in the interval [0, 10000]
   * and in which each element is a randomly generated Integer in the interval [0, 10000].
   */
  @Test
  public void testWithRand() {
    Integer[] arr = makeArray();
    sorter.sort(arr, (x,y) -> x.compareTo(y));
    assertTrue(isSorted(arr));
  } // testWithRand

  // +---------------------------+---------------------------
  // | Utils for Testing Arrays |
  // +--------------------------+

  // Define max size and max element value 
  private static int MAX_ARRAY_SIZE = 10000;
  private static int MAX_ARRAY_VALUE = 10000;

  /**
   * Method to generate array of random size and with random Integer elements
   * @return Integer[] ret
   */
  private static Integer[] makeArray() {
    // Initialize rand
    Random rand = new Random();

    // Define array size
    int size = rand.nextInt(MAX_ARRAY_SIZE);
    // Declare array of 'size'
    Integer[] ret = new Integer[size];

    // Initialize array with random Integers
    for (int i = 0; i < size; i++) {
      ret[i] = rand.nextInt(MAX_ARRAY_VALUE);
    } // for
    return ret;
  } // makeArray()

  /**
   * Method to check if an Integer array is sorted
   * @param arr (an array of Integers)
   * @return true if array is sorted, false otherwise.
   */
  private static boolean isSorted(Integer[] arr) {
    // For each non-last index in the array
    for (int i = 0; i < arr.length - 1; i++) {
      // Check if element index is greater than next element
      if (arr[i] > arr[i + 1]) {
        // If so, return false.
        return false;
      } // if
    } // for
    return true;
  } // isSorted(arr)

} // class SortTester
