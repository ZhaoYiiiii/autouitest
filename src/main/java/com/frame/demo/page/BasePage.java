package com.frame.demo.page;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.frame.demo.base.GetDriverUtil;
import com.frame.demo.utils.BaseInfo;
import com.frame.demo.utils.ReadExcelUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private static Logger logger=Logger.getLogger(BasePage.class);
    static WebDriver driver;
    Map<String,String> elementData;
    public BasePage(){
        String browserType= BaseInfo.getBrowserType();
        driver= GetDriverUtil.getDriver();
        driver.manage().window().maximize();
        PageFactory.initElements(driver,this);
        elementData= ReadExcelUtil.getElementData();
    }
    public BasePage(WebDriver webdriver){
        driver=webdriver;
    }
    /**
     * 封装by方法
     * @param method
     * @param methodValue
     * @return
     */
    private By getBy(String method,String methodValue){
        if(method.equalsIgnoreCase("id")){
            return By.id(methodValue);
        }else if(method.equalsIgnoreCase("name")){
            return By.name(methodValue);
        }else if(method.equalsIgnoreCase("tagName")){
            return By.tagName(methodValue);
        }else if(method.equalsIgnoreCase("className")){
            return By.className(methodValue);
        }else if(method.equalsIgnoreCase("linkText")){
            return By.linkText(methodValue);
        }else if(method.equalsIgnoreCase("xpath")){
            return By.xpath(methodValue);
        }else if(method.equalsIgnoreCase("cssSelector")){
            return By.cssSelector(methodValue);
        }else{
            return By.partialLinkText(methodValue);
        }
    }

    /**
     * 通过名称生成对应的WebElement
     * @param name
     * @return
     */
    public WebElement findElement(String name){
        String data=elementData.get(name).toString();
        String method=data.split(",")[0];
        String methodValue=data.split(",")[1];
        logger.info("获取元素控件"+name);
        return driver.findElement(this.getBy(method,methodValue));
    }

    /**
     * 切换frame
     * @param frame
     */
    public void swithToFrame(int frame){
        driver.switchTo().frame(frame);
    }

    /**
     * 跳转至对应界面
     */
    public void open(){
        String url=BaseInfo.getUrl();
        logger.info("跳转至:"+url);
        driver.get(url);
    }


    /**
     * 设置隐式等待时间
     * @param time
     */
    public void setImplicitylyWaitTime(long time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    /**
     * 退出浏览器控制
     */
    public void quit(){
        logger.info("关闭浏览器成功!");
        driver.quit();
    }

}
