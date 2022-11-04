/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 * @author Sudheer Reddy Kunduru
 * @version 2.0
 */

import java.text.DateFormat;
import java.util.Date;

public class Assignment {

  protected String assignmentName;
  protected Date dueDate = new Date();
  protected String assignmentSpecification;
  protected SolutionList theSolutionList = new SolutionList();
  protected Solution suggestSolution = new Solution();
  protected boolean isAccepted;

  public Assignment() {
  }

  public void setDueDate(Date theDueDate) {
    this.dueDate = theDueDate;
  }

  public void setAssignmentSpecification(String theSpecification) {
    this.assignmentSpecification = theSpecification;
  }

  public boolean isOverDue() {
    Date today;
    today = new Date();
    return today.after(this.dueDate);
  }

  //// add the theSolution to the Solutionlist
  public void addSolution(Solution theSolution) {
    theSolutionList.add(theSolution);
  }

  public void submitSolution() {
  }

  public SolutionList getSolutionList() {
    return theSolutionList;
  }

  /*
   * return the solution of the give name
   */
  public Solution getSolution(String studentName) {
    SolutionIterator Iterator = new SolutionIterator(theSolutionList);
    return (Solution) Iterator.next(studentName);
  }

  public Solution getSuggestedSolution() {
    return suggestSolution;
  }

  public SolutionIterator getSolutionIterator() {
    return new SolutionIterator(theSolutionList);
  }

  public String toString() {
    return assignmentName;
  }

  public String getDueDateString() {
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    return dateFormat.format(dueDate);
  }

  public void accept(NodeVisitor visitor) {
    visitor.visitAssignment(this);
    this.isAccepted = true;
  }

}