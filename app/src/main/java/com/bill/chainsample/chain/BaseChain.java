package com.bill.chainsample.chain;

public abstract class BaseChain {

    private String chainKey;

    private BaseChain nextHandle;

    public abstract void handle();

    public abstract int serialNumber();

    public String getChainKey() {
        return chainKey;
    }

    public void setChainKey(String chainKey) {
        this.chainKey = chainKey;
    }

    public void setNextHandle(BaseChain nextHandle) {
        this.nextHandle = nextHandle;
    }

    public void handleNext() {
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

    public void handleFinish() {
        ChainManager.INSTANCE.finish(chainKey);
    }

}
