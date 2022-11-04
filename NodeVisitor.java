/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sudheer Reddy Kunduru
 * @version 2.0
 */

abstract public class NodeVisitor {

	public NodeVisitor() {
	}

	abstract public void visitFacade(Facade facade);

	abstract public void visitCourse(Course course);

	abstract public void visitAssignment(Assignment assignment);

}