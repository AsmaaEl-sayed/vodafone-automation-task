package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ParallelTest  {
			public WebDriver driver;
		        @Test
		        public void FirefoxTest() {	 
		            //Initializing the firefox driver (Gecko)
			    driver = new FirefoxDriver();	  
		         }
		 
		        @Test
		 	public void ChromeTest()
		 	{ 
			  //Initialize the chrome driver
			  driver = new ChromeDriver();
			
		 	}
	}


