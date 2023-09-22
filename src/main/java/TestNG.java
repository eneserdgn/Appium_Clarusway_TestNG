import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestNG {
    AndroidDriver driver;

    @BeforeMethod
    public void beforeTest() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("Android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("trendyol.com");
        caps.setAppActivity("com.trendyol.common.splash.impl.ui.SplashActivity");
        caps.setNoReset(false);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test1() {
        WebElement element = driver.findElement(By.className("android.widget.TextView"));
        String elementText = element.getText();
        Assert.assertEquals(elementText, "Sana en uygun ürünleri sunabilmemiz için bize yardımcı olur musun?");
    }

    @Test
    public void test2() {
        WebElement element = driver.findElement(By.id("trendyol.com:id/buttonSelectGenderMan"));
        element.click();
        String elementText = driver.findElement(By.id("trendyol.com:id/textViewOpenNotification")).getText();
        Assert.assertEquals(elementText, "Yeni ürün ve kampanyaları önce sen öğrenmek ister misin?");
    }

    @Test
    public void test3() {
        WebElement element = driver.findElement(By.id("trendyol.com:id/buttonSelectGenderMan"));
        element.click();
        driver.findElement(By.id("trendyol.com:id/imageButtonClose")).click();
        Assert.assertEquals(driver.findElement(By.id("trendyol.com:id/textViewTooltipTitle")).getText(), "Sana Özel Ürün ve Koleksiyonları Keşfet!");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
