package java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Authorization extends Data {

    WebDriver driver = new ChromeDriver();
    Data getData = new Data();

    private By inputLogin = (By.xpath("//*[@id=\"login\"]"));
    private By inputPassword = (By.xpath("//*[@id=\"password\"]"));
    private By button = (By.xpath("//*[@type=\"submit\"]"));

    @Test
    public void authorization (){

        driver.get(getData.getUrl);
        driver.findElement(inputLogin).sendKeys(getData.login);
        driver.findElement(inputPassword).sendKeys(getData.password);
        driver.findElement(button).click();

    }

}
