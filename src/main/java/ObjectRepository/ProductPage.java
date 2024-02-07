package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    static WebDriver driver;
    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()=' Products']")
    private WebElement productElement;

    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement search;

    @FindBy(xpath = "//div[@class='productinfo text-center']/descendant::p")
    private List<WebElement> getProductList;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement searchbtn;

    public void verifyProductPage(){
        productElement.click();
    }

    public void searchProduct() throws InterruptedException {
        productElement.click();
        Thread.sleep(10);
        search.sendKeys("tshirt");
        searchbtn.click();
        int count = getProductList.size();
        for (int i = 0; i < count; i++) {
            System.out.println(getProductList.get(i).getText());
        }
    }
}
