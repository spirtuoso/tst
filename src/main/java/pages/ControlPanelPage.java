package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ControlPanelPage extends BasePageObject {


    @FindBy(css="a[href='/admin/blog/entry/add/']")
    private WebElement addEntryButton; //селектор добавить новую запись

   @FindBy(xpath="//div[@class='dashboard-module-content']//a[text()='Entries']")
     private WebElement entryChangeButton; //селектор изменения записи

   private String controlPanelTitle;
    public ControlPanelPage(WebDriver driver) {
        super(driver);
        controlPanelTitle = driver.getTitle();
    }

    public void clickEntryButton()    {
        addEntryButton.click();
    }

    public void clickEntryChangeButton(){

           entryChangeButton.click();
    }

    public String getControlPanelDashboardUserName(){
        return controlPanelTitle ;
    }
}
