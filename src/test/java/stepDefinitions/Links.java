package stepDefinitions;

import java.time.Duration;
import java.util.List;

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

public class Links {
	
	public WebDriver driver;
    public LoginPage lp;
    
    
	@Given("User launch Chrome browser and login with valid credentials")
	public void user_launch_chrome_browser_and_login_with_valid_credentials() {
		driver = new ChromeDriver();
        lp = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[normalize-space()='Login']")));
		
	}

	@When("User lands on homepage")
	public void user_lands_on_homepage() {
		WebDriverWait waitt= new WebDriverWait(driver,Duration.ofSeconds(10));
		waitt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		lp.SetUserName("Admin");
        lp.setPassword("admin123");

	}

	@Then("Find all the broken and active links on homepage")
	public void find_all_the_broken_and_active_links_on_homepage() {
	     List <WebElement> links= driver.findElements(By.tagName("a"));
	     System.out.println("Links present on the page: "+links.size());
	     for (WebElement link : links) {
	         String linkText = link.getText();

	         if (!linkText.isEmpty()) {   // Avoid blank links
	             System.out.println("Links are:  "+linkText);
	         }
	}

}
}
