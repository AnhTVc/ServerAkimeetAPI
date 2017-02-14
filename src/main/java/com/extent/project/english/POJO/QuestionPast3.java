package com.extent.project.english.POJO;

/**
 * Created by VietAnh on 1/24/2017.
 */
public class QuestionPast3 {
    private int index;
    private String question;
    private String answer;
    private String explain;

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public int getIndex() {
        return index;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }


    public String getExplain() {
        return explain;
    }
}
