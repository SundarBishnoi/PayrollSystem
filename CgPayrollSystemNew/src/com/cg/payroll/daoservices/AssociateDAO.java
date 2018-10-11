package com.cg.payroll.daoservices;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cg.payroll.beans.Associate;
public interface AssociateDAO {
	Associate save(Associate associate) throws SQLException;      // Abstract Method to save data into Database
	Associate findOne(int associateID) throws SQLException;		//Abstract Method to know whether associateId exist or not
	ArrayList<Associate> findAll() throws SQLException;				//Abstract Method to get out Table Data
	void update(int associateID) throws SQLException;					//Abstract Method to update Salary table 
}
