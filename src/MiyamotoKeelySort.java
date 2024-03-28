import java.util.Comparator;

/**
 * Something that fails to sort.  Intended primarily to allow us to wath
 * tests fail.
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

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    // STUB
  } // sort(T[], Comparator<? super T>
} // class MiyamotoKeelySort

