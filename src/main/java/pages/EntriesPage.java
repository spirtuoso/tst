package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class EntriesPage extends BasePageObject {


    public EntriesPage (WebDriver driver) {
        super(driver);
    }
    public void clickEntry(String title){

        driver.findElement(By.xpath("//a[text()='"+title+"']")).click(); //поиск нужной ссылки и переход на нее

    }

}
