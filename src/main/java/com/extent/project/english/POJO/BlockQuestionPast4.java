package com.extent.project.english.POJO;

import java.util.ArrayList;

/**
 * Created by VietAnh on 2/13/2017.
 */
public class BlockQuestionPast4 {
    ArrayList<QuestionPast4> questionPast4s;
    String audioScript;

    public void setQuestionPast4s(ArrayList<QuestionPast4> questionPast4s) {
        this.questionPast4s = questionPast4s;
    }

    public void setAudioScript(String audioScript) {
        this.audioScript = audioScript;
    }

    public ArrayList<QuestionPast4> getQuestionPast4s() {
        return questionPast4s;
    }

    public String getAudioScript() {
        return audioScript;
    }
}
