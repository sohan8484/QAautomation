import ObjectRepository.ProductPage;
import Utils.BaseClass;
import Utils.IPathConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestProductSearch extends BaseClass {
    @Test
    public void onProductPage() throws InterruptedException {
        ProductPage pp = new ProductPage(this.driver);
        pp.verifyProductPage();
        this.driver.navigate().refresh();
        Thread.sleep(10);
        String productURl = IPathConstants.Product_URL;
        String currentURl = this.driver.getCurrentUrl();
        sa.assertEquals(productURl, currentURl);
        sa.assertAll();
        System.out.println(currentURl);
        pp.searchProduct();
    }
}
