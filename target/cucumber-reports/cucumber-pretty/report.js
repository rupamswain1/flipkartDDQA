$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("F:/workspace/flipkartQA/src/main/cucumber/com/flipkart/qa/feature/brokenLink.feature");
formatter.feature({
  "line": 1,
  "name": "Flipkart.com link validation",
  "description": "",
  "id": "flipkart.com-link-validation",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Validate broken links in flipkart.com",
  "description": "",
  "id": "flipkart.com-link-validation;validate-broken-links-in-flipkart.com",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Flipkart.com is opened",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "fetch all links from website",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "open link to check broken link",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "close browser",
  "keyword": "Then "
});
formatter.match({
  "location": "BrokenLinkStepDefination.flipkart_is_oepened()"
});
formatter.result({
  "duration": 524255475,
  "status": "passed"
});
formatter.match({
  "location": "BrokenLinkStepDefination.fetch_all_links_from_website()"
});
formatter.result({
  "duration": 7824267,
  "status": "passed"
});
formatter.match({
  "location": "BrokenLinkStepDefination.open_link_to_check_broken_link()"
});
formatter.result({
  "duration": 4147983,
  "status": "passed"
});
formatter.match({
  "location": "BrokenLinkStepDefination.closeBrowsers()"
});
formatter.result({
  "duration": 792731,
  "status": "passed"
});
