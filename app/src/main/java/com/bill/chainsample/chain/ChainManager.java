package com.bill.chainsample.chain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public enum ChainManager {

    INSTANCE;

    private Map<String, ArrayList<BaseChain>> mChainQueue = new HashMap<>();
    private Map<String, Integer> mChainSizeQueue = new HashMap<>();

    public void setChainSize(String chainKey, int size) {
        if (size > 0)
            mChainSizeQueue.put(chainKey, size);
    }

    public void finish(String chainKey) {
        mChainSizeQueue.remove(chainKey);

        ArrayList<BaseChain> list = mChainQueue.remove(chainKey);

        if (list == null)
            return;

        for (BaseChain chain : list) {
            chain.setNextHandle(null);
        }

        list.clear();
        list = null;

    }

    public BaseChain getChain(String chainKey, int serialNumber) {
        if (!mChainQueue.containsKey(chainKey)) {
            return null;
        }

        ArrayList<BaseChain> list = mChainQueue.get(chainKey);

        if (list == null)
            return null;

        for (BaseChain chain : list) {
            if (chain.serialNumber() == serialNumber)
                return chain;
        }

        return null;

    }

    public void start(String chainKey) {
        handle(chainKey);
    }

    public void add(String chainKey, BaseChain chain) {
        ArrayList<BaseChain> list = mChainQueue.get(chainKey);

        if (list == null) {
            list = new ArrayList<>();
            mChainQueue.put(chainKey, list);
        }

        chain.setChainKey(chainKey);
        add(list, chain);

        if (checkStart(chainKey, list.size()))
            handle(chainKey);
    }

    private void add(ArrayList<BaseChain> list, BaseChain chain) {
        int serialNumber = chain.serialNumber();

        for (BaseChain baseChain : list) {
            if (baseChain.serialNumber() == serialNumber) {
                throw new IllegalArgumentException("The same serialNumber exists");
            }
        }

        list.add(chain);
    }

    private boolean checkStart(String chainKey, int listSize) {
        if (!mChainSizeQueue.containsKey(chainKey)) {
            return false;
        }

        Integer size = mChainSizeQueue.get(chainKey);

        if (size == null)
            return false;

        if (listSize == size) {
            return true;
        }

        return false;
    }

    private void linkNextHandle(ArrayList<BaseChain> list) {
        Collections.sort(list, new Comparator<BaseChain>() {
            @Override
            public int compare(BaseChain o1, BaseChain o2) {
                if (o1.serialNumber() < o2.serialNumber())
                    return -1;
                else
                    return 1;
            }
        });

        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).setNextHandle(list.get(i));
        }

    }

    private void handle(String chainKey) {
        ArrayList<BaseChain> list = mChainQueue.get(chainKey);
        if (list != null && list.size() > 0) {
            linkNextHandle(list);

            list.get(0).handle();
        }
    }

}
