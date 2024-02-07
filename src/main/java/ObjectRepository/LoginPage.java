package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "input[data-qa='login-email']")
    private WebElement name;

    @FindBy(css = "input[placeholder='Password']")
    private WebElement emailAddress;
    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginBtn;



    public WebElement getName() {
        return name;
    }

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public void loginToWeb(String userName, String email){
        name.sendKeys(userName);
        emailAddress.sendKeys(email);
        loginBtn.click();
    }

}
