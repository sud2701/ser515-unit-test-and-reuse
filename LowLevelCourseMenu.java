import java.awt.*;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sudheer Reddy Kunduru
 * @version 2.0
 */


public class LowLevelCourseMenu extends CourseMenu {

	public LowLevelCourseMenu() {
	}

	void showMenu(Course theCourse) {
		setVisible(true);
	}

	void showAddButtons() {
		assignmentAddButton.addActionListener(e -> assignmentAddButton_actionPerformed());
		assignmentAddButton.setText("Add");
		assignmentAddButton.setBounds(new Rectangle(389, 54, 79, 29));
		optionAddButton.setText("Add");
		optionAddButton.setBounds(new Rectangle(390, 125, 79, 29));
		this.getContentPane().add(assignmentAddButton, null);
		this.getContentPane().add(optionAddButton, null);
	}

	void showRadios() {
		assignmentRadio.setText("Assignment");
		assignmentRadio.setBounds(new Rectangle(21, 55, 103, 26));
		this.getContentPane().add(assignmentRadio, null);
		optionRadio.setText("LowLevelExperiment");
		optionRadio.setBounds(new Rectangle(21, 128, 103, 26));
		this.getContentPane().add(optionRadio, null);
	}

	void showComboxes() {
		assignmentComboBox.setBounds(new Rectangle(140, 57, 126, 22));
		optionCombo.setBounds(new Rectangle(137, 127, 126, 22));
		this.getContentPane().add(assignmentComboBox, null);
		this.getContentPane().add(optionCombo, null);
		refresh();
	}

	void showViewButtons() {
		assignmentViewButton.setText("View");
		assignmentViewButton.setBounds(new Rectangle(290, 54, 79, 29));
		assignmentViewButton.addActionListener(e -> assignmentViewButton_actionPerformed());
		optionViewButton.setText("View");
		optionViewButton.setBounds(new Rectangle(290, 124, 79, 29));
		this.getContentPane().add(assignmentViewButton, null);
		this.getContentPane().add(optionViewButton, null);
	}

	void showLabel() {
		assignmentContentLabel.setText("AssigmentContent");
		assignmentContentLabel.setBounds(new Rectangle(23, 186, 432, 99));
		this.getContentPane().add(assignmentContentLabel, null);
	}
}