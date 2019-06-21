package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.AddCategoriesBean;
import com.training.bean.RegisterBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class RetailsAddCategoriesDAO {
Properties properties; 
	
	public RetailsAddCategoriesDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<AddCategoriesBean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<AddCategoriesBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<AddCategoriesBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				AddCategoriesBean temp = new AddCategoriesBean(); 
				temp.setcategoryName(gc.rs1.getString(1));
				temp.setdescription(gc.rs1.getString(2));
				temp.setmetaTagTitle(gc.rs1.getString(3));
				temp.setmetaTagDescription(gc.rs1.getString(4));
				

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 

}

}
