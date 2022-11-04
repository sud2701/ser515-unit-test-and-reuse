import java.io.File;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sudheer Reddy Kunduru
 * @version 2.0
 */

public class ClassCourseList extends ArrayList<Course> {

	public ClassCourseList() {
	}

	/* Reading course data from CourseInfo.txt, The file contains names of all the available courses. */
	void initializeFromFile () {
		try {
			BufferedReader file;
			String strCourseName;
			File f = new File("CourseInfo.txt");
			file = new BufferedReader(new FileReader(f));
			while ((strCourseName = file.readLine()) != null) {
				Course theCourse;
				theCourse = new Course(strCourseName, 0);
				add(theCourse);
			}
			file.close();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
	/* Obtaining a Course Object from its name */
	Course findCourseByCourseName(String courseName) {
		for (Course course : this) {
			Course theCourse;
			theCourse = course;
			if (theCourse.courseName.compareTo(courseName) == 0)
				return theCourse;
		}
		return null;
	}

}