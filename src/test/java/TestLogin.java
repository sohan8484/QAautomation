import ObjectRepository.LoginPage;
import Utils.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class TestLogin {
    public WebDriver driver=null;
    @BeforeClass
    public void launchBrowser(@Optional("chrome") String BROWSER) throws Throwable {
        WebDriverManager.chromedriver().setup();
        if(BROWSER.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if(BROWSER.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();
        }
        else {
            driver=new ChromeDriver();
        }
    }

    @BeforeMethod
    public void login() throws Throwable {
        LoginPage login=new LoginPage(driver);
    }
    @Test
    public void loginNew(){}
}
