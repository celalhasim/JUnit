package day07_Asertions;

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

public class C03_BestBuyAssertion {
    //       1) Bir class oluşturun: BestBuyAssertions
    //        2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //		○ logoTest => BestBuy logosunun görüntülendigini test edin
    //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));}


    @Test
    public void test01(){
        driver.get("https://www.bestbuy.com/");
        String actualUrl= driver.getCurrentUrl();
        String expectedURL="https://www.bestbuy.com/";
        Assert.assertEquals("Lütfen test değerlerini gözden geçiriniz.",expectedURL, actualUrl);
        String actualTitle= driver.getTitle();
        String expectedTitle="Rest";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
        WebElement logoElementi= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("Logo görünmüyor", logoElementi.isDisplayed());
        WebElement francais= driver.findElement(By.xpath("//button[text()='Français']"));

        Assert.assertTrue(francais.isDisplayed());


    }



    @After
    public void teardown() throws InterruptedException {

        Thread.sleep(3000);
        driver.close();

    }
}
