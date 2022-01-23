package day07_Asertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YouTubeAssertion {
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        //1) Bir class oluşturun: YoutubeAssertions
        //2) https://www.youtube.com adresine gidin
        //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        //     ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        //    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com/");

    }
    @Test
    public void testTitle() {
        //○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        driver.findElement(By.xpath("(//tp-yt-paper-button[@class='style-scope ytd-button-renderer style-primary size-default'])[2]")).click();
        String actualTitle= driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertTrue(actualTitle.equals(expectedTitle));

    }
    @Test
    public void testImg() {
        //○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement iconYoutube= driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-logo'])[1]"));
        Assert.assertTrue(iconYoutube.isDisplayed());

    }
    @Test
    public void testSearchBoxTest() {
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isDisplayed());

    }
    @Test
    public void testWrongTitle() {
        //○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle= driver.getTitle();
        String expectedTitle="Youtube";
        Assert.assertFalse(actualTitle.equals(expectedTitle));

    }



    @AfterClass
    public static void teardown() throws InterruptedException {
        driver.close();
    }

}
