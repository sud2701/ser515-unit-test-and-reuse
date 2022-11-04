import java.util.Iterator;

/**
 * Title: HACS
 * Description:
 * Copyright: Copyright (c) 2002
 * Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sudheer Reddy Kunduru
 * @version 2.0
 */

public class SolutionIterator implements Iterator<Solution> {
  SolutionList solutionlist;

  /// CurrentSolutionNumber: point to the location before the first element
  int currentSolutionNumber = -1;

  public SolutionIterator(SolutionList thesolutionlist) {
    solutionlist = thesolutionlist;
    moveToHead();
  }

  public void moveToHead() {
    /// CurrentSolutionNumber: point to the location before the first element
    currentSolutionNumber = -1;
  }

  public boolean hasNext() {

    return currentSolutionNumber < solutionlist.size() - 1;

  }

  public Solution next() {

    if (hasNext()) {
      currentSolutionNumber++;
      return solutionlist.get(currentSolutionNumber);
    } else {
      return null;
    }

  }


  public Object next(String userName) {
    Solution theSolution;
    theSolution = next();
    while (theSolution != null) {
      if (userName.compareTo(theSolution.theAuthor) == 0) {
        return theSolution;
      }
      theSolution = next();
    }
    return null;
  }

  public void remove() {

    solutionlist.remove(currentSolutionNumber);
    // throw new java.lang.UnsupportedOperationException("Method remove() not yet
    // implemented.");
  }

}