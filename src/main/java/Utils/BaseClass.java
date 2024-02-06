package Utils;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class BaseClass extends ListenersClass{
    public static WebDriver StaticDriver;
    public WebDriver driver=null;
    public FileUtility fLib = new FileUtility();
    public SoftAssert sa = new SoftAssert();


    @Parameters(value= {"browser"})
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
        StaticDriver=driver;
        String URL=fLib.getPropertyKeyValue("url");
        driver.get(URL);
    }

    @BeforeMethod
    public void login() throws Throwable {
        LoginPage login=new LoginPage(driver);
        String USERNAME=fLib.getPropertyKeyValue("username");
        String PASSWORD=fLib.getPropertyKeyValue("password");
        login.loginToWeb(USERNAME, PASSWORD);
    }

    @AfterMethod
    public void logout() {
    }

    @AfterClass
    public void closeBrowser() {
        System.out.println("closing browser");
    }

}