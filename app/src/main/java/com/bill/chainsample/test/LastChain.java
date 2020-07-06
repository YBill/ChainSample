package com.bill.chainsample.test;

import android.content.Context;

import com.bill.chainsample.chain.BaseChain;
import com.bill.chainsample.dialog.TestDialog3;

public class LastChain extends BaseChain {

    private Context mContext;

    public LastChain(Context context) {
        this.mContext = context;
    }

    @Override
    public void handle() {
        TestDialog3 dialog = new TestDialog3(mContext);
        dialog.show();

    }

    @Override
    public int serialNumber() {
        return 100;
    }
}
