package com.project.POJO.result;

/**
 * Created by VietAnh on 11/1/2016.
 */
public class Licence {
    private int id;
    private String project;
    private String email;
    private String serial;
    private int install;
    private String log;

    private int maxinstall;

    public void setMaxinstall(int maxinstall) {
        this.maxinstall = maxinstall;
    }

    public int getMaxinstall() {
        return maxinstall;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setInstall(int install) {
        this.install = install;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public int getId() {
        return id;
    }

    public String getProject() {
        return project;
    }

    public String getEmail() {
        return email;
    }

    public String getSerial() {
        return serial;
    }

    public int getInstall() {
        return install;
    }

    public String getLog() {
        return log;
    }
}
