package com.flipkart.qa.rules;

public interface AllTestRule {

	public void InitializeBrowserAndReport(String browser,String headless, String imageDisable);
	public void closeBrowserandReport();
}
