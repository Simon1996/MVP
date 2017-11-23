package com.insidegmail.developed.mvp_babikyan.application;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.insidegmail.developed.mvp_babikyan.network.Net;
import com.insidegmail.developed.mvp_babikyan.manager.NetManager;
import com.insidegmail.developed.mvp_babikyan.manager.PresenterManager;

/**
 * Created by Admin on 21.11.2017.
 */

public class MyApp extends Application implements AApp {

    private Net net;
    private PresenterManager presenterManager;
    private NetManager netManager;

    @NonNull
    public static AApp getApp(@NonNull Context context) {
        return (AApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        netManager = new NetManager();
        net = new NetManager();
        presenterManager = new PresenterManager();
    }


    @Override
    public Net getNet() {
        return net;
    }

    @Override
    public NetManager getNetManager() {
        return netManager;
    }

    @Override
    public PresenterManager getPresenterManager() {
        return presenterManager;
    }


}

