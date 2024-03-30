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

  /**
   * Helper function to implement a version of insertion sort that takes lower and upper bounds as parameters.
   */
  static <T> void insertionSort(T[] values, int lb, int ub, Comparator<? super T> comparator) {
    // for each index between the upper and lower bound, exclusive...
    for (int i = lb + 1; i < (ub - lb); i++) {
      // store element of values at index i
      T current = values[i];
      // find previous index
      int previous = i - 1;
      // while 0 <= previous, and the element at previous index follows the current element
      while (0 <= previous && (comparator.compare(values[previous], current) > 0)) {
        // move previous one index to the right, decrement previous
        values[previous + 1] = values[previous];
        previous--;
      } // while

      // set current as the element at the index to the right of 'previous'
      values[previous + 1] = current;                  
    } // for
  } // insertionSort(T[], int, int, comparator)

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
    // divide [lb, ub) into 'runs' of size 'this.minRunLength'
    for (int i = lb; i < ub; i += this.minRunLength) {
      // use insertion sort to sort each run
      insertionSort(values, i, Math.min(i + this.minRunLength, ub), comparator);
    } // for

    // use MergeSort.merge to combine the sorted runs
    for (int size = this.minRunLength; size < (ub - lb); size *= 2) {
      for (int left = lb; left < ub; left += (2 * size)) {
        int mid = (left + size) - 1;
        int right = Math.min((left + ((2 * size) - 1)), (ub - 1));
        MergeSort.merge(values, left, mid, right, comparator);
      } // for
    } // for
  } // miyamotoKeelySort(T[], int, int, Comparator<? super T>)

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    miyamotoKeelySort(values, 0, values.length, order);
  } // sort(T[], Comparator<? super T>

  // Tests in main
  public static void main(String[] args) {
    Sorter mySorter = new MiyamotoKeelySort();
    Integer[] arr0 = {2, 3, 5, 1, 7, 6, 1, 1, 2, 9, 2, 0};
    Integer[] arr1 = {};
    Integer[] arr2 = {1};
    Integer[] arr3 = {2, 2, 2, 2};
    Integer[] arr4 = {1, 2, 3, 4};
    Integer[] arr5 = {4, 3, 2, 1};
    System.out.println(Arrays.toString(arr0));
    mySorter.sort(arr0, (x, y) -> x.compareTo(y));
    System.out.println(Arrays.toString(arr0));

    System.out.println(Arrays.toString(arr1));
    mySorter.sort(arr1, (x, y) -> x.compareTo(y));
    System.out.println(Arrays.toString(arr1));

    System.out.println(Arrays.toString(arr2));
    mySorter.sort(arr2, (x, y) -> x.compareTo(y));
    System.out.println(Arrays.toString(arr2));

    System.out.println(Arrays.toString(arr3));
    mySorter.sort(arr3, (x, y) -> x.compareTo(y));
    System.out.println(Arrays.toString(arr3));

    System.out.println(Arrays.toString(arr4));
    mySorter.sort(arr4, (x, y) -> x.compareTo(y));
    System.out.println(Arrays.toString(arr4));

    System.out.println(Arrays.toString(arr5));
    mySorter.sort(arr5, (x, y) -> x.compareTo(y));
    System.out.println(Arrays.toString(arr5));
  } // main
} // class MiyamotoKeelySort

