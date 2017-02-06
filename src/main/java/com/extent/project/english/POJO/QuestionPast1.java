package com.extent.project.english.POJO;

/**
 * Created by VietAnh on 1/24/2017.
 */
public class QuestionPast1 {
    private int index;
    private String urlImage;
    private String urlMP3;
    private String audioScript;
    private String answer;
    private String explain;

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getExplain() {
        return explain;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public void setAudioScript(String audioScript) {
        this.audioScript = audioScript;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }



    public int getIndex() {
        return index;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getAudioScript() {
        return audioScript;
    }

    public String getAnswer() {
        return answer;
    }

    public void setUrlMP3(String urlMP3) {
        this.urlMP3 = urlMP3;
    }

    public String getUrlMP3() {
        return urlMP3;
    }
}
