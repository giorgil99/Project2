package POMAndFluentAPI;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductMainPage {
    private SelenideElement Cart;
    private SelenideElement cartPreview;
    private SelenideElement cartCount;
    private SelenideElement cartPrice;
    private SelenideElement Checkout;

    @Step
    public ProductMainPage AddProductToCart() {
        Cart = $("#button-cart");
        Cart.scrollIntoView(true);
        this.Cart.click();
        return this;
    }


    @Step
    public ProductMainPage ClickOnCart() {
        cartPreview = $("#cart-total");
        cartPreview.scrollIntoView(true);
        this.cartPreview.click();
        return this;
    }

    @Step
    public ProductMainPage CheckCartCount(String count) {
        cartCount = $(By.xpath("//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[3]"));
        this.cartCount.shouldBe(Condition.exactText(count));
        return this;
    }

    @Step
    public ProductMainPage CheckCartPrice(String price) {
        cartPrice = $(By.xpath("//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[4]"));
        this.cartPrice.shouldBe(Condition.exactText(price));
        return this;
    }

    @Step
    public ProductMainPage RefreshPage() {
        Selenide.refresh();
        return this;

    }

    @Step
    public ProductMainPage ClickOnCheckout() {
        Checkout = $(By.xpath("//p[@class=\"text-right\"]/a[2]/strong"));
        Checkout.scrollIntoView(true);
        this.Checkout.click();
        return this;
    }
}
