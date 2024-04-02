import java.util.*;

/**
 * Sort using merge sort.
 *
 * @author Keely Miyamoto
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    mergeSort(values, 0, values.length, order);
  } // sort(T[], Comparator<? super T>

  /**
   * Merge the values from positions [lo, mid) and [mid, hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] values, int lo, int mid, int hi, Comparator<? super T> comparator) {
    // Declare array to hold values in the range [lo, hi)
    T[] unsorted = Arrays.copyOfRange(values, lo, hi); 
    // Track left and right indices in unsorted
    int lIndex = 0;
    int rIndex = mid - lo;
    // Track current index in values
    int valsIndex = lo;

      // While lIndex precedes midpoint and rIndex precedes end
      while (lIndex < (mid - lo) && rIndex < (hi - lo)) {
        // Compare values of unsored at lIndex and rIndex
        if (comparator.compare(unsorted[lIndex], unsorted[rIndex]) <= 0) {
          // Either set current index in values to value at lIndex and increment lIndex, valsIndex
          values[valsIndex++] = unsorted[lIndex++];
        } else {
          // Or else set current to rIndex and increment rIndex, valsIndex
          values[valsIndex++] = unsorted[rIndex++];
        } // else
      } // while

      // While lIndex precedes midpoint
      while (lIndex < (mid - lo)) {
        // Set current index in values to lIndex and increment lIndex, valsIndex
        values[valsIndex++] = unsorted[lIndex++];
      } // while
      
      // While rIndex precedes end and lIndex does not precede midpoint
      while (rIndex < (hi - lo)) {
        // Set current index in values to rIndex and increment rIndex, valsIndex
        values[valsIndex++] = unsorted[rIndex++];
      } // while

  } // merge(T[], int, int, int, Comparator<? super T>)


  /**
   * Helper version of mergeSort that takes these bounds as arguments. 
   * Initially you should pass 0 and vals.size() to this helper method 
   * to kick off the merge sort process.
   */
  static <T> void mergeSort(T[] vals, int lo, int hi, Comparator<? super T> comparator) {
    // If array contains 0 or 1 element, it is already sorted. Do nothing.
    if (lo >= (hi - 1)) {
      return;
    } // if

    // Set mid to halfway between hi and lo.
    int mid = (hi + lo) / 2;
    
    // Recursively call mergeSort on 1st half of vals
    mergeSort(vals, lo, mid, comparator);
    // Recursively call mergeSort on 2nd half of vals
    mergeSort(vals, mid, hi, comparator);

    // Merge sorted halves
    merge(vals, lo, mid, hi, comparator);
  } // mergeSort(T[], int, int, Comparator<? super T>)

} // class MergeSort
