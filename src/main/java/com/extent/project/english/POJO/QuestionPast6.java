package com.extent.project.english.POJO;

import java.util.ArrayList;

/**
 * Created by VietAnh on 1/24/2017.
 * Tập các câu hỏi
 * 3 câu hỏi 1 block
 */
public class QuestionPast6 {
    private int index;
    private String readContent;
    private ArrayList<AnswerKey> answerKeys; // Danh sách các câu tra lời cho từng bài viết (3 câu hỏi trên 1 bài)

    public void setIndex(int index) {
        this.index = index;
    }

    public void setReadContent(String readContent) {
        this.readContent = readContent;
    }

    public void setAnswerKeys(ArrayList<AnswerKey> answerKeys) {
        this.answerKeys = answerKeys;
    }

    public int getIndex() {
        return index;
    }

    public String getReadContent() {
        return readContent;
    }

    public ArrayList<AnswerKey> getAnswerKeys() {
        return answerKeys;
    }
}
