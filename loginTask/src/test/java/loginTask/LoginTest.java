package loginTask;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver ;
	
	@BeforeTest()
	public void launchBrowser() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Navigate to the required Website
		driver.navigate().to("https://www.jumia.com.eg/");
		
	}
	
	@Test
	public void clickAccountIconAndSelectMyAccountOption() throws InterruptedException {
		
		//close the popup window
		WebElement closeIcon = driver.findElement(By.cssSelector("section[class='cw'] button[class='cls']"));
		closeIcon.click();
		
		//click on Account dropDown
		WebElement accountDropDown = driver.findElement(By.xpath("(//div[@class=\"dpdw _pcent\"])[1]"));
		accountDropDown.click();
        
		//select My Account
		WebElement myAccountOption = driver.findElement(By.cssSelector("a[href*='account']:nth-child(2)"));
		myAccountOption.click();
		Thread.sleep(1000);

		//Enter valid email
		WebElement emailTxtField = driver.findElement(By.id("input_identifierValue"));
		emailTxtField.sendKeys("testrc@mailinator.com");
		WebElement continueBTN = driver.findElement(By.cssSelector("[type='submit']"));
		continueBTN.click();
		
		//Enter valid password
		WebElement passwordTxtField = driver.findElement(By.name("password"));
		passwordTxtField.sendKeys("Abs125$GE");
		
		//click on login button
		WebElement loginBTN = driver.findElement(By.id("loginButton"));
		loginBTN.click();
		
		WebElement skipNowBTN = driver.findElement(By.id("btn-skip-passkeys-enrollment"));
		skipNowBTN.click();
		
		//Verify that user is logged in successfully
		String userName = driver.findElement(By.cssSelector("label[for='dpdw-login']")).getText();
		Assert.assertEquals(userName, "Hi, Ahmed");
	}
	
	@AfterTest()
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
}
