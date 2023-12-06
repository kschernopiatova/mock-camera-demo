package com.solvd.demo.ui.pages;

import com.solvd.demo.ui.modals.OpenCameraModal;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class MainScreen extends AbstractPage {

    @FindBy(id = "net.sourceforge.opencamera:id/take_photo")
    private ExtendedWebElement takePhotoBtn;

    @FindBy(id = "net.sourceforge.opencamera:id/gallery")
    private ExtendedWebElement galleryBtn;

    @FindBy(id = "android:id/parentPanel")
    private OpenCameraModal openCameraModal;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public MainScreen(WebDriver driver) {
        super(driver);
        if (openCameraModal.isUIObjectPresent()) {
            openCameraModal.closeModal();
        }
    }

    public void takePhoto() {
        takePhotoBtn.click();
        LOGGER.info("Taking mock photo");
    }

    public GalleryScreen openGallery() {
        galleryBtn.click();
        LOGGER.info("Opening gallery");
        return new GalleryScreen(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return takePhotoBtn.isElementPresent();
    }

}
