package com.learning.database_tdd.frontend;

import java.util.Iterator;
import java.util.List;

import com.learning.database_tdd.models.UserModel;
import com.learning.database_tdd.services.DAO_Impl;
import com.learning.database_tdd.services.IDAO_Service;

public class ShowUserDetails {

	IDAO_Service daoService=new DAO_Impl();
	public void showDetails()
	{
		List<UserModel> modelList=daoService.getData();
		for(UserModel modelObj:modelList) {
			System.out.println(modelObj);
		}
		
	}
	
}
