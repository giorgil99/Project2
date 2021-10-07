package POMAndFluentAPI;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
public class RegistrationPage {


    private SelenideElement firstName;
    private SelenideElement lastName;
    private SelenideElement Email;
    private SelenideElement Telephone;
    private SelenideElement Password;
    private SelenideElement passwordConfirmation;
    private SelenideElement newsletter;
    private SelenideElement privacyPolicy;
    private SelenideElement Submit ;

    public  RegistrationPage(){}

    @Step
    public  RegistrationPage SetName(String txt){
        firstName =$((By.xpath("//input[@id=\"input-firstname\"]")));
        this.firstName.sendKeys(txt);
        return this;
    }
    @Step
    public RegistrationPage SetLastName(String txt){
        lastName=$(By.xpath("//input[@id=\"input-lastname\"]"));
        this.lastName.sendKeys(txt);
        return this;
    }

    @Step
    public RegistrationPage SetMail (String txt){
        Email=$(By.xpath("//input[@id=\"input-email\"]"));
        this.Email.sendKeys(txt);
        return this;
    }
    @Step
    public RegistrationPage SetTelephone(String txt){
        Telephone=$(By.xpath("//input[@id=\"input-telephone\"]"));
        this.Telephone.sendKeys(txt);
        return this;
    }
    @Step
    public RegistrationPage SetPassword(String txt){
        Password=$(By.xpath("//input[@type=\"password\" and @name=\"password\"]"));
        this.Password.sendKeys(txt);
        return this;
    }
    @Step
    public  RegistrationPage ConfirmPassword(String txt){
        passwordConfirmation =$(By.xpath("//input[@type=\"password\" and @name=\"confirm\"]"));
        this.passwordConfirmation.sendKeys(txt);
        return this;
    }

    @Step
    public RegistrationPage ClickOnNewsletter(){
        newsletter=$(By.xpath("//input[@type=\"radio\" and @name=\"newsletter\" and @value=\"1\"]"));
        this.newsletter.click();
        return this;
    }

    @Step
    public RegistrationPage ClickOnPrivacyPolicy(){
        privacyPolicy=$(By.xpath("//input[@type=\"checkbox\" and @name=\"agree\" and @value=\"1\"]"));
        this.privacyPolicy.click();
        return  this;
    }

    @Step
    public RegistrationPage ClickOnSubmit (){
        Submit=$(By.xpath("//input[@type=\"submit\" and @class=\"btn btn-primary\" and @value=\"Continue\"]"));
        this.Submit.click();
        return this;
    }


}
