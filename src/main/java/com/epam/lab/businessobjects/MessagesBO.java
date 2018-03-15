package com.epam.lab.businessobjects;


import com.epam.lab.models.MessageModel;
import com.epam.lab.pageobjects.GmailInboxPage;
import com.epam.lab.pageobjects.LetterPage;
import com.epam.lab.pageobjects.SentPage;
import org.apache.log4j.Logger;

public class MessagesBO {
    private static final Logger LOG = Logger.getLogger(GmailLoginBO.class);
    private SentPage sentPage;
    private GmailInboxPage gmailInboxPage;
    private LetterPage letterPage;


    public MessagesBO() {
        sentPage = new SentPage();
        gmailInboxPage = new GmailInboxPage();
        letterPage = new LetterPage();
    }

    public void writeLetter(MessageModel message) {
        LOG.info("Writing Letter");
        gmailInboxPage.composeLetter();
        letterPage.enterEmailTo(message.getMailTo());
        letterPage.enterEmailSubject(message.getMailSubject());
        letterPage.enterMessage(message.getMailMessage());
        letterPage.sendLetter();
    }

    public void openSents() {
        LOG.info("Opening Sents");
        gmailInboxPage.openMenu();
        sentPage.openSents();
    }

    public void openMyLetter() {
        LOG.info("Opening Sent Letter");
        sentPage.openMyLetter();
    }

    public void deleteMyLetter() {
        LOG.info("Deleting Letter");
        sentPage.deleteMyLetter();
    }

    public boolean ifDeletedLetter() {
        return letterPage.ifDeletedMyLetter();
    }
}
