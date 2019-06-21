package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.AddCategoriesBean;
import com.training.bean.RegisterBean;
import com.training.dao.RetailsAddCategoriesDAO;
import com.training.dao.RetailsDAO;
import com.training.readexcel.ApachePOIExcelRead;

public class CategoryNameDataProviders {
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\PRAWEENKUMAR\\Desktop\\Selenium Project Test Data\\TestData3.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "db-inputs2")
	public Object [][] getDBData() {

		//List<LoginBean> list = new ELearningDAO().getLogins(); 
		List<AddCategoriesBean> list = new RetailsAddCategoriesDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(AddCategoriesBean temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getcategoryName(); 
			obj[1] = temp.getdescription();
			obj[2] = temp.getmetaTagTitle(); 
			obj[3] = temp.getmetaTagDescription(); 
			
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}

}
