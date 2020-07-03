package com.bill.chainsample.test;

import android.content.Context;

import com.bill.chainsample.chain.BaseChain;
import com.bill.chainsample.chain.ChainManager;
import com.bill.chainsample.dialog.TestDialog2;

public class ThirdChain extends BaseChain {

    public ThirdChain(Context context) {
        super(context);
    }

    @Override
    protected void handle() {
        TestDialog2 dialog = new TestDialog2(mContext);
        dialog.show();

        dialog.setListener(new DefaultDialogListener() {
            @Override
            public void close() {
                ChainManager.INSTANCE.finish(chainKey);
            }

            @Override
            public void confirm() {
                handleNext();
            }
        });
    }

    @Override
    protected int serialNumber() {
        return 30;
    }
}
