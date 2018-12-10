package com.transportnsw.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.transportnsw.qa.base.Testbase;

public class PlanPage extends Testbase {
	
	//creating Page factory - OR (Object repository)
	
	@FindBy(id="search-input-From")
	WebElement fromfield;
	
	@FindBy(xpath="//input[@id='search-input-To']")
	WebElement tofield;
	
	@FindBy(id="search-button")
	WebElement gobtn;
	
	//Intializing the page objects using "initElemnet" method
	
	public PlanPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Defining actions for all the created and initialized WebElements
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public listPage TripPlanList(String frm, String to) {
		fromfield.sendKeys("frm");
		tofield.sendKeys("to");
		gobtn.click();
		
		return new listPage();
	}
	
	
	
		

}
