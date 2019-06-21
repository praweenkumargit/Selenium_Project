package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.bean.RegisterBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class RetailsDAO {
Properties properties; 
	
	public RetailsDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<RegisterBean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<RegisterBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<RegisterBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				RegisterBean temp = new RegisterBean(); 
				temp.setfirstName(gc.rs1.getString(1));
				temp.setlastName(gc.rs1.getString(2));
				temp.setemail(gc.rs1.getString(3));
				temp.settelePhone(gc.rs1.getString(4));
				temp.setaddress1(gc.rs1.getString(5));
				temp.setcity(gc.rs1.getString(6));
				temp.setPassword(gc.rs1.getString(7));
				temp.setconfirmPassword(gc.rs1.getString(8));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 

}
}
