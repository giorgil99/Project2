package POMAndFluentAPI;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;

public class LapsAndNotesPage {

    private SelenideElement inputSort;
    private SelenideElement Desktop;
    private SelenideElement showAllDesktops;


    @Step("select high -> low sorting")
    public LapsAndNotesPage SelectSorting() {
        inputSort = $("#input-sort");

        inputSort.scrollIntoView(true);
        this.inputSort.selectOption("Price (High > Low)");
        return this;
    }

    @Step("see out prices by sorting ")
    public LapsAndNotesPage AssertSorting() {
        for (int i = 0; i < 5; i++) {
            Stream<SelenideElement> stream = $("#content > div:nth-child(7)").findAll("div.product-layout.product-grid.col-lg-4.col-md-4.col-sm-6.col-xs-12").stream();
            List<SelenideElement> list = stream.collect(Collectors.toList());
            list.get(i).scrollIntoView(true);
            System.out.println("N" + (i + 1) + ":  " + list.get(i).find("p.price").getText());
        }
        return this;
    }

    @Step
    public LapsAndNotesPage ClickOnDesktop() {
        Desktop = $("div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(1) > a");
        Desktop.scrollIntoView(true);
        this.Desktop.click();
        return this;

    }

    @Step
    public LapsAndNotesPage ClickOnShowAllDesktops() {
        showAllDesktops = $("a.see-all");
        this.showAllDesktops.click();
        return this;
    }


}
