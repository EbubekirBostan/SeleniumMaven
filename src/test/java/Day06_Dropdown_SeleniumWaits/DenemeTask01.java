package Day06_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DenemeTask01 {
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
        //driver.quit();
    }
    // 1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    // 3) Click on Shop Menu
    //4) Now click on Home menu button
    //5) Test whether the Home page has Three Sliders only
    //6) The Home page must contains only three sliders


    @Test
    public void shop(){
        driver.get("http://practice.automationtesting.in/");
        WebElement shopButton = driver.findElement(By.id("menu-item-40"));
        shopButton.click();
        WebElement alertButton= driver.findElement(By.xpath("//span[@class='ns-2fw04-e-18']"));
        alertButton.click();
        WebElement homeButton= driver.findElement(By.linkText("Home"));
        homeButton.click();
        WebElement imgButton= driver.findElement(By.xpath("//img[@alt='Shop Selenium Books']"));
        WebElement okButton= driver.findElement(By.id("n2-ss-6-arrow-next"));
        okButton.click();
        okButton.click();
    }
}
