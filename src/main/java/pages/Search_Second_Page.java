package pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search_Second_Page extends PageBase {
	public Search_Second_Page(WebDriver driver) {
		super(driver);
	}

	//list of search result in the second page 
	@FindBy(className = "g")
	public List<WebElement> ElementsList ;

	//second page number in the second page 
	@FindBy(xpath = "//td[@class=\"YyVfkd\"]")
	public WebElement secondAssert;

	//the third page link 
	@FindBy(xpath="//a[@aria-label='Page 3']")
	WebElement thirdPageLink;

	//function that count search result in the second page 
	public void countElement() {
		System.out.println("The number of links is "+ ElementsList.size());
	}

	// function that navigate to third page 
	public void NavigateToThirdPage() {
		click(thirdPageLink);	
	}
	public int page2Count = ElementsList.size();
}
