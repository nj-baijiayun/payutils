package com.baijiayun.www.payutils;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.baijiayun.www.paylibs.alipay.AliPayConfig;
import com.baijiayun.www.paylibs.alipay.AliPayManager;
import com.baijiayun.www.paylibs.alipay.call.AliPayStatusCall;
import com.baijiayun.www.payutils.mvp.contranct.LoginContranct;
import com.baijiayun.www.payutils.mvp.presenter.LoginPresenter;
import com.wb.baselib.base.activity.MvpActivity;

public class MainActivity extends MvpActivity<LoginPresenter> implements LoginContranct.LoginView {
    private Button button;
    @Override
    protected LoginPresenter onCreatePresenter() {
        return new LoginPresenter(this);
    }
    @Override
    protected void initView(Bundle bundle) {
        setContentView(R.layout.layout_login);
        Log.e("进来了","------");
        button=getViewById(R.id.pay_bt);
    }

    @Override
    protected void setListener() {
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.pay_bt:
                testPay();
                break;
        }
    }
    String payJson="app_id=2018112962395285&format=JSON&charset=utf-8&sign_type=RSA2&version=1.0&return_url=https%3A%2F%2Ftestwxwap33.baijiayun.com%2Fmy-study&notify_url=https%3A%2F%2Ftestwx33.baijiayun.com%2Fapi%2Fpay%2FaliNotify&timestamp=2019-11-04+10%3A28%3A56&biz_content=%7B%22out_trade_no%22%3A%22P2019110410285631626%22%2C%22total_amount%22%3A%220.01%22%2C%22subject%22%3A%22SZS%5Cu56fe%5Cu6587%5Cu8bfe1%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&method=alipay.trade.app.pay&sign=We3L7Ek69wltLnZMUyy%2BCbxZqC%2FiNsk1PqUauVlCZD4YyAT5BRn8LfaM7Sqk7zgnnNAywRc9pNqXUfoOKX%2BnCIYT869MDg9eidA0QLYFeQ0Ld6rXeKKddDHmbHwkALnNou0O%2FfGFcurum8aS%2Ba67t2PV7BK8Eop31jyVfsXaLJ9f0DbQ2Fezm8myUpIxHoe1lfSv%2FcVSrlT4mbJhgdCbzqLAC7P0RNg%2Beit5OK228Ajy7MxiCJA0Oq5%2FzqnG7YXO5uEVL8uQwpAfeIDVUW3VGUJCo%2FMp6ZpRFhieftLJDOZ1CxC4suASGm9sYJKGN2cWVQ9pNfUYaEp2imPeMFxLbQ%3D%3D";

    private void testPay() {
        AliPayConfig aliPayConfig = new AliPayConfig.Builder()
                .with(this)
                .setSignedOrder(payJson)
                .setmCall(new AliPayStatusCall() {
                              @Override
                              public void getPayAliPayStatus(String msg, boolean isPaySuccess) {

                              }
                          }
                        //isPaySuccess返回true 表示支付成功
                ).builder();
        AliPayManager.getInstance().sendPay(aliPayConfig);

    }

    @Override
    protected void processLogic(Bundle bundle) {

    }

    @Override
    public void showErrorMsg(String s) {

    }

    @Override
    public void showLoadV(String s) {

    }

    @Override
    public void closeLoadV() {

    }
}
