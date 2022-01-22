package day07_Asertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestBuyAyriTestler {
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }



    @Test
    public void testURL(){

        String actualUrl= driver.getCurrentUrl();
        String expectedURL="https://www.bestbuy.com/";
        Assert.assertEquals("Lütfen test değerlerini gözden geçiriniz.",expectedURL, actualUrl);


    }

    @Test
    public void  testLogo(){
        WebElement logoElementi= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("Logo görünmüyor", logoElementi.isDisplayed());
    }

    @Test
    public void testTitle(){
        String actualTitle= driver.getTitle();
        String expectedTitle="Rest";
        Assert.assertFalse(actualTitle.contains(expectedTitle));

    }


    @Test
    public void testFrancais(){
        WebElement francais= driver.findElement(By.xpath("//button[text()='Français']"));

        Assert.assertTrue(francais.isDisplayed());
    }


    @AfterClass
    public static void teardown() throws InterruptedException {
        driver.close();
    }

}
