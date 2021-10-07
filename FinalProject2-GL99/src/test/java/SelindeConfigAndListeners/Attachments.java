package SelindeConfigAndListeners;

import io.qameta.allure.Attachment;


// setting up allure attachment for screenshot

public class Attachments {
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
