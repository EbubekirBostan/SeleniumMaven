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

public class taskRadioButton {
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
       // driver.quit();
    }
    @Test
    public void test(){
        //Go to URL: https://demoqa.com/radio-button
        //Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
        //Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.
        driver.get("https://demoqa.com/radio-button");
        WebElement yesButton= driver.findElement(By.xpath("//label[@for='yesRadio']"));
        // burada radiobutton locate edilemli buarada hata yaptın..
        yesButton.click();
        WebElement yesMesagge= driver.findElement(By.xpath("//p[text()='You have selected ']"));
        System.out.println(yesMesagge.getText());
        Assert.assertFalse("Seçilmiyor",yesButton.isSelected());
        WebElement impressiveButton= driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveButton.click();
        WebElement impressiveMesagge= driver.findElement(By.xpath("//p[text()='You have selected ']"));
        System.out.println(impressiveMesagge.getText());
        Assert.assertFalse("Seçilmiyor", impressiveButton.isSelected());
        WebElement noButton = driver.findElement(By.xpath("//label[@for='noRadio']"));
        noButton.click();
        Assert.assertTrue("Seçilmiyor", !noButton.isEnabled());
    }
}
