package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='name']")
    private WebElement name;

    @FindBy(xpath = "//input[@name='email' and @data-qa='signup-email']")
    private WebElement emailAddress;

    public WebElement getName() {
        return name;
    }

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public void loginToWeb(String userName, String email){
        name.sendKeys(userName);
        emailAddress.sendKeys(email);
    }
}
