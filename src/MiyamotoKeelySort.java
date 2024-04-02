import java.util.*;

/**
 * Implementation of my own sorting algorithm, based on TimSort.
 * I used the resources listed in README, but I did not use ChatGPT.
 * 
 * @author Keely Miyamoto
 */

public class MiyamotoKeelySort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MiyamotoKeelySort();

  // Constant MIN_MERGE
  static int MIN_MERGE = 64;

  // Credit: GeeksforGeeks contribution by 29AjayKumar
  public static int minRunLength(int n) {
    assert n >= 0;
    int r = 0;
    while (n >= MIN_MERGE) { 
      r |= (n & 1); 
      n >>= 1; 
    } // while
    return n + r; 
  } // minRunLength(int)

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MiyamotoKeelySort() {
  } // MiyamotoKeelySort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Helper function to sort a given array of type T by splitting into "runs," sorting runs with insertionSort,
   * and then combining runs with MergeSort.merge.
   * @param <T> type of elements in 'values'
   * @param values array of elements of type T
   * @param lb lower bound of values 
   * @param ub upper bound of values
   * @param comparator Comparator by which elements will be ordered
   */
  public <T> void miyamotoKeelySort(T[] values, int lb, int ub, Comparator<? super T> comparator) {
  
    // Calculate minRunLength
    int minRunLength = minRunLength(MIN_MERGE);
    // Store subarray length
    int len = ub - lb;

    // Divide [lb, ub) into 'runs' of size 'minRunLength'
    for (int i = lb; i < ub; i += minRunLength) {
      // Use insertion sort to sort each run
      InsertionSort.insertionSort(values, i,  Math.min(i + MIN_MERGE, ub), comparator);
    } // for

    // Use MergeSort.merge to combine the sorted runs
    for (int size = minRunLength; size < len; size = 2 * size) {
      for (int left = lb; left < ub; left += 2 * size) {
          int mid = left + size;
          int right = Math.min(left + 2 * size, ub);
          if (mid < right) {
            MergeSort.merge(values, left, mid, right, comparator);
          } // if
      } // for
    } // for
  } // miyamotoKeelySort(T[], int, int, Comparator<? super T>)

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    miyamotoKeelySort(values, 0, values.length, order);
  } // sort(T[], Comparator<? super T>
} // class MiyamotoKeelySort

