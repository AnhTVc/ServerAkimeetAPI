package com.project.POJO;

/**
 * Created by nguyennhunai on 26/07/2016.
 */
public class Affinity {
    private String topic;
    private float percent;

    public Affinity(String topic, float percent) {
        this.topic = topic;
        this.percent = percent;
    }

    public String getTopic() {
        return topic;
    }

    public float getPercent() {
        return percent;
    }
}
