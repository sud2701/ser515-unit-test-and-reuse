import java.awt.Rectangle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sudheer Reddy Kunduru
 * @version 2.0
 */

public class CourseSelectDlg extends JDialog {
	// 0 HighLevel presentation 1 LowLevel Experiment
	ClassCourseList theCourseList;
	Course selectedCourse;
	int nCourseLevel = 0;
	boolean m_bLogout = false;
	JComboBox<Course> courseNameCombo = new JComboBox<>();
	JRadioButton highLevelRadio = new JRadioButton();
	JRadioButton lowLevelRadio = new JRadioButton();
	JLabel jLabel1 = new JLabel();
	JButton okButton = new JButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	JButton buttonLogout = new JButton();

	public CourseSelectDlg() {
		try {
			jbInit();
			setSize(420, 238);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		this.getContentPane().setLayout(null);
		courseNameCombo.setBounds(new Rectangle(155, 41, 203, 22));
		highLevelRadio.setText("HighLevel");
		highLevelRadio.setBounds(new Rectangle(50, 87, 103, 26));
		lowLevelRadio.setToolTipText("");
		lowLevelRadio.setSelected(true);
		lowLevelRadio.setText("LowLevel");
		lowLevelRadio.setBounds(new Rectangle(236, 88, 103, 26));
		jLabel1.setText("CourseName");
		jLabel1.setBounds(new Rectangle(39, 44, 85, 18));
		okButton.setText("OK");
		okButton.setBounds(new Rectangle(78, 139, 79, 29));
		okButton.addActionListener(this::okButton_actionPerformed);
		buttonLogout.setText("Logout");
		buttonLogout.setBounds(new Rectangle(224, 140, 73, 31));
		buttonLogout.addActionListener(this::buttonLogout_actionPerformed);
		this.getContentPane().add(courseNameCombo, null);
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(highLevelRadio, null);
		this.getContentPane().add(lowLevelRadio, null);
		this.getContentPane().add(okButton, null);
		this.getContentPane().add(buttonLogout, null);
		buttonGroup1.add(highLevelRadio);
		buttonGroup1.add(lowLevelRadio);
	}

	/*
	 * show the theCourseList in a combox Show the Course type selection button
	 * return the pointer pointing to the Course object return the Course Type
	 */

	public Course ShowDlg(ClassCourseList courseList) {

		theCourseList = courseList;
		CourseIterator theIterator = new CourseIterator(theCourseList);
		Course theCourse;
		while ((theCourse = (Course) theIterator.next()) != null) /// end of the list
		{
			courseNameCombo.addItem(theCourse);
		}
		setVisible(true);
		return selectedCourse;
	}

	void okButton_actionPerformed(ActionEvent e) {
		selectedCourse = (Course) courseNameCombo.getSelectedItem();
		if (highLevelRadio.isSelected())
			nCourseLevel = 0; // highlevel course: 0
		else
			nCourseLevel = 1; // lowlevel course: 1
		setVisible(false);
	}

	public boolean isLogout() {
		return m_bLogout;
	}

	void buttonLogout_actionPerformed(ActionEvent e) {
		m_bLogout = true;
		setVisible(false);
	}
}