package com.extent.project.english.POJO;

/**
 * Created by VietAnh on 1/24/2017.
 */
public class Question {
    private int index;
    private String content; // past 6, content null

    public void setIndex(int index) {
        this.index = index;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public String getContent() {
        return content;
    }
}
