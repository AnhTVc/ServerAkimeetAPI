package com.project.POJO.result;

/**
 * Created by VietAnh on 11/4/2016.
 */
public class DeviceInfo {
    private String imeiSIM;
    private String nameDevice;
    private String androidVersion;
    private String serial; // MAC wifi

    public void setImeiSIM(String imeiSIM) {
        this.imeiSIM = imeiSIM;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getImeiSIM() {
        return imeiSIM;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public String getSerial() {
        return serial;
    }
}
