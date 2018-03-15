package com.epam.lab;

import com.epam.lab.businessobjects.GmailLoginBO;
import com.epam.lab.businessobjects.MessagesBO;
import com.epam.lab.driver.Driver;
import com.epam.lab.models.MessageModel;
import com.epam.lab.models.UserModel;
import com.epam.lab.utils.provider.TestProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class TestGmail {
    private GmailLoginBO gmailLoginBO;
    private MessagesBO messagesBO;

    @BeforeMethod
    public void setUp() {
        gmailLoginBO = new GmailLoginBO();
        messagesBO = new MessagesBO();
    }

    @Test(dataProvider = "getUsersData", dataProviderClass = TestProvider.class)
    public void sendFromDrafts(UserModel userModel, MessageModel message) {

        gmailLoginBO.openLoginPage();

        gmailLoginBO.loginAS(userModel);

        assertTrue(gmailLoginBO.checkLoginSuccess());

        messagesBO.writeLetter(message);

        messagesBO.openSents();

        messagesBO.openMyLetter();

        messagesBO.deleteMyLetter();

        assertTrue(messagesBO.ifDeletedLetter());
    }

    @AfterMethod
    public void closeDriver() {
        Driver.close();
    }
}