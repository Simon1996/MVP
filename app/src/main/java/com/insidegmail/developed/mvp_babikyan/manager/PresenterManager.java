package com.insidegmail.developed.mvp_babikyan.manager;

import android.support.v4.util.ArrayMap;

import com.insidegmail.developed.mvp_babikyan.main.presenter.BasePresenter;
import com.insidegmail.developed.mvp_babikyan.main.presenter.PresenterFactory;

import java.util.Map;

/**
 * Created by Admin on 21.11.2017.
 */

public class PresenterManager {
    private Map<String, BasePresenter> map;

    public PresenterManager() {
        map = new ArrayMap<>();
    }

   public  <P extends BasePresenter>P getPresenter(String key, PresenterFactory<P> presenterFactory) {
        if (map.get(key)== null) {
            map.put(key, presenterFactory.createPresenter());
        }
    return (P) map.get(key);
    }

    public void removePresenter(String key) {
        map.remove(key);
    }
}
