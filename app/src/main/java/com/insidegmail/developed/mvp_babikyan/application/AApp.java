package com.insidegmail.developed.mvp_babikyan.application;

import com.insidegmail.developed.mvp_babikyan.network.Net;
import com.insidegmail.developed.mvp_babikyan.manager.NetManager;
import com.insidegmail.developed.mvp_babikyan.manager.PresenterManager;

/**
 * Created by Admin on 21.11.2017.
 */


public interface AApp {
    Net getNet();

    NetManager getNetManager();

    PresenterManager getPresenterManager();
}