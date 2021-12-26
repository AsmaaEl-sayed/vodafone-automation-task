package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Search_First_Page extends PageBase {
	WebDriver driver;

	public Search_First_Page(WebDriver driver) {
		super(driver);
	}
	//vodafone icon in the first page
	@FindBy(xpath = "//div[@jscontroller=\"M0hWhd\"]//img")
	public WebElement vodafoneImage;

	//second page number in the first page 
	@FindBy(xpath="//a[@aria-label='Page 2']")
	WebElement secondPageLink;

	// function that navigate to the second page 
	public void Naigate_To_Second_Page() throws InterruptedException {	

		click(secondPageLink);	
	}




}