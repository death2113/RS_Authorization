package test_rs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Authorization_1 extends Data {

    public static WebDriver driver = new ChromeDriver(); // делаем вилимым для всех классов
    Data getData = new Data();


    @Test
    public void authorization_1 () {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //неявное ожидание

        driver.get(getData.getUrl);

        WebElement inputLogin_1 = driver.findElement(By.xpath("//*[@id='login']"));
        inputLogin_1.sendKeys(getData.login_1);

        WebElement inputPassword_1 = driver.findElement(By.xpath("//*[@id='password']"));
        inputPassword_1.sendKeys(getData.password_1);

        WebElement button_1 = driver.findElement(By.xpath("//*[@type='submit']"));
        button_1.click();

        WebElement org_3 = driver.findElement(By.xpath("//div[@class = 'list-group list-elements mb-3 mt-1 cab-select-list-elements']//button[@class='list-group-item list-elements__item list-group-item-action'][@type = 'button']"));
        org_3.click();

    }
}
