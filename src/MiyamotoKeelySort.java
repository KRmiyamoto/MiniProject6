import java.util.*;

/**
 * Implementation of my own sorting algorithm, based on TimSort.
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

  static int MIN_MERGE = 32;
  int minRunLength = MIN_MERGE;

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

  static <T> void insertionSort(T[] values, int lb, int ub, Comparator<? super T> comparator) {
    int len = ub - lb;
    for (int i = lb + 1; i < len; i++) {
      T current = values[i];
      int j = i - 1;
      while (j >= 0 && (comparator.compare(values[j], current) > 0)) {
        values[j + 1] = values[j];
        j--;
      } // while

      values[j + 1] = current;                  
    } // for
  } // insertionSort()

  public <T> void miyamotoKeelySort(T[] values, int lb, int ub, Comparator<? super T> comparator) {
    for (int i = lb; i < ub; i += this.minRunLength) {
      insertionSort(values, i, Math.min(i + this.minRunLength, ub), comparator);
    } // for

    for (int size = this.minRunLength; size < (ub - lb); size = 2 * size) {
      for (int left = lb; left < ub; left += 2 * size) {
        int mid = left + size - 1;
        int right = Math.min((left + 2 * size - 1), (ub - 1));
        MergeSort.merge(values, left, mid, right, comparator);
      } // for
    } // for
  } // miyamotoKeelySort(T[], int, int, Comparator<? super T>)

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    miyamotoKeelySort(values, 0, values.length, order);
  } // sort(T[], Comparator<? super T>

  public static void main(String[] args) {
    Sorter mySorter = new MiyamotoKeelySort();
    Integer[] arr = {2, 3, 5, 1, 7, 6, 1, 1, 2, 9, 2, 0};
    System.out.println(Arrays.toString(arr));
    mySorter.sort(arr, (x, y) -> x.compareTo(y));
    System.out.println(Arrays.toString(arr));
  } // main
} // class MiyamotoKeelySort

