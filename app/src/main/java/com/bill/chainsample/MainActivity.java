package com.bill.chainsample;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bill.chainsample.chain.BaseChain;
import com.bill.chainsample.chain.ChainManager;
import com.bill.chainsample.test.CenterChain;
import com.bill.chainsample.test.FirstChain;
import com.bill.chainsample.test.LastChain;
import com.bill.chainsample.test.ThirdChain;

public class MainActivity extends AppCompatActivity {

    private static final String MAIN_KEY = "main_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChainManager.INSTANCE.setChainSize(MAIN_KEY, 4);

        BaseChain lastChain = new LastChain(this);
        ChainManager.INSTANCE.add(MAIN_KEY, lastChain);

        BaseChain firstChain = new FirstChain(this);
        ChainManager.INSTANCE.add(MAIN_KEY, firstChain);

        BaseChain thirdChain = new ThirdChain(this);
        ChainManager.INSTANCE.add(MAIN_KEY, thirdChain);

    }

    public void handleClick(View view) {
//        ChainManager.INSTANCE.start(MAIN_KEY);

        BaseChain centerChain = new CenterChain(this);
        ChainManager.INSTANCE.add(MAIN_KEY, centerChain);
    }
}
