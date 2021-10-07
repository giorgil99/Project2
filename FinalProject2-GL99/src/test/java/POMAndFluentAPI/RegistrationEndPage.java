package POMAndFluentAPI;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationEndPage {


    private SelenideElement lapsAndNotes;
    private SelenideElement showAll;

    @Step
    public RegistrationEndPage ClickOnLaptopsAndNotebooks() {

        lapsAndNotes = $("div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(2) > a");
        lapsAndNotes.scrollIntoView(true);
        this.lapsAndNotes.click();
        return this;
    }

    @Step
    public RegistrationEndPage ClickOnShowLapsAndNotes() {
        showAll = $(" ul > li.dropdown.open > div > a");
        showAll.scrollIntoView(true);
        this.showAll.click();
        return this;
    }

}
