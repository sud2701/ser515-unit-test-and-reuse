import java.awt.Rectangle;
import java.text.DateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

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

public class InstructorAssignmentMenu extends AssignmentMenu {
  private Assignment theAssignment;
  JComboBox<Solution> comboSolutionList = new JComboBox<>();

  JTextField tbAssignmentName = new JTextField();
  JTextField tbDueDate = new JTextField();
  JTextField tbSuggestedSolution = new JTextField();

  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JButton buttonGrade = new JButton();
  JButton buttonReport = new JButton();
  JButton buttonClose = new JButton();

  public InstructorAssignmentMenu() {
    try {
      jbInit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() {
    jLabel1.setText("Assignment Name");
    jLabel1.setBounds(new Rectangle(25, 31, 118, 18));
    this.getContentPane().setLayout(null);
    tbAssignmentName.setText("jTextField1");
    tbAssignmentName.setBounds(new Rectangle(192, 31, 341, 22));
    jLabel2.setText("Due Date");
    jLabel2.setBounds(new Rectangle(28, 90, 113, 18));
    tbDueDate.setText("tbDueDate");
    tbDueDate.setBounds(new Rectangle(195, 87, 337, 22));
    jLabel3.setText("Suggested Solution");
    jLabel3.setBounds(new Rectangle(28, 151, 118, 18));
    tbSuggestedSolution.setText("jTextField2");
    tbSuggestedSolution.setBounds(new Rectangle(197, 149, 339, 22));
    buttonGrade.setText("Grade");
    buttonGrade.setBounds(new Rectangle(458, 199, 79, 29));
    buttonGrade.addActionListener(this::buttonGrade_actionPerformed);
    buttonReport.setText("Report");
    buttonReport.setBounds(new Rectangle(365, 249, 79, 29));
    buttonReport.addActionListener(this::buttonReport_actionPerformed);
    buttonClose.setText("Close");
    buttonClose.setBounds(new Rectangle(86, 253, 79, 29));
    buttonClose.addActionListener(this::buttonClose_actionPerformed);
    comboSolutionList.setBounds(new Rectangle(32, 204, 413, 22));
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(tbAssignmentName, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(tbDueDate, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(tbSuggestedSolution, null);
    this.getContentPane().add(buttonClose, null);
    this.getContentPane().add(comboSolutionList, null);
    this.getContentPane().add(buttonGrade, null);
    this.getContentPane().add(buttonReport, null);
  }

  public void showMenu(Assignment assignment, Person person) {
    theAssignment = assignment;
    tbAssignmentName.setText(theAssignment.assignmentName);

    DateFormat theDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    tbDueDate.setText(theDateFormat.format(theAssignment.dueDate));
    tbSuggestedSolution.setText(theAssignment.suggestSolution.solutionFileName);
    refreshSolutionList();
    setVisible(true);
  }

  void buttonClose_actionPerformed(ActionEvent e) {
    theAssignment.assignmentName = tbAssignmentName.getText();
    DateFormat temporaryDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    try {
      theAssignment.dueDate = temporaryDateFormat.parse(tbDueDate.getText());
    } catch (Exception ee) {
      ee.printStackTrace();
    }
    theAssignment.suggestSolution.solutionFileName = tbSuggestedSolution.getText();
    setVisible(false);
  }

  void buttonGrade_actionPerformed(ActionEvent e) {
    Solution theSolution = (Solution) comboSolutionList.getSelectedItem();
    if (theSolution == null)
      return;
    SolutionGradingDlg dialog = new SolutionGradingDlg();
    dialog.show(theSolution);
    refreshSolutionList();
  }

  void buttonReport_actionPerformed(ActionEvent e) {
    SolutionIterator solutionIterator = new SolutionIterator(theAssignment.theSolutionList);
    while (solutionIterator.hasNext()) {
      Solution aSolution = solutionIterator.next();
      aSolution.setReported(true);
    }
    refreshSolutionList();
  }

  private void refreshSolutionList() {
    comboSolutionList.removeAllItems();
    SolutionIterator solutionIterator = new SolutionIterator(theAssignment.theSolutionList);
    while (solutionIterator.hasNext()) {
      Solution theSolution = solutionIterator.next();
      comboSolutionList.addItem(theSolution);
    }
  }
}