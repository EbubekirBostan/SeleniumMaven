package Day3_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme {
    //vatan bilgisyara git  hp model no : 6H6Q6EA bul fiyatını yazdır
    // Macbook Pro MK1H3TU/A M1 modelin satış fiyatını yazdırın
    //Asus Zenbook Pro Duo Oled 12.Nesil Corei9 12900H-32Gb-1Tb-15.6-Rtx3070Ti 8Gb-W11 satış fiyatını yazdırın
    //Msi Ge77 Raider 12.Nesil Core i9 12900HX-64Gb-2Tb Ssd-17.3inc-Rtx3080Ti 16Gb-W11 satış fiyatını yazdırın
    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @After
    public void after(){
        driver.quit();
    }
    @Test
    public void msiFiyat(){
        driver.get("https://www.vatanbilgisayar.com");


    }
    @Test
    public void mac() {
        driver.get("https://www.vatanbilgisayar.com/");
        driver.findElement(By.xpath("//*[@class='search__input']")).sendKeys(" Macbook Pro MK1H3TU/A M1" + Keys.ENTER);
        System.out.println("Fiyatı= "+driver.findElement(By.xpath("//*[@class='product-list__price']")).getText());
    }
    @Test
    public void asus() {
        driver.get("https://www.vatanbilgisayar.com/");
        driver.findElement(By.xpath("//*[@id='navbar-search-input']")).sendKeys("Asus Zenbook  ");

    }





}
