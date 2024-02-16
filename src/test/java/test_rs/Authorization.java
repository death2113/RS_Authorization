package test_rs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Authorization extends Data { //наследование данных

    public static WebDriver driver = new ChromeDriver();
    Data getData = new Data();


    @Test
    public void authorization(){

        driver.get(getData.getUrl);
        WebElement inputLogin = driver.findElement(By.xpath("//*[@id='login']"));
        inputLogin.sendKeys(getData.login);
        WebElement inputPassword = driver.findElement(By.xpath("//*[@id='password']"));
        inputPassword.sendKeys(getData.password);
        WebElement button = driver.findElement(By.xpath("//*[@type='submit']"));
        button.click();

            }

}
