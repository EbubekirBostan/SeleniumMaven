package Day05_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButtons {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void radioButtons(){
        //    Go to URL:  https://www.facebook.com/
        //    Click on Create an Account button.
        //    Then click on the radio buttons.
        driver.get("https://www.facebook.com/");
      WebElement registerButton = driver.findElement(By.xpath("//a[contains(@data-testid,'registration-form')]"));
        registerButton.click();
        WebElement kadinRadio = driver.findElement(By.xpath("//label[.='Kadın']"));
        WebElement erkekRadio = driver.findElement(By.xpath("//label[.='Erkek']"));
        kadinRadio.click();
        erkekRadio.click();
        Assert.assertTrue(erkekRadio.isSelected());
        Assert.assertTrue(!kadinRadio.isSelected());
    }
}
