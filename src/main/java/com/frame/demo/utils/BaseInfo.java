package com.frame.demo.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class BaseInfo {

    /**
     * 获取config文件中的browserType值
     * @return
     */
    public static String getBrowserType(){
        return getInfo("browserType");
    }
    public static String getUrl(){
        return getInfo("url");
    }
    /**
     * 输入参数名，在config中获取对应的值
     * @param key
     * @return
     */
    public static String getInfo(String key){
        ResourceBundle bundle = ResourceBundle.getBundle("config", Locale.CHINA);
        String value=bundle.getString(key);
        return value;
    }
}
