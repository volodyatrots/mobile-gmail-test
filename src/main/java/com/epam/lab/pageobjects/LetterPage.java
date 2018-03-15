package com.epam.lab.pageobjects;

import com.epam.lab.control.elements.Button;
import com.epam.lab.control.elements.TextInput;
import com.epam.lab.driver.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LetterPage extends PageObject {
    private Boolean statusDelete;

    @FindBy(css = "#composeto")
    private TextInput mailToInput;

    @FindBy(css = ".CB.Yg")
    private Button deleteMessage;

    @FindBy(css = "#cmcsubj")
    private TextInput mailSubjectInput;

    @FindBy(css = "#cmcbodyc div")
    private TextInput mailMessageInput;

    @FindBy(css = ".M.j.T.b.hc.en.Ee")
    private Button sendButton;


    public void enterEmailTo(String mailTo) {
        mailToInput.sendKeys(mailTo);
    }

    public void enterEmailSubject(String mailSubject) {
        mailSubjectInput.sendKeys(mailSubject);
    }

    public void enterMessage(String mailMessage) {
        mailMessageInput.sendKeys(mailMessage);
    }

    public void sendLetter() {
        sendButton.click();
    }

    public boolean ifDeletedMyLetter() {
        if ((new WebDriverWait(Driver.getDriver(), 60)).until(ExpectedConditions.elementToBeClickable(deleteMessage)) != null) {
            statusDelete = true;
        }
        return statusDelete;
    }
}
