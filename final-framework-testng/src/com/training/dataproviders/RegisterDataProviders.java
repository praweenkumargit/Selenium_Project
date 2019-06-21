package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.RegisterBean;
import com.training.dao.ELearningDAO;
import com.training.dao.RetailsDAO;
import com.training.readexcel.ApachePOIExcelRead;

public class RegisterDataProviders {
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\PRAWEENKUMAR\\Desktop\\Selenium Project Test Data\\TestData.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		//List<LoginBean> list = new ELearningDAO().getLogins(); 
		List<RegisterBean> list = new RetailsDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RegisterBean temp : list){
			Object[]  obj = new Object[8]; 
			obj[0] = temp.getfirstName(); 
			obj[1] = temp.getlastName();
			obj[2] = temp.getemail(); 
			obj[3] = temp.gettelePhone(); 
			obj[4] = temp.getaddress1(); 
			obj[5] = temp.getcity(); 
			obj[6] = temp.getPassword(); 
			obj[7] = temp.getconfirmPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}

}
