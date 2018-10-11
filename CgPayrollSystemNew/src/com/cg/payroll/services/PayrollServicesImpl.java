package com.cg.payroll.services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.daoservices.AssociateDAOImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.util.ConnectionProvider;
public class PayrollServicesImpl implements PayrollServices{
	private AssociateDAO associatedao =new AssociateDAOImpl();                    //to interact with DAO layer need to make object of AssociateDaoImpl into reference of AssociateDao interface
	
	private Connection conn=ConnectionProvider.getDBConnection();
	@Override
	public int accceptAssociateDetails( int yearlyInvestmentUnder8oC,String firstName, String lastName,
			String department, String designation, String pancard,
			String emailID, float basicSalary,
			float epf, float companyPf, int accountNumber, String bankName,
			String ifscCode) throws PayrollServicesDownException{
		ArrayList<Associate>list=new ArrayList<>();
		Associate associate=new Associate(yearlyInvestmentUnder8oC ,firstName,lastName,department,designation,pancard,emailID,new BankDetails(accountNumber,bankName,ifscCode),new Salary(basicSalary,epf,companyPf));
		list.add(associate);
		try {
			associate=associatedao.save(associate);                                    // to save the data into database need to go into DAO Layer with object containing all info
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(associate.getAssociateID());
		return associate.getAssociateID();
	}
	@Override
	public int calculateNetSalary(int associateID)
			throws AssociateDetailsNotFoundException, PayrollServicesDownException {
		Associate associate = null;
		try {
			associate = associatedao.findOne(associateID);                  //check particular associateId exist or Not in Database
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(associate==null) throw new AssociateDetailsNotFoundException("Associate Details Not Found");	
		float basicSalary=associate.getSalary().getBasicSalary();    //Tax Calculation Part Start Now
		float hra=50*basicSalary/100;
		associate.getSalary().setHra(hra);
		updateSalaryAttribute(associateID,"hra",hra);

		float conveyenceAllowance=25*basicSalary/100;
		associate.getSalary().setConveyneceAllowance(conveyenceAllowance);
		updateSalaryAttribute(associateID,"conveyenceAllowance",conveyenceAllowance);

		float otherAllowance=25*basicSalary/100;
		associate.getSalary().setOtherAllowance(otherAllowance);
		updateSalaryAttribute(associateID,"otherAllowance",otherAllowance);

		float personalAllowance=40*basicSalary/100;
		associate.getSalary().setPersonalAllownace(personalAllowance);
		updateSalaryAttribute(associateID,"personalAllowance",personalAllowance);

		float epf=12*basicSalary/100;
		associate.getSalary().setEpf(epf);

		float companyPf = 12*basicSalary/100;
		associate.getSalary().setCompanypf(companyPf);

		float gratuity=481*basicSalary/10000;
		associate.getSalary().setGratuity(gratuity);

		float grossSalary=basicSalary+conveyenceAllowance+otherAllowance+personalAllowance+epf;
		associate.getSalary().setGrossSalary(grossSalary);
		updateSalaryAttribute(associateID,"grossSalary",grossSalary);

		float yearlyInvestmentUnder80C = epf+associate.getyearlyInvestmentUnder80C();
		if(yearlyInvestmentUnder80C>150000)
			yearlyInvestmentUnder80C=150000;
		associate.setyearlyInvestmentUnder80C((int) yearlyInvestmentUnder80C);

		float taxableIncome = 12*(grossSalary-epf)-yearlyInvestmentUnder80C;
		float yearlyTax=0;
		if(taxableIncome<=250000)
			yearlyTax=0;
		else if(taxableIncome>250000 && taxableIncome<=500000)
			yearlyTax=5*(taxableIncome-250000)/100;
		else if(taxableIncome>500000 && taxableIncome<=1000000)
			yearlyTax=12500+20*(taxableIncome-500000);
		else
			yearlyTax=112500+30*(taxableIncome-1000000);
		float monthlyTax=yearlyTax/12;
		associate.getSalary().setMonthlyTax(monthlyTax);
		updateSalaryAttribute(associateID,"monthlyTax",monthlyTax);

		int netSalary=(int) (grossSalary-epf-monthlyTax);
		associate.getSalary().setNetsalary(netSalary);
		updateSalaryAttribute(associateID,"netSalary",netSalary);
		return netSalary;
	}
	@Override
	public Associate getAssociateDetails(int associateID)
			throws AssociateDetailsNotFoundException {
		Associate associate = null;
		try {
			associate = associatedao.findOne(associateID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(associate==null) throw new AssociateDetailsNotFoundException("Associate Details Not Found");
		return associate;
	}
	@Override
	public ArrayList<Associate> getAllAssociatesDetails() {
		try {
			return associatedao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void updateSalaryAttribute(int associateID,String str,float value){
		PreparedStatement pstmt;
		try {
			//System.out.println("update Salary set "+str.toUpperCase()+"="+value+" where associateId="+associateId);
			pstmt = conn.prepareStatement("update Salary set "+str.toUpperCase()+"="+value+" where associateID= "+associateID);
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
