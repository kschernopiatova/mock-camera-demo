package com.solvd.demo.ui.pages;

import com.solvd.demo.ui.modals.OpenCameraModal;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MainScreen extends AbstractPage {

    @FindBy(id = "net.sourceforge.opencamera:id/take_photo")
    private ExtendedWebElement takePhotoBtn;

    @FindBy(id = "net.sourceforge.opencamera:id/gallery")
    private ExtendedWebElement galleryBtn;

    @FindBy(id = "android:id/parentPanel")
    private OpenCameraModal openCameraModal;

    public MainScreen(WebDriver driver) {
        super(driver);
        if (openCameraModal.isUIObjectPresent()) {
            openCameraModal.closeModal();
        }
    }

    public void takePhoto() {
        takePhotoBtn.click();
    }

    public GalleryScreen openGallery() {
        galleryBtn.click();
        return new GalleryScreen(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return takePhotoBtn.isElementPresent();
    }

}
