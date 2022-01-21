package Day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C01_TekrarTesti {
    public static void main(String[] args) {
        //1-C01_TekrarTesti isimli bir class olusturun
        //2- https://www.google.com/ adresine gidin
        //3- cookies uyarisini kabul ederek kapatin
        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        //5- Arama cubuguna “Nutella” yazip aratin
        //6-Bulunan sonuc sayisini yazdirin
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        //8-Sayfayi kapatin

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//div[text()='Ich stimme zu']")).click();
        String actualTitle= driver.getTitle();
        String arananKelime="Google";

        if (actualTitle.equals(arananKelime)){
            System.out.println("Sayfa Title testi PASSED");
        }else {
            System.out.println("Sayfa Title testi FAILED");
        }

        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucSayisiElement=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisiElement.getText());

        String sonucSayisiStr=sonucSayisiElement.getText();
        String sonucKelimeleri[]=sonucSayisiStr.split(" ");
        System.out.println(Arrays.toString(sonucKelimeleri));

        String sonucNutellaSayisi=sonucKelimeleri[1];
        sonucNutellaSayisi=sonucNutellaSayisi.replace(".","");
        int nutellaAramaSonuc=Integer.parseInt(sonucNutellaSayisi);

        if (nutellaAramaSonuc>10000000){
            System.out.println("Nutella arama testi PASSED");
        }else {
            System.out.println("Nutella arama testi FAILED");
        }
        driver.close();
    }
}
