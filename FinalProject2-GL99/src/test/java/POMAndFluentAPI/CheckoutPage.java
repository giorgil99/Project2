package POMAndFluentAPI;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

    private SelenideElement askNewAddress;
    private SelenideElement newName;
    private SelenideElement newLastName;
    private SelenideElement newAddress1;
    private SelenideElement newCity;
    private SelenideElement newZip;
    private SelenideElement newCountry;
    private SelenideElement newState;
    private SelenideElement Continue1;
    private SelenideElement Continue2;
    private SelenideElement Continue3;
    private SelenideElement Terms;
    private SelenideElement Continue4;
    private SelenideElement SubTotal;
    private SelenideElement FlatShippingRate;
    private SelenideElement TotalAmount;


// sometimes page asked for newAddress click,if so happens uncomment here and same method in MainTest>Test4

//    @Step
//    public CheckoutPage AskNewAddress(){
//        askNewAddress=$("label > input[type=radio]");
//        askNewAddress.scrollIntoView(true);
//        this.askNewAddress.click();
//        return this;
//    }


    @Step
    public CheckoutPage SetNewName(String txt) {
        newName = $("#input-payment-firstname");
        this.newName.sendKeys(txt);
        return this;
    }

    @Step
    public CheckoutPage SetNewLastName(String txt) {
        newLastName = $("#input-payment-lastname");
        this.newLastName.sendKeys(txt);
        return this;
    }

    @Step
    public CheckoutPage SetNewAddress(String txt) {
        newAddress1 = $("#input-payment-address-1");
        this.newAddress1.sendKeys(txt);
        return this;
    }

    @Step
    public CheckoutPage SetNewCity(String txt) {
        newCity = $("#input-payment-city");
        newCity.scrollIntoView(true);
        this.newCity.sendKeys(txt);
        return this;
    }


    @Step
    public CheckoutPage SetNewZip(String txt) {
        newZip = $("#input-payment-postcode");
        this.newZip.sendKeys(txt);
        return this;
    }

    @Step
    public CheckoutPage SetNewCountry(String txt) {
        newCountry = $("#input-payment-country");
        this.newCountry.selectOptionContainingText(txt);
        return this;
    }

    @Step
    public CheckoutPage SetNewState() {
        newState = $("#input-payment-zone");
        this.newState.selectOption(2);
        return this;
    }


    @Step
    public CheckoutPage ClickOnContinue1() {
        Continue1 = $("#button-payment-address");
        Continue1.scrollIntoView(true);
        this.Continue1.click();
        return this;
    }

    @Step
    public CheckoutPage ClickOnContinue2() {
        Continue2 = $("#button-shipping-address");
        Continue2.scrollIntoView(true);
        this.Continue2.click();
        return this;
    }

    @Step
    public CheckoutPage ClickOnContinue3() {
        Continue3 = $("#button-shipping-method");
        Continue3.scrollIntoView(true);
        this.Continue3.click();
        return this;
    }

    @Step
    public CheckoutPage ClickOnTerms() {
        Terms = $(" input[type=checkbox]:nth-child(2)");
        Terms.scrollIntoView(true);
        this.Terms.click();
        return this;
    }

    @Step
    public CheckoutPage ClickOnContinue4() {
        Continue4 = $("#button-payment-method");
        this.Continue4.click();
        return this;
    }

    @Step
    public CheckoutPage CheckSubTotal(String subtotal) {
        SubTotal = $(By.xpath("//table/tfoot/tr[1]/td[2]"));
        this.SubTotal.shouldBe(Condition.exactText(subtotal));
        return this;
    }

    @Step
    public CheckoutPage CheckShippingRate(String shippingRate) {
        FlatShippingRate = $(By.xpath("//table/tfoot/tr[2]/td[2]"));
        this.FlatShippingRate.shouldBe(Condition.exactText(shippingRate));
        return this;
    }

    @Step
    public CheckoutPage CheckTotalAmount(String totalAmount) {
        TotalAmount = $(By.xpath("//table/tfoot/tr[3]/td[2]"));
        this.TotalAmount.shouldBe(Condition.exactText(totalAmount));
        return this;
    }

}
