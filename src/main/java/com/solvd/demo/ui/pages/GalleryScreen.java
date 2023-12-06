package com.solvd.demo.ui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GalleryScreen extends AbstractPage {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Back to Camera']")
    private ExtendedWebElement cameraBtn;

    @FindBy(id = "com.google.android.apps.photos:id/photos_pager_menu_all_photos")
    private ExtendedWebElement allPhotosBtn;

    public GalleryScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return cameraBtn.isElementPresent() && allPhotosBtn.isElementPresent();
    }
}
