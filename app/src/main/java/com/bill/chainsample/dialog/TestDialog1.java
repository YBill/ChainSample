package com.bill.chainsample.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.bill.chainsample.R;
import com.bill.chainsample.test.DialogHandlerListener;

public class TestDialog1 extends BaseDialog {

    private DialogHandlerListener listener;

    public void setListener(DialogHandlerListener listener) {
        this.listener = listener;
    }

    public TestDialog1(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatButton continueBtn = findViewById(R.id.btn_continue);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (listener != null)
                    listener.close();
            }
        });
    }

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_test_1;
    }

}
