package com.bill.chainsample.test;

import android.content.Context;

import com.bill.chainsample.chain.BaseChain;

public class CenterChain extends BaseChain {

    public CenterChain(Context context) {
        super(context);
    }

    @Override
    protected void handle() {
        // Do someThing

        handleNext();
    }

    @Override
    protected int serialNumber() {
        return 2;
    }
}
