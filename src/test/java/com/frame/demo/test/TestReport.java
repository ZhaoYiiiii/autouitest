package com.frame.demo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestReport {
    @Test
    public void testMethodOne(){
        Assert.assertTrue(true);
    }
    @Test
    public void testMethodTwo(){
        Assert.assertTrue(false);
    }
    @Test
    public void testMethodThree(){
        Assert.assertTrue(true);
    }
}
