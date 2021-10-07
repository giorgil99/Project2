import POMAndFluentAPI.*;
import SQLConnection.DataFromSQL;
import SQLConnection.SqlTableGeneration;
import SelindeConfigAndListeners.GetWebConnection;
import SelindeConfigAndListeners.LocalListener;
import io.qameta.allure.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

@Listeners({LocalListener.class})


public class MainTest {

    @BeforeTest(groups = {"Regression0", "Regression1", "Regression2"})
    public void Start() throws SQLException {
        SqlTableGeneration.SQLTable();
        GetWebConnection connection = new GetWebConnection();
        connection.ConnectToPage();
        DataFromSQL sql = new DataFromSQL();
        sql.SQLData();

    }

    @Test(groups = {"Regression0"}, description = "registration test")
    @Epic("Success")
    @Feature("Regression0")
    @Story("TEST1 results")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test1 for allure")

    public void Test1() {
        MainPage mainPage = new MainPage();
        mainPage
                .ClickOnMyAcc()
                .ClickOnRegister();

        RegistrationPage regPage = new RegistrationPage();
        regPage
                .SetName(DataFromSQL.firstName)
                .SetLastName(DataFromSQL.lastName)
                .SetMail(DataFromSQL.email)
                .SetTelephone(DataFromSQL.phone)
                .SetPassword(DataFromSQL.password)
                .ConfirmPassword(DataFromSQL.password)
                .ClickOnNewsletter()
                .ClickOnPrivacyPolicy()
                .ClickOnSubmit();
    }


    @Test(groups = {"Regression1"}, description = "sorting test")
    @Epic("Success")
    @Feature("Regression1")
    @Story("Test2 results:")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test2 for allure")
    public void Test2() {
        RegistrationEndPage regEndPage = new RegistrationEndPage();
        regEndPage
                .ClickOnLaptopsAndNotebooks()
                .ClickOnShowLapsAndNotes();

        LapsAndNotesPage lapsAndNotesPAge = new LapsAndNotesPage();
        lapsAndNotesPAge
                .SelectSorting()
                .AssertSorting();
    }


    @Test(groups = {"Regression2"}, description = "cart test", dependsOnMethods = "Test1")
    @Epic("Success")
    @Feature("Regression2")
    @Story("Test3 results:")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test3 for allure")

    public void Test3() {
        LapsAndNotesPage lapsAndNotesPAge = new LapsAndNotesPage();
        lapsAndNotesPAge
                .ClickOnDesktop()
                .ClickOnShowAllDesktops();

        Mp3Page mp3Page = new Mp3Page();
        mp3Page
                .ClickOnMp3()
                .HoverProduct("iPod Touch")
                .SelectProduct("iPod Touch");

        ProductMainPage PrMainPAge = new ProductMainPage();
        PrMainPAge
                .AddProductToCart()
                .ClickOnCart()
                .CheckCartCount("x 1")
                .CheckCartPrice("$122.00");
    }


    @Test(groups = {"Regression2"}, description = "checkout test"
            , dependsOnMethods = "Test3", retryAnalyzer = SelindeConfigAndListeners.LocalRetry.class)
    @Epic("Success")
    @Feature("Regression2")
    @Story("Test4 results:")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test4 for allure")
    public void Test4() {

        ProductMainPage PrMainPAge = new ProductMainPage();
        PrMainPAge
                .RefreshPage()
                .ClickOnCart()
                .ClickOnCheckout();
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage
//                .AskNewAddress()
                .SetNewName(DataFromSQL.firstName)
                .SetNewLastName(DataFromSQL.lastName)
                .SetNewAddress(DataFromSQL.address)
                .SetNewCity(DataFromSQL.city)
                .SetNewZip(DataFromSQL.zip)
                .SetNewCountry(DataFromSQL.country)
                .SetNewState()
                .ClickOnContinue1()
                .ClickOnContinue2()
                .ClickOnContinue3()
                .ClickOnTerms()
                .ClickOnContinue4()
                .CheckSubTotal("$100.00")
                .CheckShippingRate("$5.00")
                .CheckTotalAmount("$105.00");
    }

    @Test(groups = {"Regression0"}, priority = 5, description = "fail test", retryAnalyzer = SelindeConfigAndListeners.LocalRetry.class)
    @Epic("Destined to fail")
    @Feature("helper test")
    @Story("helper test results:")
    @Severity(SeverityLevel.MINOR)
    @Description("Helper test for screenshot and retryAnalyzer")
    public void Test0() {

        open("https://duckduckgo.com/?t=opera");
        SoftAssert softAssert = new SoftAssert();
        softAssert.fail();
        softAssert.assertAll();
    }

}
