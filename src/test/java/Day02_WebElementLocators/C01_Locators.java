package Day02_WebElementLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Locators {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.linkedin.com");
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){
       driver.quit();
    }



    @Test
    public void idLocator(){
        //id Locator -> "session_key"
        WebElement email=driver.findElement(By.id("session_key"));
        email.sendKeys("Clarusway selenium dersinden selamlar");

    }

    @Test
    public void nameLocator(){
        // name locator -> "session_password"
        WebElement password=driver.findElement(By.name("session_password"));
        password.sendKeys("Sifre");

    }

    @Test
    public void classLocator(){
        WebElement email=driver.findElement(By.className("input__input"));
        email.sendKeys("Class locator test");
    }
    @Test
    public void tagLocator(){
        List<WebElement> emailList= driver.findElements(By.tagName("input"));
        WebElement email = emailList.get(1);
        email.sendKeys("Tag locator test");
    }
    @Test
    public void linkTextLocator(){
        WebElement forgotPwd = driver.findElement(By.linkText("Şifrenizi mi unuttunuz?"));
        forgotPwd.click();
    }
    @Test
    public void partialLinkTextLocator(){
        WebElement forgotPwd = driver.findElement(By.partialLinkText("unuttunuz"));
        forgotPwd.click();
    }

    @Test
    public void absoluteXpath(){
        WebElement email = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[2]/div[1]/input"));
        email.sendKeys("Bekir xpathi sevdi");
    }

    @Test
    public void relativeXpath(){
        // xpath locator
        WebElement email = driver.findElement(By.xpath("//input[@id='session_key']"));
        email.sendKeys("Bekir xpathi sevdi");

    }
    @Test
    public void multipleAttributeXpath(){

        WebElement email = driver.findElement(By.xpath("//input[@class='input__input'][@name='session_key']"));
        email.sendKeys("Bekir xpathi sevdi");

    }
    @Test
    public void andOrXpath(){

        WebElement email = driver.findElement(By.xpath("//input[@class='input__input' and @autocomplete='username']"));
        email.sendKeys("Bekir xpathi sevdi");
        WebElement emailOr = driver.findElement(By.xpath("//input[@id='session_key' or @name='session_password']"));
        email.sendKeys("Bekir xpathi sevdi");

    }
    @Test
    public void containsXpath(){

        WebElement email = driver.findElement(By.xpath("//input[contains(@id,'session')]"));
        email.sendKeys("Bekir xpathi sevdi");


    }





}
