package test_rs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static test_rs.Authorization.driver; //импорт драйвера


public class TableList {


    @Test
    public void tableList() {

        try {
            Authorization auth = new Authorization(); //вызов авторизации
            auth.authorization();

            WebElement wait = (new WebDriverWait(driver, Duration.ofSeconds(10)))  //ожидание ссылки Соглашения
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='nav nav-tabs']//li[@class='nav-item main-page']//a[contains(@href,'/agreement/main/documents')]")));

            WebElement butt = driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//li[@class='nav-item main-page']//a[contains(@href,'/agreement/main/documents')]"));
            butt.click(); //кликаем на ссылку Соглашения

            WebElement wait3 = (new WebDriverWait(driver, Duration.ofSeconds(10))) //ожидание наименования
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[@role='rowgroup']//tr[@role='row']//td[@class='border-0 w-10']")));

            List<WebElement> table = driver.findElements(By.xpath("//tbody[@role='rowgroup']//tr[@role='row']")); //вытаскиваем все строки
            for (int i = 0; i < table.size(); i++) {
                String name = (table.get(i).getText());
                System.out.println(name);
            }

        } finally {
            driver.quit();  //завершаем работу драйвера
        }
    }
}

