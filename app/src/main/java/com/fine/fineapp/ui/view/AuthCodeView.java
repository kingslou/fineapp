package com.fine.fineapp.ui.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.widget.TextView;

import com.fine.fineapp.R;

/**
 * 发送验证码倒计时控件
 * Created by jin on 2016.03.05.
 */
public class AuthCodeView extends TextView {

    String inputPhone = "";

    public AuthCodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
//        setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendPhoneMessage();
//            }
//        });
    }

    public void setPhoneString(String phone) {
        inputPhone = phone;
    }

    public void startTimer() {
        countDownTimer.cancel();
        countDownTimer.start();
    }

    public void onStop() {
        countDownTimer.cancel();
        countDownTimer.onFinish();
    }

    private CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {

        public void onTick(long millisUntilFinished) {
            AuthCodeView.this.setText(String.format(getContext().getString(R.string.str_auth_code), millisUntilFinished / 1000));
            AuthCodeView.this.setEnabled(false);
        }
        public void onFinish() {
            AuthCodeView.this.setEnabled(true);
            AuthCodeView.this.setText(getContext().getString(R.string.str_auth_code_send_tip));
        }
    };

    void sendPhoneMessage() {
        countDownTimer.start();
    }
}
