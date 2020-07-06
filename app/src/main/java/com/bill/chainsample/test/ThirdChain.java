package com.bill.chainsample.test;

import android.content.Context;

import com.bill.chainsample.chain.BaseChain;
import com.bill.chainsample.dialog.TestDialog2;

public class ThirdChain extends BaseChain {

    private Context mContext;

    public ThirdChain(Context context) {
        this.mContext = context;
    }

    @Override
    public void handle() {
        TestDialog2 dialog = new TestDialog2(mContext);
        dialog.show();

        dialog.setListener(new DefaultDialogListener() {
            @Override
            public void close() {
                handleFinish();
            }

            @Override
            public void confirm() {
                handleNext();
            }
        });
    }

    @Override
    public int serialNumber() {
        return 30;
    }
}
