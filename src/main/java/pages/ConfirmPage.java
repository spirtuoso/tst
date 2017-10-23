package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ConfirmPage extends  BasePageObject { //наследуем от базового объекта
    @FindBy(xpath="//input[@type='submit']")
    private WebElement deleteConfirm;
    public ConfirmPage(WebDriver driver){
        super(driver);
    } //конструктор суперкласса


    public void clickDeleteConfirm() {
    deleteConfirm.click();
    }
}
