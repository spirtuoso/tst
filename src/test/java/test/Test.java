package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import pages.*;


class TestDemo {
    private LoginPage page;
   // private ControlPanelPage page;
    private WebDriver driver;
    private String title;
//подготовительные операции
    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver","d:\\gecko\\geckodriver.exe"); //путь к драйверу для firefox
        driver = new FirefoxDriver(); //запуск браузера
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //период неявного ожидания
        page = new LoginPage(driver); //экземпляр класса для обработки страницы логина
    }




    @org.testng.annotations.Test
    public void test() {

        //1) Заходит на страницу - http://igorakintev.ru/admin/
        page.open(" http://igorakintev.ru/admin/");

       // 2) Заполняет имя пользователя - silenium
        page.setUsername("silenium");

        // 3) Заполняет пароль - super_password
        page.setPassword("super_password");

       // 4) Нажимает кнопку Войти
        page.clickLogin();

        ControlPanelPage controlPanelPage = new ControlPanelPage(driver);
       // 5) Проверяет что на новой станице присутствует заголовок - “Панель управления”

        Assert.assertTrue(controlPanelPage.getControlPanelDashboardUserName().toLowerCase().contains("панель управления"));

       // 6) Нажимает кнопку “Добавить” в разделе Blog/Entries

        controlPanelPage.clickEntryButton();
        AddPage addPage = new AddPage(driver); //экземпляр класса для работы со страницей новой записи

       //7) Проверяет что на новой станице присутствует заголовок - “Добавить entry”
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("добавить entry"));

      //  8) Заполняет поле title - случайной строкой (пример: Title43565463456)
        addPage.textToBlogTitle();
        title = addPage.blogTitle(); //запоминаем название записи


       // 9) Заполняет поле Slug - случайной строкой (пример: Slug43565463456)
        addPage.textToBlogSlug();

       // 10) Заполняет поле Text markdown - случайной строкой (пример: Slug43565463456)
        addPage.textToBlogMarkdown();

       // 11) Заполняет поле Text - случайной строкой (пример: Slug43565463456)

        addPage.textToBlogText();
     //   12) Нажимает кнопку Сохранить

        addPage.clickSave();

     //   13) Переходит на страницу: http://igorakintev.ru/blog/
        page.open(" http://igorakintev.ru/blog/");

        //14) Удостоверяется что ранее созданная запись отображается на сайте.
        BlogPage blogPage = new BlogPage(driver); //экземпляр класса для работы со страницей новой записи
        Assert.assertTrue(blogPage.EntryPresent(title));

       // 15) Удаляет созданную запись (в админ панели).
        page.open(" http://igorakintev.ru/admin/"); //открываем админ панель
        controlPanelPage = new ControlPanelPage(driver); //заново присваеваем переменную для страницы админпанели
        controlPanelPage.clickEntryChangeButton(); //жмем на кнопку изменения записей, переход на страницу записей
        EntriesPage entriesPage = new EntriesPage(driver); //присваеваем переменную для страницы записей
        entriesPage.clickEntry(title); //жмем на кнопку с нужной записью, переход на страницу записи
        addPage = new AddPage(driver); //заново присваеваем переменную для страницы записи
        addPage.clickDeleteLink(); //жмем кнопку 'Удалить", переход на страницу подтверждения
        ConfirmPage confirmPage = new ConfirmPage(driver); //присваеваем переменную для страницы подтверждения
        confirmPage.clickDeleteConfirm(); //удаляем запись

    }
}