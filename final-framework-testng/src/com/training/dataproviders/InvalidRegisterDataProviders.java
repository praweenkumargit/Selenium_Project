package com.training.dataproviders;

import org.testng.annotations.DataProvider;

import com.training.readexcel.ApachePOIExcelRead;

public class InvalidRegisterDataProviders {
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\PRAWEENKUMAR\\Desktop\\Selenium Project Test Data\\TestData2.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}

}
