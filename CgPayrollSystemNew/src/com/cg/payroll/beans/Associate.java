package com.cg.payroll.beans;
public class Associate {
	private int associateID;
	int yearlyInvestmentUnder80C; 
	private String firstName,lastName,department,designation,pancard,emailID;     
	private BankDetails bankdetails;
	private Salary salary;
	public Associate() {
		super();
	}
	public Associate(int associateID, int yearlyInvestmentUnder80C,
			String firstName, String lastName, String department,
			String designation, String pancard, String emailID,
			BankDetails bankdetails, Salary salary) {
		super();
		this.associateID = associateID;
		this.yearlyInvestmentUnder80C = yearlyInvestmentUnder80C;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.designation = designation;
		this.pancard = pancard;
		this.emailID = emailID;
		this.bankdetails = bankdetails;
		this.salary = salary;
	}
	public Associate(int associateID, int yearlyInvestmentUnder80C,
			String firstName, String lastName, String department,
			String designation, String pancard, String emailID) {
		super();
		this.associateID = associateID;
		this.yearlyInvestmentUnder80C = yearlyInvestmentUnder80C;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.designation = designation;
		this.pancard = pancard;
		this.emailID = emailID;
	}
	public Associate(int yearlyInvestmentUnder80C, String firstName,
			String lastName, String department, String designation,
			String pancard, String emailID, BankDetails bankdetails,
			Salary salary) {
		super();
		this.yearlyInvestmentUnder80C = yearlyInvestmentUnder80C;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.designation = designation;
		this.pancard = pancard;
		this.emailID = emailID;
		this.bankdetails = bankdetails;
		this.salary = salary;
	}
	public int getAssociateID() {
		return associateID;
	}
	public void setAssociateID(int associateID) {
		this.associateID = associateID;
	}
	public int getyearlyInvestmentUnder80C() {
		return yearlyInvestmentUnder80C;
	}
	public void setyearlyInvestmentUnder80C(int yearlyInvestmentUnder80C) {
		this.yearlyInvestmentUnder80C = yearlyInvestmentUnder80C;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getEmailid() {
		return emailID;
	}
	public void setEmailid(String emailid) {
		this.emailID = emailID;
	}
	public BankDetails getBankdetails() {
		return bankdetails;
	}
	public void setBankdetails(BankDetails bankdetails) {
		this.bankdetails = bankdetails;
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Associate Details [+associateID=" + associateID +"\n"
				+ ", yearlyInvestmentUnder80C=" + yearlyInvestmentUnder80C +"\n"
				+ ", firstName=" + firstName + ", lastName=" + lastName +"\n"
				+ ", department=" + department + ", designation=" + designation +"\n"
				+ ", pancard=" + pancard + ", emailID=" + emailID +"\n"
				+ ", bankdetails=" + bankdetails + ", salary=" + salary + "]";
	}
	private static int ASSOCIATE_COUNTER; 
	public static int getASSOCIATE_COUNTER() {
		return ASSOCIATE_COUNTER;
	}
	public static void setASSOCIATE_COUNTER(int aSSOCIATE_COUNTER) {
		ASSOCIATE_COUNTER = aSSOCIATE_COUNTER;
	}           
}
