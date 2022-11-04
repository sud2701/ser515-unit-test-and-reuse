import javax.swing.*;

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

abstract public class AssignmentMenu extends JDialog {
  abstract void showMenu(Assignment assignment, Person person);

  public AssignmentMenu() {
    setModal(true);
    setSize(575, 330);
  }
}