package com.extent.project.english.POJO;

import java.util.ArrayList;

/**
 * Created by AnhTVc on 2/15/17.
 */
public class BlockQuestionPast7 {
    private ArrayList<QuestionPast6> questionPast7s;
    private String readContent;

    public void setQuestionPast7s(ArrayList<QuestionPast6> questionPast7s) {
        this.questionPast7s = questionPast7s;
    }

    public void setReadContent(String readContent) {
        this.readContent = readContent;
    }

    public ArrayList<QuestionPast6> getQuestionPast7s() {
        return questionPast7s;
    }

    public String getReadContent() {
        return readContent;
    }
}
