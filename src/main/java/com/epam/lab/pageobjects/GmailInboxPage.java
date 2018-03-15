package com.epam.lab.pageobjects;


import com.epam.lab.control.elements.Button;
import com.epam.lab.driver.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailInboxPage extends PageObject {
    private Boolean statusLoad;
    @FindBy(css = ".V.j.od")
    private Button composeButton;

    @FindBy(css = ".V.j.zd")
    private Button menuButton;

    public void composeLetter() {
        composeButton.click();
    }

    public boolean checkLoadInbox() {
        if ((new WebDriverWait(Driver.getDriver(), 60)).until(ExpectedConditions.elementToBeClickable(composeButton)) != null) {
            statusLoad = true;
        }
        return statusLoad;
    }

    public void openMenu() {
        menuButton.click();
    }
}
