package Utils;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BaseClass extends ListenersClass{
    public static WebDriver StaticDriver;
    public WebDriver driver=null;
    public FileUtility fLib = new FileUtility();
    public SoftAssert sa = new SoftAssert();


    @Parameters(value= {"browser"})
    @BeforeClass
    public void launchBrowser(@Optional("chrome") String BROWSER) throws Throwable {
        WebDriverManager.chromedriver();
        if(BROWSER.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if(BROWSER.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();
            driver.manage().window().maximize();
        }
        else if(BROWSER.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        else
            driver= new EdgeDriver();
        StaticDriver=driver;
        String URL=fLib.getPropertyKeyValue("url");
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        driver.quit();
    }

    @AfterClass
    public void closeBrowser() {
        System.out.println("closing browser");
    }

}