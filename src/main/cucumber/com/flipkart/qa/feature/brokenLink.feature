Feature: Flipkart.com link validation

Scenario: Validate broken links in flipkart.com
Given Flipkart.com is opened
Then fetch all links from website
Then open link to check broken link
Then close browser
