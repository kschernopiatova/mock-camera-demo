package com.solvd.demo;

import com.solvd.demo.util.ScriptUtils;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class MockCameraTest implements IAbstractTest, IMobileUtils {

    @BeforeSuite
    public void beforeSuite() {
        if (R.CONFIG.getBoolean("mock_camera")) {
            ScriptUtils.runScript("sh ./scripts.sh");
            String appPath = R.CONFIG.get("capabilities.app");
            appPath = appPath.substring(0, appPath.lastIndexOf("/") + 1) + "camera-aligned.apk";
            R.CONFIG.put("capabilities.app", appPath);
        }
    }

    @AfterSuite
    public void afterSuite() {
        if (R.CONFIG.getBoolean("mock_camera"))
            ScriptUtils.runScript("sh ./clean.sh");
    }

}
