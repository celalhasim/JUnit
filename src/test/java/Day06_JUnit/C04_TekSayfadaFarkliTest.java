package Day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_TekSayfadaFarkliTest {
    static WebDriver driver;

    static WebElement aramaKutusu;
    static WebElement sonucYazisiElementi;

    @Test
    public void test01(){
        //Amazon sayfasında nutella arayıp, sonuc yazısını nutella içerdiğini test edelim
       aramaKutusu.sendKeys("nutella" + Keys.ENTER);
       sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
       String actualNutellaSonuc=sonucYazisiElementi.getText();
       String arananKelime="nutella";
       if (actualNutellaSonuc.contains(arananKelime)){
           System.out.println("Nutella arama testi PASSED");
       }else{
           System.out.println("Nutella arama testi FAILED");
       }

    }


    @Test
    public void test02(){
        //Amazon sayfasında java arayıp, sonuc yazısını java içerdiğini test edelim
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("java" + Keys.ENTER);
        sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualJavaSonuc=sonucYazisiElementi.getText();
        String arananKelime="java";
        if (actualJavaSonuc.contains(arananKelime)){
            System.out.println("Java arama testi PASSED");
        }else{
            System.out.println("Java arama testi FAILED");
        }
    }



    @Test
    public void test03(){
        //Amazon sayfasında ali arayıp, sonuc yazısını ali içerdiğini test edelim
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("ali" + Keys.ENTER);
        sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualAliSonuc=sonucYazisiElementi.getText();
        String arananKelime="ali";
        if (actualAliSonuc.contains(arananKelime)){
            System.out.println("Ali arama testi PASSED");
        }else{
            System.out.println("Ali arama testi FAILED");
        }
    }


    @BeforeClass
    public static void ayarlarıDuzenle() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

    }

    @AfterClass
    public static void ortalıkTopla() {
        driver.close();
    }
}