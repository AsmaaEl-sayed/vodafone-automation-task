package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends PageBase {

	public GooglePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(name = "q")
	WebElement googleSearchInput;
	@FindBy(xpath = "//div[@class='CcAdNb']//span[@class='QCzoEc z1asCe MZy1Rb']")
	WebElement googleSearchBTN;

	public void Search(String searchInput) {
		sendvalues(googleSearchInput, searchInput);
		click(googleSearchBTN);
		googleSearchInput.sendKeys(Keys.ENTER);
	}

}
