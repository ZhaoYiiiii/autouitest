package com.frame.demo.test;

import com.frame.demo.object.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPage extends LoginPage {
    @Test(testName = "用户登录成功",groups ={"登录"},enabled = true)
    public void toLoginSuccessed() throws InterruptedException {
        login("zhaoyi","zhaoyi123456","您好！欢迎使用本平台，您可以使用以下工具");
    }

    @Test(testName = "用户登录失败并提示密码错误",enabled = false)
    public void toLoginFailed() throws InterruptedException {
       // loginFailedByPassword("zhaoyi","zhaoyi","错误提示信息");
    }



}
