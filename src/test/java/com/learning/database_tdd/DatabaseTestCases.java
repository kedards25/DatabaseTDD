package com.learning.database_tdd;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.learning.database_tdd.models.UserModel;
import com.learning.database_tdd.services.DAO_Impl;
import com.learning.database_tdd.services.IDAO_Service;

public class DatabaseTestCases {

	IDAO_Service daoService=new DAO_Impl();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Ignore
	@Test
	public void testConn() {
		boolean isConnected=daoService.getConnected();
		assertEquals(true, isConnected);
	}
	
	@Ignore
	@Test
	public void getDataTest()
	{
		List<UserModel> modelList=daoService.getData();
		//System.out.println(modelList.get(5).getName());
		assertEquals(true, (modelList.size()>0));
	}
	
	@Ignore
	@Test
	public void insertDataTest()throws SQLException
	{
		UserModel model=new UserModel( 101,"Gaurang", "OOPS");
		int no_of_Rows=daoService.insertDetails(model);
		assertEquals(1, no_of_Rows);
	}
	
	@Ignore
	@Test
	public void updateDataTest()
	{
		UserModel model=new UserModel( 101,"Gaurang", "PIE");
		int no_of_RowsUpdated=daoService.updateData(25,model);
		assertEquals(1, no_of_RowsUpdated);
	}
	
	@Test
	public void getByIdTest()
	{
		UserModel model=daoService.getDataById(25);
		assertEquals("Gaurang", model.getName());
	}

}
