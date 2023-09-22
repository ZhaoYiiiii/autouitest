package com.frame.demo.object;
import org.testng.Assert;
import com.frame.demo.action.Action;



public class LoginPage extends Action {

    public void login(String userName,String pwd,String expected) throws InterruptedException {
        open();
      //  click("密码登录");
      //  swithToFrame(0);
        sendKeys("输入用户名",userName);
        sendKeys("输入密码",pwd);
        click("单击登录");
//        Thread.sleep(1000);
        setImplicitylyWaitTime(3);
        String msg=getText("登录成功标识");
        Assert.assertEquals(msg,expected);
     //   quit();
    }


/*    public void loginFailedByPassword(String userName,String pwd,String expected) throws InterruptedException{
        open();
        sendKeys("输入用户名",userName);
        sendKeys("输入密码",pwd);
        click("单击登录");
        Thread.sleep(1000);

        String msg=getText("错误提示信息");
        Assert.assertEquals(msg,expected);
        //  quit();
    }*/

/*    public void toCreateUploadTask(String module,String navigate){
        click(module);
        click(navigate);
    }*/
}
