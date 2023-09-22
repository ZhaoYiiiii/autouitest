package com.frame.demo.object;

import com.frame.demo.action.Action;

public class InventoryCoupling extends Action{
    public void toCreateUploadTask(String module,String navigate){
       click(module);
       click(navigate);
    }
}
