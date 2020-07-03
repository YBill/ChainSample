package com.bill.chainsample.test;

public interface DialogHandlerListener {

    /**
     * 确认，执行相关逻辑
     */
    void confirm();

    /**
     * 点击关闭Dialog
     */
    void close();

    /**
     * 不符合相关逻辑，跳过弹窗
     */
    void skip();

}
