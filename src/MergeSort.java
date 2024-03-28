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
    T[] unsorted = Arrays.copyOfRange(values, lo, hi); 
    int lIndex = 0;
    int rIndex = mid - lo;
    int valsIndex = lo;

    while (lIndex < (mid - lo) || rIndex < (hi - lo)) {
      if (lIndex < (mid - lo) && rIndex < (hi - lo)) {
        if (comparator.compare(unsorted[lIndex], unsorted[rIndex]) <= 0) {
          values[valsIndex] = unsorted[lIndex];
          lIndex++;
        } else {
          values[valsIndex] = unsorted[rIndex];
          rIndex++;
        } // else
      } else if (lIndex < (mid - lo)) {
        values[valsIndex] = unsorted[lIndex];
        lIndex++;
      } else {
        values[valsIndex] = unsorted[rIndex];
        rIndex++;
      } // else
      valsIndex++;
    } // while
  } // merge(T[], int, int, int, Comparator<? super T>)


  /**
   * Helper version of mergeSort that takes these bounds as arguments. 
   * Initially you should pass 0 and vals.size() to this helper method 
   * to kick off the merge sort process.
   */
  static <T> void mergeSort(T[] vals, int lo, int hi, Comparator<? super T> comparator) {
    if (lo >= (hi - 1)) {
      return;
    } 
    int mid = (hi + lo)/2;
    
    mergeSort(vals, lo, mid, comparator);
    mergeSort(vals, mid, hi, comparator);

    merge(vals, lo, mid, hi, comparator);
  } // mergeSort(T[], int, int, Comparator<? super T>)

} // class MergeSort
