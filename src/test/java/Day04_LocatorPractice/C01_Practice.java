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

public class C01_Practice {
    //Navigate to website  https://testpages.herokuapp.com/styled/index.html
    // Under the ORIGINAL CONTENTS
    // Click on Alerts
    // Print the URL
    // Navigate back
    // Print the URL
    // Click on Basic Ajax
    // Print the URL
    // Enter value  20 and Enter
    // And then verify Submitted Values is displayed open page
    // Close driver.
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
        driver.quit();
    }
    @Test
    public void test(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement alertsLink=driver.findElement(By.xpath("//a[@id='alerts']"));
        alertsLink.click();
        String alertsUrl= driver.getCurrentUrl();
        System.out.println("alertsUrl = " + alertsUrl);
        driver.navigate().back();
        String homeUrl= driver.getCurrentUrl();
        System.out.println("homeUrl = " + homeUrl);
        WebElement basicAjaxLink= driver.findElement(By.id("basicajax"));
        basicAjaxLink.click();
        String basicAjaxUrl= driver.getCurrentUrl();
        System.out.println("basicAjaxUrl = " + basicAjaxUrl);
        WebElement search= driver.findElement(By.id("lteq30"));
        search.sendKeys("20"+ Keys.ENTER);
        WebElement submittedValuesText = driver.findElement(By.xpath("//p[text()='Submitted Values']"));
        Assert.assertTrue(submittedValuesText.isDisplayed());

    }





}
