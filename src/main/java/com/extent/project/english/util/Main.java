package com.extent.project.english.util;

import com.extent.project.english.POJO.*;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by VietAnh on 2/5/2017.
 */
public class Main {
    private static final String NAMEBOOK = "4-More Practice Tests";
    private static final String NAMETOIECTESTONE = "Practice Test One";
    private static final String ERROR = "ERROR READ QUESTION";
    private static final String NAMETOIECTESTWO = "Practice Test Two";

    private static final int TOEICTTESTONE = 1;
    private static final int TOEICTTESTTWO = 2;
    private static final int TOEICTTESTTHREE = 3;
    private static final int TOEICTTESTFOUR = 4;

    private static ToiecTest getQuestionToiecTest(PDDocument document, int indexBegin, int indexEnd){
        try {
            PDFTextStripper reader = new PDFTextStripper();
            reader.setStartPage(indexBegin);
            reader.setEndPage(indexEnd);

            String toeicTestText = reader.getText(document);
            // Init Object
            ArrayList<QuestionPast1> questionPast1s = new ArrayList<>();
            ArrayList<QuestionPast2> questionPast2s = new ArrayList<>();
            ArrayList<QuestionPast3> questionPast3s = new ArrayList<>();
            ArrayList<QuestionPast4> questionPast4s = new ArrayList<>();
            ArrayList<QuestionPast5> questionPast5s = new ArrayList<>();
            ArrayList<QuestionPast6> questionPast6s = new ArrayList<>();
            ArrayList<QuestionPast7> questionPast7s = new ArrayList<>();
            QuestionPast1 questionPast1;
            QuestionPast2 questionPast2;
            QuestionPast3 questionPast3;
            QuestionPast4 questionPast4;
            QuestionPast5 questionPast5;
            QuestionPast6 questionPast6;
            QuestionPast7 questionPast7;

            ToiecTest toiecTest = new ToiecTest();
            for(int i = 41; i <= 70; i++){
                questionPast3 = new QuestionPast3();
                questionPast3.setIndex(i);
                int begin = i;
                int end = i + 1;
                try{
                    String strTemp = toeicTestText.substring(toeicTestText.indexOf(String.valueOf(begin) + ". "),
                            toeicTestText.indexOf(String.valueOf(end) + ". "));
                    questionPast3.setQuestion(strTemp);

                }catch (Exception ex){
                    ex.printStackTrace();
                    questionPast3.setExplain(ERROR);
                }
                questionPast3s.add(questionPast3);
            }
            for(int i = 71; i <= 100; i++){
                questionPast4 = new QuestionPast4();
                questionPast4.setIndex(i);
                int begin = i;
                int end = i + 1;
                try{
                    String strTemp = toeicTestText.substring(toeicTestText.indexOf(String.valueOf(begin) + ". "),
                            toeicTestText.indexOf(String.valueOf(end) + ". "));
                    questionPast4.setQuestion(strTemp);

                }catch (Exception ex){
                    ex.printStackTrace();
                    questionPast4.setExplain(ERROR);
                }
                questionPast4s.add(questionPast4);
            }
            //
            for(int i = 101; i <= 140; i++){
                questionPast5 = new QuestionPast5();
                questionPast5.setIndex(i);
                int begin = i;
                int end = i + 1;
                try{
                    String strTemp = toeicTestText.substring(toeicTestText.indexOf(String.valueOf(begin) + ". "),
                            toeicTestText.indexOf(String.valueOf(end) + ". "));
                    questionPast5.setQuestion(strTemp);

                }catch (Exception ex){
                    ex.printStackTrace();
                    questionPast5.setExplain(ERROR);
                }
                questionPast5s.add(questionPast5);
            }




            toiecTest.setQuestionPast3s(questionPast3s);
        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

    private static ToiecTest getAnswerToiecTest(PDDocument document, int indexBegin, int indexEnd){
        try {
            PDFTextStripper reader = new PDFTextStripper();
            reader.setStartPage(indexBegin);
            reader.setEndPage(indexEnd);

            String toeicTestText = reader.getText(document);

            // Init Object
            ArrayList<QuestionPast1> questionPast1s = new ArrayList<>();
            ArrayList<QuestionPast2> questionPast2s = new ArrayList<>();
            ArrayList<QuestionPast3> questionPast3s = new ArrayList<>();
            ArrayList<QuestionPast4> questionPast4s = new ArrayList<>();
            ArrayList<QuestionPast5> questionPast5s = new ArrayList<>();
            ArrayList<QuestionPast6> questionPast6s = new ArrayList<>();
            ArrayList<QuestionPast7> questionPast7s = new ArrayList<>();
            QuestionPast1 questionPast1;
            QuestionPast2 questionPast2;
            QuestionPast3 questionPast3;
            QuestionPast4 questionPast4;
            QuestionPast5 questionPast5;
            QuestionPast6 questionPast6;
            QuestionPast7 questionPast7;
            ToiecTest toiecTest = new ToiecTest();
            //Load data to toiec test

            for(int i = 1; i <= 10; i++){
                questionPast1 = new QuestionPast1();
                questionPast1.setIndex(i);
                questionPast1.setUrlImage(NAMEBOOK + "_" + NAMETOIECTESTONE + "_" +  "...jpg");
                questionPast1.setUrlMP3(NAMEBOOK + "_" + NAMETOIECTESTONE + "_" +  "...jpg");
                int begin = i;
                int end = i + 1;
                try{
                    String strTemp = toeicTestText.substring(toeicTestText.indexOf(String.valueOf(begin) + ". "),
                            toeicTestText.indexOf(String.valueOf(end) + ". "));
                    questionPast1.setExplain(strTemp);

                    questionPast1.setAnswer(strTemp.substring(strTemp.indexOf("(") + 1, strTemp.indexOf(")")));
                    // Get Answer

                }catch (Exception ex){
                    ex.printStackTrace();
                    questionPast1.setExplain(ERROR);
                }
                questionPast1s.add(questionPast1);
            }


            for(int i = 11; i <= 40; i ++){
                questionPast2 = new QuestionPast2();
                questionPast2.setIndex(i);
                int begin = i;
                int end = i + 1;
                try{
                    String strTemp = toeicTestText.substring(toeicTestText.indexOf(String.valueOf(begin) + ". "),
                            toeicTestText.indexOf(String.valueOf(end) + ". "));
                    questionPast2.setExplain(strTemp);

                    questionPast2.setAnswer(strTemp.substring(strTemp.indexOf("(") + 1, strTemp.indexOf(")")));
                }catch (Exception ex){
                    ex.printStackTrace();
                    questionPast2.setExplain(ERROR);
                }
                questionPast2s.add(questionPast2);
            }

            for(int i = 41; i<= 70; i++){
                questionPast3 = new QuestionPast3();
                questionPast3.setIndex(i);
                int begin = i;
                int end = i + 1;
                try{
                    String strTemp = toeicTestText.substring(toeicTestText.indexOf(String.valueOf(begin) + ". "),
                            toeicTestText.indexOf(String.valueOf(end) + ". "));
                    questionPast3.setExplain(strTemp);

                    questionPast3.setAnswer(strTemp.substring(strTemp.indexOf("(") + 1, strTemp.indexOf(")")));
                }catch (Exception ex){
                    ex.printStackTrace();
                    questionPast3.setExplain(ERROR);
                }
                questionPast3s.add(questionPast3);
            }

            for(int i = 71; i<= 100; i++){
                questionPast4 = new QuestionPast4();
                questionPast4.setIndex(i);
                int begin = i;
                int end = i + 1;
                try{
                    String strTemp = toeicTestText.substring(toeicTestText.indexOf(String.valueOf(begin) + ". "),
                            toeicTestText.indexOf(String.valueOf(end) + ". "));
                    questionPast4.setExplain(strTemp);

                    questionPast4.setAnswer(strTemp.substring(strTemp.indexOf("(") + 1, strTemp.indexOf(")")));
                }catch (Exception ex){
                    ex.printStackTrace();
                    questionPast4.setExplain(ERROR);
                }

                questionPast4s.add(questionPast4);
            }

            for(int i = 101; i<= 140; i++){
                questionPast5 = new QuestionPast5();
                questionPast5.setIndex(i);
                int begin = i;
                int end = i + 1;
                try{
                    String strTemp = toeicTestText.substring(toeicTestText.indexOf(String.valueOf(begin) + ". "),
                            toeicTestText.indexOf(String.valueOf(end) + ". "));
                    questionPast5.setExplain(strTemp);

                    questionPast5.setAnswer(strTemp.substring(strTemp.indexOf("(") + 1, strTemp.indexOf(")")));
                }catch (Exception ex){
                    ex.printStackTrace();
                    questionPast5.setExplain(ERROR);
                }
                questionPast5s.add(questionPast5);
            }


            // Add
            toiecTest.setQuestionPast1s(questionPast1s);
            toiecTest.setQuestionPast2s(questionPast2s);
            toiecTest.setQuestionPast3s(questionPast3s);
            toiecTest.setQuestionPast4s(questionPast4s);
            toiecTest.setQuestionPast5s(questionPast5s);
            toiecTest.setQuestionPast6s(questionPast6s);
            toiecTest.setQuestionPast7s(questionPast7s);

            return toiecTest;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] arg){
        // Load data
        try {
            ToiecTest toiecTestOne = new ToiecTest();
            toiecTestOne.setNameBook(NAMEBOOK);
            toiecTestOne.setNameToiecTest(NAMETOIECTESTONE);
            ArrayList<QuestionPast1> questionPast1s = new ArrayList<>();

            QuestionPast1 questionPast1;
            String PAST1 = "PAST1";

            PDDocument document = PDDocument.load(new File("D:\\Data\\Kỳ 8\\Toiec\\4-More Practice Tests\\Book– More Practice Tests Course - 4th edition.pdf"));
            document.getClass();
            PDFTextStripper reader;
            int pageIndexPageAnswerKeyOne = 0, pageIndexPageAnswerKeyTwo = 0, pageIndexPageAnswerKeyThree = 0, pageIndexPageAnswerKeyFour = 0;
            for(int i =0; i< document.getNumberOfPages(); i++){
                reader = new PDFTextStripper();
                reader.setStartPage(i);
                reader.setEndPage(i);

                String pageText = reader.getText(document);
                String stringAnswerKey = "A n s w e r  K e y";
                String strTestOne = "P r a c t i c e  T e s t  O ne";
                String strTestTwo = "P r a c t i c e  T e s t  T w o";
                String strTestThree = "P r a c t i c e  T e s t  T h r e e";
                String strTestFour = "P r a c t i c e  T e s t  F o u r";

                if(StringUtils.contains(pageText, stringAnswerKey))
                {
                    if(StringUtils.contains(pageText, strTestOne)){
                        // Page chứa câu trả lời
                        pageIndexPageAnswerKeyOne = i;
                    }else if(StringUtils.contains(pageText, strTestTwo)){
                        pageIndexPageAnswerKeyTwo = i;
                    }else if(StringUtils.contains(pageText, strTestThree)){
                        pageIndexPageAnswerKeyThree = i;
                    }else if(StringUtils.contains(pageText, strTestFour)){
                        pageIndexPageAnswerKeyFour = i;
                    }
                }
            }

           /* System.out.print(String.valueOf(pageIndexPageAnswerKeyOne) + "\n");
            System.out.print(String.valueOf(pageIndexPageAnswerKeyTwo) + "\n");
            System.out.print(String.valueOf(pageIndexPageAnswerKeyThree) + "\n");
            System.out.print(String.valueOf(pageIndexPageAnswerKeyFour) + "\n");*/
            toiecTestOne = getAnswerToiecTest(document, pageIndexPageAnswerKeyOne, pageIndexPageAnswerKeyTwo -1);

            Gson gson = new Gson();
            System.out.print(gson.toJson(toiecTestOne));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
