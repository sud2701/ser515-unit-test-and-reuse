import java.util.Iterator;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 * 
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 * @author Sudheer Reddy Kunduru
 * @version 2.0
 */

abstract public class Person {
	int type = 0; // type=0 : student, type=1 instructor
	String userName;
	ClassCourseList courseList;
	CourseMenu theCourseMenu;
	Course currentCourse;

	public Person() {
		courseList = new ClassCourseList();
	}

	abstract public CourseMenu createCourseMenu(Course theCourse, int theLevel);

	public void showAddButton() {
		theCourseMenu.showAddButtons();
	}

	public void showViewButtons() {
		theCourseMenu.showViewButtons();
	}

	public void showComboxes() {
		theCourseMenu.showComboxes();
	}

	public void showRadios() {
		theCourseMenu.showRadios();
	}

	public void show() {
		theCourseMenu.setVisible(true);
	}

	public boolean ifLogout() {
		return theCourseMenu.ifLogout();
	}

	// show the assignment list
	public boolean showMenu() {
		// create a iterator for the assignment list
		// Iterator theIter=new ListIterator(CurrentCourse.AssList );
		Iterator<Assignment> theIterator = currentCourse.assignmentList.iterator();
		theCourseMenu.theCourse = currentCourse;
		Assignment theAssignment;
		while (theIterator.hasNext()) {
			theAssignment = theIterator.next();
			theCourseMenu.assignmentComboBox.addItem(theAssignment);
		}
		return false;
	}

	public void addCourse(Course theCourse) {
		courseList.add(theCourse);
	}
}