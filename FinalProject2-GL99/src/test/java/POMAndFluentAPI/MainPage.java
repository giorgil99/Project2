package POMAndFluentAPI;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement myAcc;
    private SelenideElement myReg;

    @Step
    public MainPage ClickOnMyAcc() {
        myAcc = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
        myAcc.scrollIntoView(true);
        this.myAcc.click();
        return this;
    }


    @Step
    public MainPage ClickOnRegister() {
        myReg = $(By.xpath("//*[contains(@class,'dropdown-menu dropdown-menu-right')]/li[1]/a"));
        myReg.scrollIntoView(true);
        this.myReg.click();
        return this;
    }

}
