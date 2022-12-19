package Day04_LocatorPractice;

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
import java.util.List;

public class C02_CSSPractice {
    //http://the-internet.herokuapp.com/add_remove_elements/
    // Click on the "Add Element" button 100 times.
    // Write a function that takes a number, and clicks the "Delete" button.
    // Given number of times, and then validates that given number of buttons was deleted.
    // 1. Method: createButtons(100)
    // 2. Method: DeleteButtonsAndValidate()
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void test01(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        createElemets(100);
        deleteButtonsAndValidate(40);
    }
    public void createElemets(int a){
        WebElement addElementButton= driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i <a ; i++) {
            addElementButton.click();
        }
    }
    public void deleteButtonsAndValidate(int amount){
        List<WebElement> deleteButtonList = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int silinmedenOnceDeleteButtonSayisi=deleteButtonList.size();
        System.out.println("silinmedenOnceDeleteButtonSayisi = " + silinmedenOnceDeleteButtonSayisi);

        for (int i = 0; i <amount ; i++) {
            deleteButtonList.get(i).click();
        }
        List<WebElement> deleteButtonListAfter = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int silinmedenSonraDeleteButtonSayisi=deleteButtonListAfter.size();
        System.out.println("silinmedenSonraDeleteButtonSayisi = " + silinmedenSonraDeleteButtonSayisi);
        Assert.assertEquals( silinmedenOnceDeleteButtonSayisi-amount,silinmedenSonraDeleteButtonSayisi );
    }

}
