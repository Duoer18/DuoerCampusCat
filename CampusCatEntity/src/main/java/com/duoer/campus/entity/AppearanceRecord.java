package com.duoer.campus.entity;

public class AppearanceRecord extends MyRecord {
    @Override
    public String toString() {
        return "AppearanceRecord{" +
                "recordId=" + recordId +
                ", catId=" + catId +
                ", catName='" + catName + '\'' +
                ", username='" + username + '\'' +
                ", locationId=" + locationId +
                ", location='" + location + '\'' +
                ", recordTime='" + recordTime + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", formerId=" + formerId +
                '}';
    }
}
