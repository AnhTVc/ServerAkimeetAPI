package com.extent.project.english.POJO;

/**
 * Created by VietAnh on 1/24/2017.
 */
public class Question {
    private int index;
    private String content; // past 6, content null
    private String urlImage; // Anh neu co. past 7
    private String answer;
    private String explain;

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getAnswer() {
        return answer;
    }

    public String getExplain() {
        return explain;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getUrlImage() {
        return urlImage;
    }

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
