import java.util.Comparator;

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
    insertionSort(values, 0, values.length, order);
  } // sort(T[], Comparator<? super T>)

  /**
   * Helper function to implement a version of insertion sort that takes lower and upper bounds as parameters.
   */
  static <T> void insertionSort(T[] values, int lb, int ub, Comparator<? super T> comparator) {
    // For each index between the upper and lower bound, exclusive...
    for (int i = lb + 1; i < (ub - lb); i++) {
      // Store element of values at index i
      T current = values[i];
      // Find previous index
      int previous = i - 1;
      // While 0 <= previous, and the element at previous index follows the current element
      while (0 <= previous && (comparator.compare(values[previous], current) > 0)) {
        // Move previous one index to the right, decrement previous
        values[previous + 1] = values[previous];
        previous--;
      } // while

      // Set current as the element at the index to the right of 'previous'
      values[previous + 1] = current;                  
    } // for
  } // insertionSort(T[], int, int, comparator)
} // class InsertionSort
