package com.flipkart.qa.stepDefination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BrokenLinkStepDefination 
{
	@Given("^Flipkart.com is opened$")
	public void flipkart_is_oepened()
	{
		System.out.println("Flipkart opened");
	}
	
	@Then("^fetch all links from website$")
	public void fetch_all_links_from_website()
	{
		System.out.println("Link fetched");
	}
	
	@Then("^open link to check broken link$")
	public void open_link_to_check_broken_link()
	{
		System.out.println("Website opened");
	}
	
	
	
	@Then("^close browser$")
	public void closeBrowsers()
	{
		System.out.println("Browser closed");
	}
}
