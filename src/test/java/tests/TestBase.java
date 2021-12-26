package tests;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import data.ExcelReader;

public class TestBase extends ScreenShoots{
 
	public static  String getScreenshootPath() throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenShoots/image.png";
		FileUtils.copyFile(source, new File(path));
		return path;
	}	
	public static WebDriver driver;

	@DataProvider(name="Data")
	public Object [][] getURL() throws IOException{
		ExcelReader ER=new ExcelReader();
		return ER.getExcelData();
	}
	@BeforeSuite
	public void startDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	}

	@Test(dataProvider = "Data")
	public void navigteToGoogle(String URL) throws IOException {
		driver.navigate().to(URL);
		ExtentTest test = extent.createTest("google");
		test.pass("pass", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshootPath()).build());
	}


	@AfterSuite
	public void closeDriver(){
		driver.quit();
	}
}