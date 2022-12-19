package Day04_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
//Navigate to https://testpages.herokuapp.com/styled/index.html
// Click on Calculate under Micro Apps.
// Type any number in the first input.
// Type any number in the second input.
// Click on Calculate.
// Get the result.
// Print the result.

public class Task02 {

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
    public void test(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement calculate= driver.findElement(By.id("calculatetest"));
        calculate.click();
        WebElement buttonOne= driver.findElement(By.id("number1"));
        buttonOne.sendKeys("35");
        WebElement buttonTwo= driver.findElement(By.id("number2"));
        buttonTwo.sendKeys("33");
        WebElement buttonCalculate= driver.findElement(By.id("calculate"));
        buttonCalculate.click();
        WebElement result= driver.findElement(By.xpath("//p[text()='Answer : ']"));
        String resultText= result.getText();
        System.out.println(resultText);
    }
}
