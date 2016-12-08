package ss.week4;

import java.util.ArrayList;
import java.util.List;

public class Util {
  /**
   * zip function
   * @param l1 first list of elements.
   * @param l2 second list of elements.
   * @return result, l1 and l2 zipped together.
   */
  public static <ELEMENT> List<ELEMENT> zip(List<ELEMENT> l1, List<ELEMENT> l2) {
    ArrayList<ELEMENT> result = new ArrayList<ELEMENT>();
    for (int i = 0; i < l1.size(); i++) {
      result.add(l1.get(i));
      result.add(l2.get(i));
    }
    return result;
  }    

  /**
   *  signum function
   * @param i1 the function argument.
   * @return -1, 0 or 1 if the argument is negative, 0 or positive.
   */
  public static int signum(int i1) {
    if (i1 < 0) {
      return -1;
    } else if (i1 > 0) {
      return 1;
    } else {
      return 0;
    }
  }
}
