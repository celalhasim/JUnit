package day07_Asertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
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

    public void testTitle() {
        //○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin

    }
    public void testImg() {
        //○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin

    }
    public void testSearchBoxTest() {
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())

    }
    public void testWrongTitle() {
        //○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin

    }



    @AfterClass
    public static void teardown() throws InterruptedException {
        driver.close();
    }

}
