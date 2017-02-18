package com.extent.project.english.DAO;

/**
 * Created by AnhTVc on 2/17/17.
 */

public class CodefightsMain {
    static  int seatsInTheater(int nCols, int nRows, int col, int row) {
        int a = (nCols - col + 1);
        int b = (nRows - row);
        return  a * b ;
    }

    static int makeArrayConsecutive2(int[] statues) {


        int index = 0;
        int begin = statues[0];
        int end = statues[0];
        for(int i = 0; i < statues.length; i++){
            if(begin > statues[i] ){
                begin = statues[i];
            }

            if(end < statues[i] ){
                end = statues[i];
            }
        }

        boolean check = false;
        for(int i = begin; i<= end; i++){
            for(int j = 0; j< statues.length; j++){
                if(i == statues[j]){
                    check = true;
                    break;
                }else{
                    check = false;
                }
            }
            if(!check ){
                index ++;
            }
        }
        return index;


    }

    public static void main(String[] arg){
        int []a= new int[4];
        a[0]= 6;
        a[1] = 2;
        a[2] = 3;
        a[3] = 8;

        System.out.print(seatsInTheater(16, 11, 5, 3));

    }
}
