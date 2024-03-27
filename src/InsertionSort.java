import java.util.Comparator;
import java.util.*;

/**
 * Sort using insertion sort.
 *
 * @author Keely Miyamoto
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    // Compare each element in values to previous elements, beginning with index 1.
    for (int i = 1; i < values.length; i++) {
      // Save current (ith) element of values.
      T current = values[i];
      // Track the previous indexes, against which we will compare the current element.
      int comparingIndex = i - 1;
      // While comparingIndex is a valid index in values and current is less than the element at comparingIndex,
      // shift elements in values to the right.
      while ((comparingIndex >= 0) && (order.compare(values[comparingIndex], current) > 0)) {
        values[comparingIndex + 1] = values[comparingIndex];
        comparingIndex--;
      } // while
      // Associate current with its appropriate index.
      values[comparingIndex + 1] = current;
    } // for
  } // sort(T[], Comparator<? super T>

  public static void main(String[] args) {
    Sorter sorter = new InsertionSort();
    String[] arr = {};
    sorter.sort(arr, (x, y) -> x.compareTo(y));
    String[] arr0 = {"a"};
    sorter.sort(arr0, (x, y) -> x.compareTo(y));
    String[] arr1 = {"a", "b", "c", "d"};
    sorter.sort(arr1, (x, y) -> x.compareTo(y));
    String[] arr2 = {"a", "c", "d", "b"};
    sorter.sort(arr2, (x, y) -> x.compareTo(y));
    String[] arr3 = {"a", "a", "a", "a"};
    sorter.sort(arr3, (x, y) -> x.compareTo(y));
    String[] arr4 = {"d", "c", "b", "a"};
    sorter.sort(arr4, (x, y) -> x.compareTo(y));
    java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
    pen.println(Arrays.toString(arr));
    pen.println(Arrays.toString(arr0));
    pen.println(Arrays.toString(arr1));
    pen.println(Arrays.toString(arr2));
    pen.println(Arrays.toString(arr3));
    pen.println(Arrays.toString(arr4));
  }
} // class InsertionSort
