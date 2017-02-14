package com.extent.project.english.util;

import java.util.ArrayList;

/**
 * Created by VietAnh on 2/13/2017.
 */
public class Test {
    static int[] ratingThreshold(double threshold, int[][] ratings) {
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;

        for(int i =0; i< ratings.length; i++){
            int[] temp = ratings[i];
            int sum = 0;
            for(int j =0; j< temp.length; j++){
                sum += temp[j];
            }

            if((sum / temp.length) == threshold){
                result.add(i + 1);
            }
        }

        int[] a = new int[result.size()];
        for(int i =0; i< result.size(); i++){
            a[i] = result.get(i);
        }
        return a;
    }
    public static void main(String[] agr){

    }

}
