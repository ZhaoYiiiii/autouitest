package com.frame.demo.test;

import com.frame.demo.object.InventoryCoupling;
import org.testng.annotations.Test;

public class TestUploadInventoryPage extends InventoryCoupling {
    //dependsOnMethods = {"com.frame.demo.test.TestLoginPage.toLoginSuccessed"}
    @Test()
    public void test(){
        toCreateUploadTask("清单融合工具模块","导航-清单上传");
    }
}
