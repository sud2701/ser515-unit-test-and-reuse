import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;

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

@SuppressWarnings(value = "unused")
abstract public class CourseMenu extends JDialog {
  Course theCourse;
  boolean bLogout = true;

  JRadioButton assignmentRadio = new JRadioButton();
  JComboBox<Assignment> assignmentComboBox = new JComboBox<>();
  JButton assignmentViewButton = new JButton();
  JButton assignmentAddButton = new JButton();
  JRadioButton optionRadio = new JRadioButton();
  JLabel assignmentContentLabel = new JLabel();
  @SuppressWarnings("rawtypes")
  JComboBox optionCombo = new JComboBox();
  JButton optionViewButton = new JButton();
  JButton optionAddButton = new JButton();
  JButton buttonChangeCourse = new JButton();
  JButton buttonLogout = new JButton();

  public CourseMenu() {

    try {
      jbInit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    setModal(true);
    setSize(503, 294);
  }

  private void jbInit() {
    buttonChangeCourse.setText("ChangeCourse");
    buttonChangeCourse.setBounds(new Rectangle(101, 211, 73, 37));
    buttonChangeCourse.addActionListener(this::buttonChangeCourse_actionPerformed);
    this.getContentPane().setLayout(null);
    this.setTitle("");
    buttonLogout.setText("Logout");
    buttonLogout.setBounds(new Rectangle(267, 215, 73, 37));
    buttonLogout.addActionListener(this::buttonLogout_actionPerformed);
    this.getContentPane().add(buttonChangeCourse, null);
    this.getContentPane().add(buttonLogout, null);
  }

  /*
   * when the add button is pressed, call add assignment
   * function of facade, after that refresh window
   */

  /*
   * when the add button is pressed, call ViewAssignment
   * function of facade, after that refresh window
   */

  abstract void showMenu(Course theCourse);

  abstract void showAddButtons();

  abstract void showViewButtons();

  abstract void showRadios();

  abstract void showComboxes();

  abstract void showLabel();

  void assignmentAddButton_actionPerformed() {
    Hacs.theFacade.addAssignment(theCourse);
    refresh();
  }

  void assignmentViewButton_actionPerformed() {
    Assignment theAssignment = (Assignment) assignmentComboBox.getSelectedItem();
    Hacs.theFacade.viewAssignment(theAssignment);
  }

  void refresh() {
    assignmentComboBox.removeAllItems();
    for (Assignment assignment : theCourse.assignmentList) {
      assignmentComboBox.addItem(assignment);
    }
  }

  void buttonChangeCourse_actionPerformed(ActionEvent e) {
    bLogout = false;
    setVisible(false);
  }

  void buttonLogout_actionPerformed(ActionEvent e) {
    bLogout = true;
    setVisible(false);
  }

  boolean ifLogout() {
    return bLogout;
  }
}