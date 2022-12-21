package Day06_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {
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
    public void selectByIndex(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement drpDown = driver.findElement(By.name("country"));
        Select select = new Select(drpDown);
        select.selectByIndex(1);
        //selectbyındex metodu sıfırdan başlar

    }
    @Test
    public void selectByValue(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement drpDown = driver.findElement(By.name("country"));
        Select select = new Select(drpDown);
        select.selectByValue("TURKEY");

    }
    @Test
    public void selectByVisibleText(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement drpDown = driver.findElement(By.name("country"));
        Select select = new Select(drpDown);
        select.selectByVisibleText("NEPAL");
        System.out.println(select.isMultiple());
    }
    @Test
    public void multipleSelect(){
        driver.get("https://output.jsbin.com/osebed/2");
        WebElement drpDown = driver.findElement(By.id("fruits"));
        Select select = new Select(drpDown);
        System.out.println(select.isMultiple());
        select.selectByValue("apple");
        select.selectByIndex(3);// Grape
    }
    @Test
    public void getOPtions(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        Select select = new Select(driver.findElement(By.name("country")));
        List<WebElement> options = select.getOptions();
        options.forEach(x-> System.out.println(x.getText()));
       /*for (WebElement opt: options){
           System.out.println(opt.getText());
       }*/
    }
    @Test
    public void getFirstSelectionOption(){
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByIndex(3);
        select.selectByIndex(2);
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println(selectedOption.getText());//seçili olan ilk elementi döndürür. biz önce 3. elemanı seçer
        //sonra 2. elemanı seçersek 2. elemanı döndürür
    }
    @Test
    public void getAllSelectedOptions(){
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByValue("banana");
        select.selectByValue("apple");
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        selectedOptions.forEach(x-> System.out.println(x.getText()));
    }






}
