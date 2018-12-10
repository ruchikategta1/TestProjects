package com.transportnsw.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.transportnsw.qa.util.TestUtil;

public class Testbase {

	   public static WebDriver driver;
	   public static Properties prop;		
	   
		public Testbase()	{	
			try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Ruchika\\Eclipse_Workspace"
					+"\\TripPlannerAutomation\\src\\main\\java\\com\\transportnsw\\qa\\config\\config.properties");
			prop.load(ip);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}
		
		public static void initialisation() {
			String browserName= prop.getProperty("browser");
			
			if(browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if (browserName.equalsIgnoreCase("chrome")) {
				//System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver", "D:\\Ruchika\\Selenium_Prerequisites\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			
		}
		
}
