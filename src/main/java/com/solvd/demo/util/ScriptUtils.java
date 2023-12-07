package com.solvd.demo.util;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import java.io.IOException;

public class ScriptUtils {

    public static void runScript(String command){
        try {
            CommandLine oCmdLine = CommandLine.parse(command);
            DefaultExecutor oDefaultExecutor = new DefaultExecutor();
            oDefaultExecutor.setExitValue(0);
            oDefaultExecutor.execute(oCmdLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
