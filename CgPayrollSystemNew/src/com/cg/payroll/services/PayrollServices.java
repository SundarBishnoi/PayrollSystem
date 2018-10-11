package com.cg.payroll.services;
import java.util.ArrayList;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;
public interface PayrollServices{
	int accceptAssociateDetails(int yearlyInvestmentUnder80C,String  firstName, String lastName, String department, 
			String designation, String pancard, String emailID ,float basicSalary,float epf,float companyPf,int accountNumber,
			String bankName,String ifscCode) throws PayrollServicesDownException;
	int calculateNetSalary(int associateID) throws AssociateDetailsNotFoundException,PayrollServicesDownException;
	Associate getAssociateDetails(int associateID) throws AssociateDetailsNotFoundException,PayrollServicesDownException;
	ArrayList<Associate> getAllAssociatesDetails() throws PayrollServicesDownException;
}
