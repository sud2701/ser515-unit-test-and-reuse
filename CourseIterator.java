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

public class CourseIterator implements Iterator<Object> {
  ClassCourseList theCourseList;
  int currentCourseNumber = -1;

  public CourseIterator(ClassCourseList courseList) {
    theCourseList = courseList;
  }

  public boolean hasNext() {
    return currentCourseNumber < theCourseList.size() - 1;
  }

  public Object next() {
    if (hasNext()) {
      currentCourseNumber++;
      return theCourseList.get(currentCourseNumber);
    } else {
      return null;
    }
  }

  public void remove() {
    theCourseList.remove(currentCourseNumber);
  }

  // the next Course that fits the given CourseName
  public Object next(String courseName) {
    Course theCourse;
    theCourse = (Course) next();
    while (theCourse != null) {
      if (courseName.compareTo(theCourse.toString()) == 0) {
        return theCourse;
      }
      theCourse = (Course) next();
    }
    return null;
  }

}