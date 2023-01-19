package com.duoer.campus.utils;

import java.util.ArrayList;

public class RecordLock extends MyLock {
    private static final ArrayList<String> F_LOCK = new ArrayList<>(CAPACITY);
    private static final ArrayList<String> A_LOCK = new ArrayList<>(CAPACITY);

    static {
        for (int i = 0; i < CAPACITY; i++) {
            F_LOCK.add("");
            A_LOCK.add("");
        }
    }

    public static String getFeedingLock(int index) {
        return F_LOCK.get(index % CAPACITY);
    }

    public static String getAppearanceLock(int index) {
        return A_LOCK.get(index % CAPACITY);
    }
}
