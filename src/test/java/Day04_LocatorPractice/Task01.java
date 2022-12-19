package Day04_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
//https://id.heroku.com/login sayfasına gidiniz.
//Bir mail adresi giriniz.
//Bir password giriniz.
//Login butonuna tıklayınız.
//"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
//Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
//Tüm sayfaları kapatınız.

public class Task01 {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
       driver.quit();
    }
    @Test
    public void test(){
        driver.get("https://id.heroku.com/login");
       WebElement searchButton = driver.findElement(By.xpath("//input[@id='email']"));
        searchButton.sendKeys("bbbbbb@gmail.com");
        WebElement passwordButton = driver.findElement(By.xpath("//input[@id='password']"));
        passwordButton.sendKeys("123456"+ Keys.ENTER);
        WebElement text = driver.findElement(By.className("alert"));
       // Assert.assertTrue("Kayıt fonk. düzgün çalışmıyor",text.getText().contains("There was a problem afsçşögöerlwögt"));
        if (text.isDisplayed()){
            System.out.println("Kayıt Yapılamadı");
        }else System.out.println("Kayıt Yapıldı");


    }
}
