package Day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_IlkTestMethod {
    WebDriver driver;

    @Test
    public void test01(){
        // https://www.amazon.com gidip Title "amazon" içeriyor mu?
        driver.get("https://www.amazon.com");

        String actualTitle=driver.getTitle();
        String arananKelime="amazon";

        if(actualTitle.contains(arananKelime)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title testi FAILED");
        }
    }
    @Test
    public void  test02(){
        //https://www.google.com gidip Title "google" içerdiğini test edin.
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//div[text()='Ich stimme zu']")).click();
        String actualTitle=driver.getTitle();
        String arananKelime="google";

        if(actualTitle.contains(arananKelime)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title testi FAILED");
        }
    }
    @Before
    public void ayarlarıDuzenle(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void ortalıkTopla(){
    driver.close();
    }
}
