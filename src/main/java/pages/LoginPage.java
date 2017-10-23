package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePageObject {

    @FindBy(id="id_username")
    WebElement userName; //селектор для имени пользователя

    @FindBy(id="id_password")
    WebElement password; //селектор для пароля

    @FindBy(className = "submit-row")
    WebElement btnLogin; //кнопка логина

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open(String url) {
        driver.get(url);
    } //переход по ссылке

    public void setUsername(String text) {
        userName.sendKeys(text);
    }

    public void setPassword(String text) {
        password.sendKeys(text);
    }

    public void clickLogin() {
        btnLogin.click();
    }
}
