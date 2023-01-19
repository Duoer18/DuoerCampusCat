package com.duoer.campus.utils;

import java.util.ArrayList;

public class CatLock extends MyLock {
    private static final ArrayList<String> CAT_LOCK = new ArrayList<>(CAPACITY);

    static {
        for (int i = 0; i < CAPACITY; i++) {
            CAT_LOCK.add("");
        }
    }

    public static Object get(int index) {
        return CAT_LOCK.get(index % CAPACITY);
    }
}
