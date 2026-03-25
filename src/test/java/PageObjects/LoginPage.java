package PageObjects;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver ldriver;

    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(name = "username")
    @CacheLookup
    WebElement txtEmail;
    
    @FindBy(name="password")
    @CacheLookup
    WebElement txtPassword;
    
    @FindBy(tagName="button")
    @CacheLookup
    WebElement btnLogin;
    
    @FindBy(xpath="//a[text()='Logout']")
    WebElement lnkLogout;    
      
    @FindBy(xpath="//h6[normalize-space()='Dashboard']")
    WebElement Title;
    
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement userDropdown;
    
   

    public void clickLogout() {
    

    	    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));

    	    // Wait for modal to appear
    	    wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();
    	             
    	    wait.until(ExpectedConditions.elementToBeClickable(lnkLogout)).click();
    	   
    	}
       
    
    
    
    public void SetUserName(String uname)
    {
    	txtEmail.clear();
    	txtEmail.sendKeys(uname);
    }
    
    public void setPassword(String pwd)
    {
    	txtPassword.clear();
    	txtPassword.sendKeys(pwd);
    }
    
  
    
    public void clickLogin()
    {
    	btnLogin.click();
    }
    
    
    public boolean isDashboardDisplayed() {
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(Title)).isDisplayed();
    }

}