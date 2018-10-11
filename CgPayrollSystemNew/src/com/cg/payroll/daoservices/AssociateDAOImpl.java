package com.cg.payroll.daoservices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.util.ConnectionProvider;
public class AssociateDAOImpl implements AssociateDAO {
	private Connection conn=ConnectionProvider.getDBConnection();                    //Make connection with Database
	@Override
	public Associate save(Associate associate) throws SQLException{
		try {
			conn.setAutoCommit(false);                                                                                //Set auto commit false on Database
			System.out.println("Reached");																		//query to insert associate object data into Database table
			PreparedStatement pstmt1=conn.prepareStatement("insert into Associate(yearlyInvestmentUnder80C,firstName,lastName,department,designation,pancard,emailID) values(?,?,?,?,?,?,?)");
			pstmt1.setInt(1,associate.getyearlyInvestmentUnder80C());
			pstmt1.setString(2,associate.getFirstName());
			pstmt1.setString(3,associate.getLastName());
			pstmt1.setString(4,associate.getDepartment());
			pstmt1.setString(5,associate.getDesignation());
			pstmt1.setString(6,associate.getPancard());
			pstmt1.setString(7,associate.getEmailid());
			pstmt1.executeUpdate();
			System.out.println("Reached");

			PreparedStatement pstmt2=conn.prepareStatement("select max(associateID) from Associate");
			ResultSet rs=pstmt2.executeQuery();
			rs.next();
			int associateID=rs.getInt(1);

			PreparedStatement pstmt3=conn.prepareStatement("insert into BankDetails values(?,?,?,?)");
			pstmt3.setInt(4,associateID);               //Change  from associateId to associate.getAssociateID()
			pstmt3.setLong(1,associate.getBankdetails().getAccountNumber());
			pstmt3.setString(2,associate.getBankdetails().getBankName());
			pstmt3.setString(3,associate.getBankdetails().getIfscCode());
			pstmt3.executeUpdate();

			PreparedStatement pstmt4=conn.prepareStatement("insert into Salary(basicSalary,epf,companyPf,associateID) values(?,?,?,?)");
			pstmt4.setInt(4, associateID);        //Change  from associateId to associate.getAssociateID()
			pstmt4.setDouble(1, associate.getSalary().getBasicSalary());
			pstmt4.setDouble(2, associate.getSalary().getEpf());
			pstmt4.setDouble(3,associate.getSalary().getCompanypf());
			pstmt4.executeUpdate();

			conn.commit();
			associate.setAssociateID(associateID);   //Change  from associateId to associate.getAssociateID()
			return associate;
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();                              
			throw e;
		}
		finally{
			conn.setAutoCommit(true);   //set auto commit true
		}
	}
	@Override
	public Associate findOne(int associateID) throws SQLException{
		PreparedStatement pstmt1=conn.prepareStatement("select * from Associate where associateID="+associateID);
		ResultSet associateRs=pstmt1.executeQuery();
		if(associateRs.next()){
			String firstName=associateRs.getString("firstName");
			String lastName=associateRs.getString("lastName");
			String department=associateRs.getString("department");
			String designation=associateRs.getString("designation");
			String pancard=associateRs.getString("pancard");
			String emailID=associateRs.getString("emailID");
			int yearlyInvestmentunder80C=associateRs.getInt("yearlyInvestmentUnder80C");
			Associate associate =new Associate(associateID,yearlyInvestmentunder80C,firstName,lastName,department,designation,pancard,emailID);

			PreparedStatement pstmt2=conn.prepareStatement("select * from BankDetails where associateID="+associateID);
			ResultSet bankDetailsRs=pstmt2.executeQuery();
			bankDetailsRs.next();
			int accountNumber=bankDetailsRs.getInt("accountNumber");
			String bankName=bankDetailsRs.getString("bankName");
			String ifscCode=bankDetailsRs.getString("ifscCode");
			associate.setBankdetails(new BankDetails(accountNumber,bankName,ifscCode));


			PreparedStatement pstmt3=conn.prepareStatement("select * from Salary where associateID="+associateID);
			ResultSet salaryRs=pstmt3.executeQuery();
			salaryRs.next();
			float basicSalary=salaryRs.getFloat("basicSalary");
			float companypf=salaryRs.getFloat("companyPf");
			float conveyneceAllowance=salaryRs.getFloat("conveyenceAllowance");
			float epf=salaryRs.getFloat("epf");
			float gratuity=salaryRs.getFloat("gratuity");
			float grossSalary=salaryRs.getFloat("grossSalary");
			float hra=salaryRs.getFloat("hra");
			float monthlyTax=salaryRs.getFloat("monthlyTax");
			float netSalary=salaryRs.getFloat("netsalary");
			float otherAllowance=salaryRs.getFloat("otherAllowance");
			float personalAllowance=salaryRs.getFloat("personalAllowance");
			associate.setSalary(new Salary(basicSalary,companypf,conveyneceAllowance,epf,gratuity,grossSalary,hra,monthlyTax,netSalary,otherAllowance,personalAllowance));
			return associate;
		}
		return null;
	}

	@Override
	public ArrayList<Associate> findAll() throws SQLException{
		PreparedStatement pstmt1=conn.prepareStatement("select * from Associate ");
		ResultSet associateRS=pstmt1.executeQuery();
		ArrayList<Associate> associates=new ArrayList<>();
		if(associateRS.next()){
			int associateID=associateRS.getInt("associateID");
			String firstName=associateRS.getString("firstName");
			String lastName=associateRS.getString("lastName");
			String department=associateRS.getString("department");
			String designation=associateRS.getString("designation");
			int yearlyInvestmentUnder8oC=associateRS.getInt("yearlyInvestmentUnder80C");
			String pancard=associateRS.getString("pancard");
			String emaillID=associateRS.getString("emailID");
			Associate associate =new Associate(associateID,yearlyInvestmentUnder8oC,firstName,lastName,department,designation,pancard,emaillID,null,null);

			PreparedStatement pstmt2=conn.prepareStatement("select * from BankDetails where associateID="+associateID);
			ResultSet bankdetailsRS=pstmt2.executeQuery();
			bankdetailsRS.next();
			int accountNumber=bankdetailsRS.getInt("accountNumber");
			String bankName=bankdetailsRS.getString("bankName");
			String ifscCode=bankdetailsRS.getString("ifscCode");
			associate.setBankdetails(new BankDetails(accountNumber,bankName,ifscCode));

			PreparedStatement pstmt3=conn.prepareStatement("select * from Salary where associateID="+associateID);
			ResultSet salaryRS=pstmt3.executeQuery();
			salaryRS.next();
			float basicSalary=salaryRS.getFloat("basicSalary");
			float companyPf=salaryRS.getFloat("companyPf");
			float conveyneceAllowance=salaryRS.getFloat("conveyneceAllowance");
			float epf=salaryRS.getFloat("epf");
			float gratuity=salaryRS.getFloat("gratuity");
			float grossSalary=salaryRS.getFloat("grossSalary");
			float hra=salaryRS.getFloat("hra");
			float monthlyTax=salaryRS.getFloat("monthlyTax");
			float netSalary=salaryRS.getFloat("netsalary");
			float otherAllowance=salaryRS.getFloat("otherAllowance");
			float personalAllownace=salaryRS.getFloat("personalAllownace");
			associate.setSalary(new Salary(basicSalary,hra,conveyneceAllowance,otherAllowance,personalAllownace,monthlyTax,epf,companyPf,gratuity,grossSalary,netSalary));
			associates.add(associate);
		}
		return associates;
	}
	@Override
	public void update(int associateID) throws SQLException {
		String newEmail="ashav.kumar@gmail.com";
		PreparedStatement pstmt1=conn.prepareStatement("update Associate set emailID="+newEmail+" where associateID="+associateID);
		try{
			pstmt1.executeUpdate();
			System.out.println("Updated Successfully");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
