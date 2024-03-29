import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sudheer Reddy Kunduru
 * @version 2.0
 */

public class Reminder extends JDialog {
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	java.awt.List listUpcoming = new java.awt.List();
	java.awt.List listOverdue = new java.awt.List();
	Button buttonOK = new Button();

	public Reminder() {
		try {
			jbInit();
			setModal(true);
			setSize(400, 386);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		jLabel1.setText("Upcoming assignments");
		jLabel1.setBounds(new Rectangle(38, 40, 159, 17));
		this.getContentPane().setLayout(null);
		jLabel2.setText("OverDue Assignments");
		jLabel2.setBounds(new Rectangle(39, 160, 161, 17));
		listUpcoming.setBounds(new Rectangle(29, 65, 340, 79));
		listOverdue.setBounds(new Rectangle(31, 187, 337, 85));
		buttonOK.setLabel("OK");
		buttonOK.setBounds(new Rectangle(149, 308, 67, 37));
		buttonOK.addActionListener(this::buttonOK_actionPerformed);
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(listUpcoming, null);
		this.getContentPane().add(listOverdue, null);
		this.getContentPane().add(buttonOK, null);
	}

	void showReminder() {
		ReminderVisitor visitor = new ReminderVisitor(this);
		visitor.visitFacade(Hacs.theFacade);
		setVisible(true);
	}

	void buttonOK_actionPerformed(ActionEvent e) {
		setVisible(false);
	}
}