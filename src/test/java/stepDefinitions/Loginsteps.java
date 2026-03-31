package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.LoginPage;
 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
 

public class Loginsteps {
	
	public WebDriver driver;
    public LoginPage lp;

	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		driver = new ChromeDriver();
        lp = new LoginPage(driver);
        driver.manage().window().maximize();
        
	}

	@When("User opens url {string}")
	public void user_opens_url(String string) {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[normalize-space()='Login']")));
	}

	@When("User enters Username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String string, String string2) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		lp.SetUserName("Admin");
        lp.setPassword("admin123");

	}

	@When("Click on login")
	public void click_on_login() {
		lp.clickLogin();
	}

	@Then("User should be on Dashboard page")
	public void user_should_be_on_dashboard_page(){
	    Assert.assertTrue(lp.isDashboardDisplayed());
	}
	
	@When("User click on log out link")
	public void user_click_on_log_out_link() {
		lp.clickLogout();

	}
	@Then("User should be on Login page")
	public void user_should_be_on_login_page() {
	    WebElement loginBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));

	    Assert.assertTrue(loginBtn.isDisplayed());
	}

	 
@Then("close browser")
	public void close_browser() {
	driver.quit();

	}



}
