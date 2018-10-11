package com.cg.payroll.client;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
public class MainClass {
	public static void main(String[] args) throws PayrollServicesDownException,AssociateDetailsNotFoundException{
		System.out.println("Hello world");
		PayrollServices payrollServices =  new PayrollServicesImpl();
		 int associateID=payrollServices.accceptAssociateDetails(20000,"Ashav", "Kumar","ashav.kr@gmail.com", "YTP", "Sr.Analyst", "HHTPK0434B",  17300, 450, 850, 5336355, "SBI", "SBIN001882");
		System.out.println(associateID);
		Associate associate = payrollServices.getAssociateDetails(associateID);
		payrollServices.calculateNetSalary(associateID);
		System.out.println(associate.toString());

	/* 
	 Associate associate1= new Associate(1,1000,"Sundar","Bishnoi","Tech","Tech Lead", "DLVPB10D","sund@gmail.com");
	 Associate associate2= new Associate(2,2000,"Himesh","Bishnoi","Tech","Tech Lead","PLVPB10D","hund@gmail.com");		
	 Associate associate3= new Associate(3,3000,"dinesh","Bishnoi","sales","Manager", "DKVPB10D","dine@gmail.com");
	 Associate associate4= new Associate(4,4000, "satish","koai","hr","Lead", "KHDHKJHD","hdund@gmail.com");
	 Associate associate5= new Associate(5,5000, "Kawal","singh","pantry","pantry manager", "DLVPB154","kawald@gmail.com");
	 Associate associate6= new Associate(6,6000,"kajol","sharma","Tech","Manager","JLVPB10D","ka@gmail.com");
	 Associate associate7= new Associate(7,7000,"Kiva","Dish","sales","Tech Lead","RLVFPB10D","ssaund@gmail.com");
	 Associate associate8= new Associate(8,8000, "Pundr","gfskdg","Marketing","Manager","LLVPB10D","fsnd@gmail.com");
	 Associate associate9= new Associate(9,9000, "Uundal","shgfhnoi","Random","Manager", "KLVPB10D","pund@gmail.com");
	 Associate associate10= new Associate(10,10000,"Sr","ish","X","Y","HGLVPB10D","x@gmail.com");
	*/
  }
}






