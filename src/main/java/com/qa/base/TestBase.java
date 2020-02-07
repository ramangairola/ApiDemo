package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public Properties prop;
    public TestBase(){
        try {
            prop = new Properties();
            String locationOfConfiqFile = System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\confiq\\confiq.properties";
            FileInputStream ip = new FileInputStream(locationOfConfiqFile);
            prop.load(ip);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
