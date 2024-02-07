import Utils.BaseClass;
import Utils.IPathConstants;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestLogin extends BaseClass {
    @Test
    public void loginNew(){

        String expectedUrl = IPathConstants.Homepage_URL;
        String actualUrl = driver.getCurrentUrl();
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(expectedUrl, actualUrl);
        sa.assertAll();
    }
}
