package test_rs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class PrintDoc extends Data {

    WebDriver driver = new ChromeDriver();
    Data getData = new Data();

    @Test
    public void printDoc () {

        driver.get(getData.getUrl);

        WebElement inputLogin_2 = driver.findElement(By.xpath("//*[@id='login']"));  //ввод логина
        inputLogin_2.sendKeys(getData.login_1);

        WebElement inputPass_2 = driver.findElement(By.xpath("//*[@id='password']")); //ввод пароля
        inputPass_2.sendKeys(getData.password_1);

        WebElement buttonEnter = driver.findElement(By.xpath("//*[@type='submit']"));  //кнопка войти
        buttonEnter.click();

        WebElement xWait = (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='__BVID__79']"))); //явное ожидание поля поика

        WebElement searchField = driver.findElement(By.xpath("//input[@id='__BVID__79']")); //вводим в поле поиска строку
        searchField.sendKeys(getData.nameOrg);

        WebElement xWait2 = (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='button']"))); //явное ожидание кнопки организации

        WebElement buttonOrg = driver.findElement(By.xpath("//button[@type='button']")); //клик по кнопке организации
        buttonOrg.click();

        WebElement xWait3 = (new WebDriverWait(driver,Duration.ofSeconds(3)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='Соглашение по субсидиям №лесное/доп1']"))); //явное ожидание загрузки ЛК

        WebElement clickable = driver.findElement(By.xpath("//td[text()='Соглашение по субсидиям №лесное/доп1']")); // клик по документу
        new Actions(driver)
                .doubleClick(clickable)
                .perform();

       WebElement xWait4 = (new WebDriverWait(driver,Duration.ofSeconds(3)))
               .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn mr-1 btn-outline-primary e-btn btn-huge']"))); //явное ожидание кнопки печать

        WebElement buttonPrint = driver.findElement(By.xpath("//button[@class='btn mr-1 btn-outline-primary e-btn btn-huge']")); //печать
        buttonPrint.click();
    }

}
