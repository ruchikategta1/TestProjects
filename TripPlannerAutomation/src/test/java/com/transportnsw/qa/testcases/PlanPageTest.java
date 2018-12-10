package com.transportnsw.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.transportnsw.qa.base.Testbase;
import com.transportnsw.qa.pages.PlanPage;
import com.transportnsw.qa.pages.listPage;

public class PlanPageTest extends Testbase {

	 PlanPage obj;
	 listPage obj2;
	
	public PlanPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialisation();
		obj = new PlanPage();
	}
	
	@Test(priority=1)
	public void ValidatePageTitle() {
		String title = obj.validatePageTitle();
		Assert.assertEquals(title, "Trip Planner and Next Departures | transportnsw.info");	
	}
	
	@Test(priority=2)
	public void TripPlanTest() {
		obj2 = obj.TripPlanList(prop.getProperty("from"), prop.getProperty("to"));
		}
	
	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}
	
	
}
