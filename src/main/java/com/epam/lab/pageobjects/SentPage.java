package com.epam.lab.pageobjects;


import com.epam.lab.control.elements.Button;
import com.epam.lab.control.elements.TextInput;
import org.openqa.selenium.support.FindBy;

public class SentPage extends PageObject {

    @FindBy(css = "div[class='dl ql ec']:nth-child(7)")
    private Button sentButton;

    @FindBy(css = ".V.j.Vd")
    private TextInput deleteButton;

    @FindBy(css = ".Nh.Am div")
    private Button myLetter;

    public void openSents() {
        sentButton.click();
    }


    public void openMyLetter() {
        myLetter.click();
    }

    public void deleteMyLetter() {
        deleteButton.click();
    }
}
