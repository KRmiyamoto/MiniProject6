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
   * This test generates of an Integer array of a random length in the interval [0, 10000].
   * The array is initially sorted, and copy is made. The array is then mixed up (using 'swap').
   * After sort is applied, the newly sorted 'arr' is compared to its originally sorted 'copy'.
   */
  @Test
  public void testWithRand() {
    Integer[] arr = makeSortedArray();
    Integer[] copy = arr.clone();
    mixArr(arr);
    sorter.sort(arr, (x,y) -> x.compareTo(y));
    assertArrayEquals(arr, copy);
  } // testWithRand

  // +---------------------------+---------------------------
  // | Utils for Testing Arrays |
  // +--------------------------+

  // Define max size and max element value 
  private static int MAX_ARRAY_SIZE = 10000;

  /**
   * Method to generate a sorted array of random size
   * @return Integer[] ret
   */
  private static Integer[] makeSortedArray() {
    // Initialize rand
    Random rand = new Random();

    // Define array size
    int size = rand.nextInt(MAX_ARRAY_SIZE);

    // Declare array of 'size'
    Integer[] ret = new Integer[size];

    // Initialize array (note that array is sorted 
    // since ret[i] < ret[i+1] for all 0 <= i < ret.length - 2)
    for (int i = 0; i < size; i++) {
      ret[i] = i;
    } // for
    return ret;
  } // makeArray()

  /**
   * Method to mix up a sorted array
   * @param arr (an array of Integers)
   */
  private static void mixArr(Integer[] arr) {
    // Initialize rand
    Random rand = new Random();
    // For each non-last index in the array
    for (int i = 0; i < arr.length - 1; i++) {
      // Swap each index with an element at a random index
      Quicksort.swap(arr, i, rand.nextInt(arr.length - 1));
    } // for
  } // mixArr(arr)

} // class SortTester
