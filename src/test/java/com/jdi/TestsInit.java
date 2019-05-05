package com.jdi;

import org.testng.annotations.BeforeSuite;
import static jdisite.pages.JDISite.homePage;
import static jdisite.utils.DriverUtils.runChromeDriver;

public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        runChromeDriver();
        homePage.open();
    }
}
