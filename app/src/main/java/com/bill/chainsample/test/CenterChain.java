package com.bill.chainsample.test;

import com.bill.chainsample.chain.BaseChain;

public class CenterChain extends BaseChain {

    public CenterChain() {

    }

    @Override
    public void handle() {
        // Do someThing

        handleNext();
    }

    @Override
    public int serialNumber() {
        return 2;
    }
}
