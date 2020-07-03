package com.bill.chainsample.chain;

import android.content.Context;

public abstract class BaseChain {

    protected Context mContext;

    protected String chainKey;

    public BaseChain(Context context) {
        mContext = context;
    }

    protected BaseChain nextHandle;

    protected abstract void handle();

    protected abstract int serialNumber();

    protected void handleNext() {
        BaseChain lastHandle = null;

        if (nextHandle != null) {
            lastHandle = nextHandle.nextHandle;
            nextHandle.handle();
        }

        nextHandle = null;

        if (lastHandle == null) {
            ChainManager.INSTANCE.finish(chainKey);
        }
    }

}
