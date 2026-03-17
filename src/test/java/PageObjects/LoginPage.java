package PageObjects;



import java.time.Duration;

import org.openqa.selenium.By;
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

    @FindBy(id = "Email")
    @CacheLookup
    WebElement txtEmail;
    
    @FindBy(id="Password")
    @CacheLookup
    WebElement txtPassword;
    
    @FindBy(xpath="//button[normalize-space()='Log in']")
    @CacheLookup
    WebElement btnLogin;
    
    @FindBy(xpath="//a[normalize-space()='Logout']")
    @CacheLookup
    WebElement lnkLogout;    
    

    public void clickLogout() {
    

    	    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));

    	    // Wait for modal to disappear
    	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
    	            By.id("loadCustomerStatisticsAlert-action-alert")));

    	    wait.until(ExpectedConditions.elementToBeClickable(lnkLogout));
    	    lnkLogout.click();
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
    
    public void ClickLogout()
    {
    	lnkLogout.click();
    }
    
    public void clickLogin()
    {
    	btnLogin.click();
    }
}