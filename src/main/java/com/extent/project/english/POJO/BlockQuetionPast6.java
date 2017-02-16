package com.extent.project.english.POJO;

import java.util.ArrayList;

/**
 * Created by AnhTVc on 2/15/17.
 */
public class BlockQuetionPast6 {
    private ArrayList<QuestionPast6> questionPast6s;
    private String readContent;

    public void setQuestionPast6s(ArrayList<QuestionPast6> questionPast6s) {
        this.questionPast6s = questionPast6s;
    }

    public void setReadContent(String readContent) {
        this.readContent = readContent;
    }

    public ArrayList<QuestionPast6> getQuestionPast6s() {
        return questionPast6s;
    }

    public String getReadContent() {
        return readContent;
    }
}
