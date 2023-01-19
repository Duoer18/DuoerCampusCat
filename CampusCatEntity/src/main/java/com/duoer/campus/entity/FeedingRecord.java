package com.duoer.campus.entity;

public class FeedingRecord extends MyRecord {
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "FeedingRecord{" +
                "remarks='" + remarks + '\'' +
                ", recordId=" + recordId +
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
