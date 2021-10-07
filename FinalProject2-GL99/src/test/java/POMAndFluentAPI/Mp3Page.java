package POMAndFluentAPI;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class Mp3Page {

    private SelenideElement Mp3;
    private SelenideElement Ipod;


    @Step
    public Mp3Page ClickOnMp3() {
        Mp3 = $("#column-left > div.list-group > a:nth-child(10)");
        Mp3.scrollIntoView(true);
        this.Mp3.click();
        return this;
    }


    @Step
    public Mp3Page HoverProduct(String ipodVersion) {

        List<SelenideElement> ElementList;
        ElementList = Selenide.$$("img.img-responsive");
        List<String> sList = new ArrayList<>();
        for (SelenideElement Element : ElementList) {
            sList.add(Element.getAttribute("alt"));
        }
        int k = sList.indexOf(ipodVersion);
        Ipod = ElementList.get(k);
        Ipod.hover();
        this.Ipod.shouldHave(Condition.attribute("title"));
        return this;
    }

    @Step
    public Mp3Page SelectProduct(String ipodVersion) {

        List<SelenideElement> ElementList;
        ElementList = Selenide.$$("img.img-responsive");
        List<String> sList = new ArrayList<>();
        for (SelenideElement Element : ElementList) {
            sList.add(Element.getAttribute("alt"));
        }
        //use 'iPod Classic' here to get
        int k = sList.indexOf(ipodVersion);
        Ipod = ElementList.get(k);
        this.Ipod.click();
        return this;
    }


}
