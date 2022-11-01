package hacs;

/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

import java.util.Date;
import java.text.DateFormat;

public class Assignment {

  protected String assignmentName;
  protected String strAssignmentFilename;
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
    if (today.after(this.dueDate)) {
      return true;
    } else {
      return false;
    }
  }

  public Solution addSolution() {
    Solution mySolution = new Solution();
    return mySolution;
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
    SolutionIterator Iterator = (SolutionIterator) theSolutionList.iterator();
    return (Solution) Iterator.next(studentName);
  }

  public Solution getSuggestedSolution() {
    return suggestSolution;
  }

  public SolutionIterator getSolutionIterator() {
    SolutionIterator theSolutionIterator = new SolutionIterator(theSolutionList);
    return theSolutionIterator;
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

  public String getAssignmentName() {
    return this.assignmentName;
  }
}