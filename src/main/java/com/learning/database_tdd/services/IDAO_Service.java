package com.learning.database_tdd.services;

import java.sql.SQLException;
import java.util.List;

import com.learning.database_tdd.models.UserModel;

public interface IDAO_Service {

	boolean getConnected();

	List<UserModel> getData();

	int insertDetails(UserModel model)throws SQLException;

	int updateData(int i, UserModel model);

	UserModel getDataById(int i);

}
