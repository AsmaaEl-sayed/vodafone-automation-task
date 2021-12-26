package tests;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import pages.GooglePage;
import pages.Search_First_Page;
import pages.Search_Second_Page;
import pages.Search_Third_page;

public class searchTest extends TestBase{
	GooglePage googlePageOBJ;
	Search_First_Page Search_First_PageOBJ;
	Search_Second_Page Search_Second_PageOBJ;
	Search_Third_page Search_Third_pageOBJ;
	
	
	@BeforeTest
	public void beforeTest() {
		googlePageOBJ = new GooglePage(driver);
		Search_First_PageOBJ =new Search_First_Page(driver);
		Search_Second_PageOBJ = new Search_Second_Page(driver);
		Search_Third_pageOBJ = new Search_Third_page(driver);
		
	}
	
	@Test(priority = 1 )
	public void GoogleSearch() throws InterruptedException, IOException {
		ExtentTest test = extent.createTest("search");
		//search with vodafone in google search box
		googlePageOBJ.Search("vodafone");
		
		test.info("search with vodafone", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshootPath()).build());
		
		//assert that vodafone logo is appeared in the first search page  
		Search_First_PageOBJ.vodafoneImage.isDisplayed();
		
	
		//scroll down in the first page 
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		test.info("scroll down" , MediaEntityBuilder.createScreenCaptureFromPath(getScreenshootPath()).build());
		
		
		
		//navigate to second page 
		Search_First_PageOBJ.Naigate_To_Second_Page();
		test.info("click on 2 page link" , MediaEntityBuilder.createScreenCaptureFromPath(getScreenshootPath()).build());
		
		
		
		//count elements in the second  page 
		Search_Second_PageOBJ.countElement();
		
		
		//scroll down in the 
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		test.info("scroll down" , MediaEntityBuilder.createScreenCaptureFromPath(getScreenshootPath()).build());
		
		
		//assert that we are in the second page
		System.out.println(Search_Second_PageOBJ.secondAssert.getText());
		assertEquals("2", Search_Second_PageOBJ.secondAssert.getText());
		
		
		//navigate to third page 
		Search_Second_PageOBJ.NavigateToThirdPage();
		test.info("scroll down" , MediaEntityBuilder.createScreenCaptureFromPath(getScreenshootPath()).build());
		
		
		
		//assert that we are in the third page 
		System.out.println(Search_Third_pageOBJ.thirdAssert.getText());
		assertEquals("3", Search_Third_pageOBJ.thirdAssert.getText());
		
	}

	@Test(priority = 2)
	// verify if search result in second page and third page equal or not
	 public void validateResults() {
		  if(Search_Second_PageOBJ.page2Count != Search_Third_pageOBJ.page3Count) {
			  System.out.println("True");
		  }
		  else {
			  System.out.println("False");
		}
		
}
	
}
	
