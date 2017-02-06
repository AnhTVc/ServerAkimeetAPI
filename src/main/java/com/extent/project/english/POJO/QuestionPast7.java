package com.extent.project.english.POJO;

import java.util.ArrayList;

/**
 * Created by VietAnh on 1/24/2017.
 */
public class QuestionPast7 {
    private int index;
    private String readContent;
    private int range;
    private ArrayList<Question> questions;
    private ArrayList<AnswerKey> answerKeys;

    public void setAnswerKeys(ArrayList<AnswerKey> answerKeys) {
        this.answerKeys = answerKeys;
    }

    public ArrayList<AnswerKey> getAnswerKeys() {
        return answerKeys;
    }

    public  QuestionPast7(){}
    public QuestionPast7(int range){
        this.range = range;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public void setReadContent(String readContent) {
        this.readContent = readContent;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public int getIndex() {
        return index;
    }

    public String getReadContent() {
        return readContent;
    }

    public int getRange() {
        return range;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
