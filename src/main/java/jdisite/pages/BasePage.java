package jdisite.pages;

import static jdisite.utils.DriverUtils.DRIVER;

public abstract class BasePage {
    private String url;
    private String title;

    public BasePage(String url) {
        this.url = url;
    }
    public BasePage(String url, String title) {
        this.url = url;
        this.title = title;
    }
    public void open() {
        DRIVER.navigate().to(url);
    }
}
