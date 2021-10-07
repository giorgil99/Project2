package SelindeConfigAndListeners;

import static com.codeborne.selenide.Selenide.open;


// Sets web connections

public class GetWebConnection extends SelenideConfig {

    public static String URL = "http://tutorialsninja.com/demo/";


    public void ConnectToPage() {
        SelenideCfg();
        open(URL);
        System.out.println("Connection to web  is set: ");
    }

}
