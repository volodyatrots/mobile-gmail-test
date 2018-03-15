package com.epam.lab.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static AppiumDriver driver;
    private Driver() {
    }
    public static void createDriver() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Testing Phone)2");
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver(url, capabilities);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void close()  {
        try {
            if (getDriver() != null) {
                    getDriver().quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver(){
        if (driver == null) {
            createDriver();
        }
        return driver;
    }
}
