package com.fine.fineapp.utils;

import de.greenrobot.event.EventBus;

/**
 * 各个模块中回调使用
 * Created by YiMuTian on 2017/3/29.
 */

public class EventBusManager {

    private static EventBusManager busManager;
    private EventBus globalEventBus;

    private EventBusManager() {
    }

    public EventBus getGlobaEventBus() {
        if (globalEventBus == null) {
            globalEventBus = new EventBus();
        }
        return globalEventBus;
    }

    public static EventBusManager getInstance() {
        if (busManager == null) {
            synchronized (EventBusManager.class) {
                if (busManager == null) {
                    busManager = new EventBusManager();
                }
            }
        }
        return busManager;
    }

}
