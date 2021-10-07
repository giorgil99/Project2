package SelindeConfigAndListeners;

import com.codeborne.selenide.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SelenideConfig {

    public void SelenideCfg() {
//        Change default timeout with Selenide Configuration
//        Open the Chrome browser

        Configuration.browser = "Chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 1000;
        Configuration.holdBrowserOpen = false;
        Configuration.reopenBrowserOnFail = true;
        Path root = Paths.get(".").normalize().toAbsolutePath();
        Configuration.reportsFolder = root + "\\src\\main\\resources\\Reports";
        Configuration.savePageSource = false;
    }

}


