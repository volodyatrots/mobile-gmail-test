package com.epam.lab.pageobjects;


import com.epam.lab.control.CustomFieldDecorator;
import com.epam.lab.driver.Driver;
import org.openqa.selenium.support.PageFactory;


class PageObject {

    PageObject() {
        PageFactory.initElements(new CustomFieldDecorator(Driver.getDriver()), this);
    }
}
