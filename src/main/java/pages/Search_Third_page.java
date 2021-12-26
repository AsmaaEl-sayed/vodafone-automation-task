package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search_Third_page extends PageBase {

	public Search_Third_page(WebDriver driver) {
		super(driver);
	
	}
	
	//list of search result in the second page
	 @FindBy(className = "g")
	 List<WebElement> ElementsList_3 ;
	
	 //third page number in the third page 
	 @FindBy(xpath = "//td[@class=\"YyVfkd\"]")
		public WebElement thirdAssert;
	 
	//function that count search result in the third page 
	 public void countElement() {
		  System.out.println("The number of links is "+ ElementsList_3.size());
	 }
	 public int page3Count = ElementsList_3.size();
	
}
