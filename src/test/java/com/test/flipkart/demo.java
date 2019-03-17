package com.test.flipkart;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.flipkart.qa.ReadOperation.ReadExcel;
import com.flipkart.qa.ReadOperation.ReadPropertyFile;

public class demo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(new ReadPropertyFile().readProperty("customerDetailsFilePath"));
		List<Object> a=ReadExcel.getData(new ReadPropertyFile().readProperty("customerDetailsFilePath"));
		for(int i=0;i<a.size();i++)
		{
			List<String> b=(List<String>)a.get(i);
			for(int j=0;j<b.size();j++)
			{
				System.out.println(b.get(j));
			}
		}
	}

}
