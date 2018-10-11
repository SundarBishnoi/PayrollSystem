package com.cg.payroll.client;

import com.cg.payroll.util.ConnectionProvider;

public class ConnectionTest1 {

	public static void main(String[] args) {
		if(ConnectionProvider.getDBConnection()!=null)
			System.out.println("database Connect");
		else
			System.out.println("Some Problem");
	}
}
