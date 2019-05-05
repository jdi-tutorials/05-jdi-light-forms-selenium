package com.jdi;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static java.lang.Runtime.getRuntime;
import static jdisite.pages.JDISite.homePage;
import static jdisite.utils.DriverUtils.runChromeDriver;

public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        runChromeDriver();
        homePage.open();
    }
    @AfterSuite(alwaysRun = true)
    static void teardown() throws IOException {
        getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }
}
