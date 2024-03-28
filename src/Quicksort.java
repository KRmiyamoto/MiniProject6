import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Keely Miyamoto
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Helper function to swap two elements at given indices in an array of type T.
   * @param <T> The type of elements in the array.
   * @param values An array of values of type T.
   * @param i The index of one element to be swapped. Note 0 <= i < values.length.
   * @param j The index of one element to be swapped. Note 0 <= j < values.length.
   */
  private static <T> void swap(T[] values, int i, int j) {
    T temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  } // swap(T[], int, int)

  /**
   * Helper function to partition a given array.
   * @param <T> The type of elements in the array.
   * @param values An array of values of type T.
   * @param lb The lower bound of the array. Note 0 <= lb < values.length.
   * @param ub The uppser bound of the array. Note 0 <= up <= values.length.
   * @param comparator The comparator used to order elements of values
   * @return Returns an integer the represents the index of the pivot.
   */
  private static <T> int partition(T[] values, int lb, int ub, Comparator<? super T> comparator) {
    // set pivot at midpoint of values
    int pivot = (lb + ub) / 2;
    // set sm and lg indicators
    int sm = lb + 1;
    int lg = ub;
    // swap pivot and initial element in values
    swap(values, pivot, lb);
    // while sm indicator is strictly less than lg, compare the element at sm to the pivot element 
    while (sm != lg) {
      // if the pivot element precedes the element at sm, 
      // swap the element at sm with the element at lg, and decrement lg
      if (comparator.compare(values[lg - 1], values[lb]) > 0) {
        lg--;
      } else if (comparator.compare(values[sm], values[lb]) <= 0) {
        // progress the sm indicator
        sm++;
      } else {
        swap(values, sm, lg - 1);
      } // else
    } // while
    // swap the pivot element back to its original position (midpoint)
    swap(values, lb, sm - 1);
    // return the index of the pivot element
    return sm - 1;
  } // partition(T[], int, int, Comparator<? super T>)

  /**
   * Helper function to implement Quicksort using the parition helper function.
   * @param <T> The type of elements in the array values.
   * @param values An array of elements of type T.
   * @param lb The lower bound of the array. Note 0 <= lb < values.length.
   * @param ub The lower bound of the array. Note 0 <= ub <= values.length.
   * @param comparator The comparator used to order elements in values.
   */
  static <T> void quickSort(T[] values, int lb, int ub, Comparator<? super T> comparator) {
    // Check elements are already ordered (i.e. if lb is not strictly less than ub - 1)
    if (ub - lb <= 1) {
      return;
    // If not, partition values. 
    // Then recursively call quickSort to partition the newly partitioned portions of values.
    } else {
      int pivot = partition(values, lb, ub, comparator);
      quickSort(values, lb, pivot, comparator);
      quickSort(values, pivot + 1, ub, comparator);
    } // else
  } // quickSort(T[], int, int, Comparator<? super T>)

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quickSort(values, 0, values.length, order);
  } // sort(T[], Comparator<? super T>

} // class Quicksort
