package com.frame.demo2.xUtils;

import org.openqa.selenium.WebElement;

public interface UIExcutor {
    //点击
    public void clike(Position position) throws Exception;
    //输入文本
    public void sendKey(Position position,String value) throws Exception;
    //获取元素文本
    public String getText(Position position) throws Exception;
    //获取元素
    public WebElement getElement(Position position) throws Exception;
    //判断元素是否显示
    public boolean isElementDisplayed(Position position) throws Exception;
    //切换页面
    public void swithWindow(String winTitle) throws Exception;
    //切换frame
    public void switchFrame(Position position) throws Exception;
    //智能等待
    public void waitElement(Position position) throws Exception;
    //获取弹窗的文字(并关闭弹窗)
    public String getAlertText();
    //获取元素属性
    public String getAtrribute(Position position,String attributeName) throws Exception;
    //javaScript强制点击
    public void jsClikc(Position position)throws Exception;
}
