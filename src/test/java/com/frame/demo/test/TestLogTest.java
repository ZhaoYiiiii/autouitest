package com.frame.demo.test;

import com.frame.demo.base.GetDriverUtil;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestLogTest {
    @Test
    public void test1(){
        BasicConfigurator.configure();
        Logger logger = Logger.getLogger(TestLogTest.class);

        //debug是默认的级别，所以不会输出trace信息
        logger.fatal("fatal信息");
        logger.error("error信息");
        logger.warn("warn信息");
    }

    @Test
    public void test2(){
        Logger logger=Logger.getLogger(TestLogTest.class);
        logger.fatal("fatal信息");
        logger.error("error信息");
    }
    @Test
    public void test3(){
        //设置logger读取配置文件和一些系统日志
        LogLog.setInternalDebugging(true);
        Logger logger=Logger.getLogger(TestLogTest.class);
        logger.fatal("fatal信息");
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }
    @Test
    public void test4(){
        String s="sS";
        boolean result=s.equalsIgnoreCase("ss");
        System.out.println(result);
    }
    @Test
    public void test5(){
        ChromeDriver driver= (ChromeDriver) GetDriverUtil.getDriver();
        driver.get("http://www.baidu.com");

    }




}