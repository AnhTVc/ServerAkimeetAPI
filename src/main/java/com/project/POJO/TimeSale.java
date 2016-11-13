package com.project.POJO;

import java.util.ArrayList;

/**
 * Created by knight_cs on 11/08/2016.
 */
public class TimeSale {
    private String idTimeSale;
    ArrayList<String> hour;
    private String fromDate;
    private String toDate;


public TimeSale(ArrayList<String> hour,String fromDate,String toDate){
    this.hour = hour;
    this.fromDate = fromDate;
    this.toDate = toDate;
}

}
