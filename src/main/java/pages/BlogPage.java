package pages;

import org.openqa.selenium.WebDriver;


public class BlogPage extends BasePageObject {

      public BlogPage(WebDriver driver){
          super(driver);
    }
    public boolean EntryPresent(String text){

        return  driver.getPageSource().contains(text); //проверка наличия записи

    }
}
