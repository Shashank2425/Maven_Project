package org.openqa.selenium;

import org.junit.Test;
import org.testng.annotations.DataProvider;

public class Data_Provider {
	public class TestNG {
	    
	    @Test/*(//dataProvider = "getData")*/
	    public void setData(String Username, String password)
	    {
	        System.out.println("User name : "+Username);
	        System.out.println("password : "+password);
	        
	        System.out.println("=============");
	    }
	    
	    @DataProvider
	    public Object[][] getData()
	    {
	        
	        Object[][] data = new Object[3][2];
	        
	        // row 0
	        data[0][0] = "Tester 1";
	        data[0][1] ="pwd 1";
	        
	        // 1st row
	        data[1][0] = "Tester 2";
	        data[1][1] ="pwd 2";
	        
	        // 2nd row
	        data[2][0] = "Tester 3";
	        data[2][1] ="pwd 3";
	        
	        return data;
	        
	    }
	}
}
