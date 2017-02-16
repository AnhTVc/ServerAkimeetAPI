package com.extent.project.english.POJO;

import java.util.ArrayList;

/**
 * Created by VietAnh on 1/24/2017.
 * Tập các câu hỏi
 * 3 câu hỏi 1 block
 */
public class QuestionPast6 {
    private int index;
    private String answer;
    private String explain;
    private String question;

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public int getIndex() {
        return index;
    }

    public String getAnswer() {
        return answer;
    }

    public String getExplain() {
        return explain;
    }
}
