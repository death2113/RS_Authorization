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

            WebElement table = driver.findElement(By.xpath("//tbody[@role='rowgroup']")); //находим таблицу

            List<WebElement> Rows = table.findElements(By.xpath("//tbody[@role='rowgroup']//tr[@role='row']")); //строки
            int rows_count = Rows.size(); //количество строк
            //System.out.println(rows_count);

            List<WebElement> Columns = table.findElements(By.xpath("//tbody[@role='rowgroup']//tr[@role='row']//td[@role='cell']")); //колонки
            int columns_count = Columns.size(); //количество колонок
            //System.out.println(columns_count);


            for (int i = 0; i < rows_count; i++) {
                List<WebElement> columns_from_rows = Rows.get(i).findElements(By.xpath("//tbody[@role='rowgroup']//tr[@role='row']//td[@role='cell']")); // получаем колонки  из строк
                for (int j = 0; j < columns_count; j++) {
                    String col_tx = columns_from_rows.get(j).getText(); //получаем значения из колонок
                    System.out.println("Str " + i + " - " + " Colum " + j + " - " + col_tx);
                }
            }

        } finally {
            driver.quit();  //завершаем работу драйвера
        }
    }
}

