package com.bill.chainsample.test;

import android.content.Context;

import com.bill.chainsample.chain.BaseChain;
import com.bill.chainsample.dialog.TestDialog3;

public class LastChain extends BaseChain {

    public LastChain(Context context) {
        super(context);
    }

    @Override
    protected void handle() {
        TestDialog3 dialog = new TestDialog3(mContext);
        dialog.show();

    }

    @Override
    protected int serialNumber() {
        return 100;
    }
}
