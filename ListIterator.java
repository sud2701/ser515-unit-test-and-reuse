import java.util.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sudheer Reddy Kunduru
 * @version 2.0
 */

public class ListIterator implements Iterator<Object> {
	ArrayList<Object> theList;
	int currentNumber = -1;

	public ListIterator(ArrayList<Object> list) {
		theList = list;
	}

	public boolean hasNext() {
		return currentNumber < theList.size() - 1;
	}

	public Object next() {
		if (hasNext()) {
			currentNumber++;
			return theList.get(currentNumber);
		} else {
			return null;
		}
	}

	public void remove() {
		theList.remove(currentNumber);
	}
}