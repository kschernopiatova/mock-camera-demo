package com.solvd.demo.ui.modals;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class OpenCameraModal extends AbstractUIObject {

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement okBtn;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public OpenCameraModal(WebDriver driver) {
        super(driver);
    }

    public OpenCameraModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void closeModal() {
        okBtn.click();
        LOGGER.info("Closing open camera modal");
    }
}
