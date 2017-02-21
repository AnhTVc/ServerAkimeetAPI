package com.extent.project.english.util;

import java.util.ArrayList;

/**
 * Created by VietAnh on 2/13/2017.
 */
public class Test {

    int strstr(String s, String x) {
        int substrlen = x.length();
        int strlen = s.length();
        int j = 0;

        if (substrlen >= 1) {
            for (int i = 0; i < strlen; i++) {
                if (s.charAt(i) == x.charAt(j)) {
                    j++;
                    if (j == substrlen) {
                        return i - substrlen;
                    }
                }
                else {
                    j = 0;
                }
            }
        }
        return -1;
    }

    static boolean sumOfTwo(int[] a, int[] b, int v) {
        if(a == null){
            if(b == null){
                if(v == 0){
                    return  true;
                }else{
                    return false;
                }
            }else{
                // b != null
                boolean check = false;
                for(int i = 0; i < b.length; i++){

                    if(b[i] == v){
                        check = true;
                    }
                }
                return check;
            }
        }else if(b == null){
            // a != null
            boolean check = false;
            for(int i = 0; i < a.length; i++){

                if(a[i] == v){
                    check = true;
                }
            }
            return check;
        }else {
            // a, b != null
            int rowa = a.length;
            int rowb = b.length;
            boolean check = false;
            for(int i = 0; i< rowa; i++){
                for(int j =0; j< rowb; j++){
                    if((a[i]  + b[j]) == v){
                        check = true;
                    }
                }
            }
            return check;
        }
    }
    static int visiblePoints(int[][] points) {
        int row = points.length;
        int count = 0;
        for(int i =0; i< row -1; i ++){
            for(int j = i+ 1; j< row; j++){
                double ao = Math.abs(Math.sqrt(points[i][0]) + Math.sqrt(points[i][1]));
                double bo = Math.abs(Math.sqrt(points[j][0]) + Math.sqrt(points[j][1]));
                double ab = Math.abs(Math.sqrt(points[i][0] - points[j][0]) + Math.sqrt(points[j][0] - points[j][1]));
                double tempcos = (Math.sqrt(ao) + Math.sqrt(bo) - Math.sqrt(ab)) / (2 * ao * ab);
                boolean check = true;


                if(tempcos == 1/Math.abs(2) && check){
                    count ++;
                }
            }
        }
        return count;
    }

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
        int [] a = null;
        if(a == null){
            System.out.print("acacads");
        }
    }

}
