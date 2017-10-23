package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;
import java.util.logging.Logger;

public class AddPage extends BasePageObject {

    @FindBy(id="id_title")
    private WebElement blogTitle; //селектор Названия

    @FindBy(id="id_slug")
    private WebElement blogSlug; //селектор Слаг

    @FindBy(id="id_text_markdown")
    private WebElement blogMarkdown; //селектор Markdown

    @FindBy(id="id_text")
    private WebElement blogText; //селектор текста

    @FindBy(className = "default")
    WebElement btnLogin; //селектор кнопки для сохранения

    @FindBy(className = "deletelink")
    private WebElement deleteLink; //селектор кнопки для удаления

    public AddPage(WebDriver driver){
        super(driver);
    }

    public void textToBlogTitle(){
        Random random = new Random();
        blogTitle.sendKeys("Title" + random.nextInt());

    }
    public String blogTitle(){

    return blogTitle.getAttribute("value"); //получение данных названия записи
    }

    public void textToBlogSlug(){
        Random random = new Random();
        blogSlug.clear(); //очистим запись, т.к. туда пишет по умолчанию тоже, что и в blogTitle
        blogSlug.sendKeys("Slug" + random.nextInt());

    }

    public void textToBlogMarkdown(){
        Random random = new Random();
        blogMarkdown.sendKeys("Markdown" + random.nextInt());

    }

    public void textToBlogText (){
        Random random = new Random();
        blogText.sendKeys("Text" + random.nextInt());

    }

    public void clickSave() {
        btnLogin.click();
    }


    public void clickDeleteLink() {
        deleteLink.click();
    }
}
