package com.vytrack.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

  private static Properties configFile;

  //this static block will be executed only once whenever somebody calls this class.
    //static block has the highest priority in terms of execution order.
    //the order for execution:
    //1. static block   // 2. instance block  // 3. constructor

    static {
        try {
            //location of properties file
            String path = System.getProperty("user.dir")+"/configuration.properties";
            //get that file as a stream
            FileInputStream input = new FileInputStream(path);
            //create object of Properties class
            configFile = new Properties();
            //load properties file into Properties object
            configFile.load(input);
            //close the input s
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }

    }

    /**
     * This method returns property value from configuration.properties file
     * @param keyName property name
     * @return property value
     */
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }
}