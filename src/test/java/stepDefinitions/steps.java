 
	package stepDefinitions;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;



import org.junit.Assert;

	import PageObjects.LoginPage;
	import io.cucumber.java.en.*;
    

	public class steps {

	   public WebDriver driver;
	    public LoginPage lp;

	    @Given("User launch Chrome browser")
	    public void user_launch_chrome_browser() {
	         
	       driver = new ChromeDriver();
	        lp = new LoginPage(driver);
	        driver.manage().window().maximize();
	        

	    }

	    @When("User opens url {string}")
	    public void user_opens_url(String url) {
	        driver.get(url);
	    }

	    @When("User enters Email as {string} and Password as {string}")
	    public void user_enters_email_and_password(String username, String password) {
	        lp.SetUserName(username);
	        lp.setPassword(password);
	    }

	    @When("Click on login")
	    public void click_on_login() {
	        lp.clickLogin();
	    }

	    @Then("page title should be {string}")
	    public void page_title_should_be(String expectedTitle)  {
	        Assert.assertEquals(expectedTitle, driver.getTitle());
	       
	    }

	    @When("User click on log out link")
	    public void user_click_on_log_out_link()  {
	    
	        lp.clickLogout();
	       
	    }

	     
	    @Then("close browser")
	    public void close_browser() {
	        driver.quit();
	    }
	}


