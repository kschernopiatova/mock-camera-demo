package com.solvd.demo;

import com.solvd.demo.ui.pages.GalleryScreen;
import com.solvd.demo.ui.pages.MainScreen;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest extends MockCameraTest {

    @Test
    public void takePhotoTest() {
        System.out.println(R.CONFIG.get("capabilities.app"));
        MainScreen mainScreen = new MainScreen(getDriver());
        Assert.assertTrue(mainScreen.isPageOpened(), "Main page isn't opened!");
        mainScreen.takePhoto();
        GalleryScreen galleryScreen = mainScreen.openGallery();
        Assert.assertTrue(galleryScreen.isPageOpened(), "Gallery page isn't opened!");
    }

}
