package com.flipkart.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.flipkart.qa.ObjectManager.ObjectManager;

public class HomePage 
{
	
	ObjectManager operation=null;
	//Page Elements
	By LoginPopUpClose=By.xpath("//button[@class='_2AkmmA _29YdH8']");
	By linkTag=By.tagName("a");
	
	public HomePage()
	{
		operation=new ObjectManager();
	}
	
	public void closeLoginPopUp()
	{
		
		operation.click(LoginPopUpClose, "Close button to close Login Pop-up");
	}
	
	public List<String> findLinks()
	{
		new HomePage().closeLoginPopUp();
		List<WebElement> aTag=operation.findElements(linkTag);
		List<String> links=new ArrayList<String>();
		for(int i=0;i<aTag.size();i++)
		{
			String rawLink=aTag.get(i).getAttribute("href");
			if(!(rawLink==null|| rawLink.equals(" ")||rawLink.startsWith("java")||(!(rawLink.startsWith("http")))))
					{
						links.add(rawLink);
					}
		}
		System.out.println("Total Links feched "+links.size());
		return links;
	}
	
}
