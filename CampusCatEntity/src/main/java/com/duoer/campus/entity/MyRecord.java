package com.duoer.campus.entity;

public abstract class MyRecord {
    protected Integer recordId;
    protected Integer catId;
    protected String catName;
    protected String username;
    protected Integer locationId;
    protected String location;
    protected String recordTime;
    protected String lastUpdate;
    protected Integer formerId;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
        // this.location = NormalAttributesExchanger.locationMap.get(locationId);
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getFormerId() {
        return formerId;
    }

    public void setFormerId(Integer formerId) {
        this.formerId = formerId;
    }

    @Override
    public String toString() {
        return "MyRecord{" +
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
