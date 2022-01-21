package Day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AramaTesti {
    public static void main(String[] args) {
        //1. “https://www.saucedemo.com” Adresine gidin
        //2. Username kutusuna “standard_user” yazdirin
        //3. Password kutusuna “secret_sauce” yazdirin
        //4. Login tusuna basin
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        //6. Add to Cart butonuna basin
        //7. Alisveris sepetine tiklayin
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        //9. Sayfayi kapatin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        WebElement ilkUrunIsmi=driver.findElement(By.id("item_4_title_link"));
        System.out.println(ilkUrunIsmi.getText());
        ilkUrunIsmi.click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        WebElement sepetUrun=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String sepetStr= sepetUrun.getText();
        System.out.println(sepetStr);
        if (ilkUrunIsmi.equals(sepetStr)){
            System.out.println("urun sepete eklendi PASSED");
        }else {
            System.out.println("urun sepete eklendi FAILED");
        }

        driver.close();
    }
}
