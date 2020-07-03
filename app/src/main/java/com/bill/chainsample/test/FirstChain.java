package com.bill.chainsample.test;

import android.content.Context;

import com.bill.chainsample.chain.BaseChain;
import com.bill.chainsample.dialog.TestDialog1;

public class FirstChain extends BaseChain {

    public FirstChain(Context context) {
        super(context);
    }

    @Override
    protected void handle() {
        TestDialog1 dialog = new TestDialog1(mContext);
        dialog.show();

        dialog.setListener(new DefaultDialogListener() {
            @Override
            public void close() {
                handleNext();
            }
        });
    }

    @Override
    protected int serialNumber() {
        return 1;
    }
}
