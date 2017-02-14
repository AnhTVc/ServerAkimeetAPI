package com.extent.project.english.POJO;

import java.util.ArrayList;

/**
 * Created by VietAnh on 2/13/2017.
 */
public class BlockQuestionPast3 {
    ArrayList<QuestionPast3> questionPast3s;

    String audioScript;

    public void setAudioScript(String audioScript) {
        this.audioScript = audioScript;
    }

    public String getAudioScript() {
        return audioScript;
    }

    public void setQuestionPast3s(ArrayList<QuestionPast3> questionPast3s) {
        this.questionPast3s = questionPast3s;
    }

    public ArrayList<QuestionPast3> getQuestionPast3s() {
        return questionPast3s;
    }
}
