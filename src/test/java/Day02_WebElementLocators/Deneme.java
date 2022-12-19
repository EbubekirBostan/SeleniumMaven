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

public class Deneme {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.sahibinden.com/");
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void search(){
        //searchText
        WebElement idSearch = driver.findElement(By.id("searchText"));
        idSearch.sendKeys("volvo 2.el ne kadar");
        WebElement idAra = driver.findElement(By.xpath("//button[@type='submit']"));
        idAra.submit();

    }
    @Test
    public void nameSearch(){
        WebElement idSearch = driver.findElement(By.name("query_text"));
        idSearch.sendKeys("volvo 2.el ne kadar");
        WebElement idAra = driver.findElement(By.xpath("//button[@type='submit']"));
        idAra.submit();

    }
    @Test
    public void xpathSearch(){
        WebElement idSearch = driver.findElement(By.name("query_text"));
        idSearch.sendKeys("volvo");
        WebElement idAra = driver.findElement(By.xpath("//button[@type='submit']"));
        idAra.submit();
        WebElement searc=driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/ul/li[2]/div/a"));
        searc.click();

    }








}
