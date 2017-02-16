package com.extent.project.english.util;

import com.extent.project.english.POJO.*;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by VietAnh on 2/5/2017.
 */
public class Main {
    private static final String URL = "/Users/nguyenmanhtuan/Documents/AnhTVc/other/";
    private static final String NAMEBOOK = "4-More Practice Tests";
    private static final String NAMETOIECTESTONE = "Practice Test One";
    private static final String ERROR = "ERROR READ QUESTION";
    private static final String PATH_RESULT_ONE = URL + "/result/result_toiec_test_1.json";
    private static final String PATH_RESULT_TWO = URL + "/result/result_toiec_test_2.json";
    private static final String PATH_RESULT_THREE = URL + "/result/result_toiec_test_3.json";
    private static final String PATH_RESULT_FOUR = URL + "/result/result_toiec_test_4.json";

    /**
     * Lay thong tin bai toiec :)
     * @param document: document
     * @param indexBeginQuestion: vị trí bắt đầu của phần câu hỏi
     * @param indexEndQuestion: vị trí kết thúc của phần câu hỏi
     * @param indexBeginAnswer: vị trí bắt đầu của phần câu trả lời
     * @param indexEndAnswer: vị trí kết thúc của phần câu trả lời
     * @return
     */
    private static ToiecTest getToiecTest(PDDocument document,
                                          int indexBeginQuestion,
                                          int indexEndQuestion,
                                          int indexBeginAnswer,
                                          int indexEndAnswer,
                                          int indexBeginAudio,
                                          int indexEndAudio){
        try {
            //Load document to text question and text answer
            PDFTextStripper reader = new PDFTextStripper();
            PDFTextStripper readerAnswer = new PDFTextStripper();
            reader.setStartPage(indexBeginQuestion);
            reader.setEndPage(indexEndQuestion);
            readerAnswer.setStartPage(indexBeginAnswer);
            readerAnswer.setEndPage(indexEndAnswer);
            PDFTextStripper readerAudioScript = new PDFTextStripper();
            readerAudioScript.setStartPage(indexBeginAudio);
            readerAudioScript.setEndPage(indexEndAudio);

            String toeicTestTextQuestion = reader.getText(document);
            String toeicTestTextAnswer = readerAnswer.getText(document);
            String toeicTestTextAudio = readerAudioScript.getText(document);
            // Init Object
            ArrayList<QuestionPast1> questionPast1s = new ArrayList<>();
            ArrayList<QuestionPast2> questionPast2s = new ArrayList<>();
            ArrayList<QuestionPast3> questionPast3s;
            ArrayList<QuestionPast4> questionPast4s;
            ArrayList<QuestionPast5> questionPast5s = new ArrayList<>();
            ArrayList<QuestionPast6> questionPast6s;
            ArrayList<QuestionPast7> questionPast7s = new ArrayList<>();
            QuestionPast1 questionPast1;
            QuestionPast2 questionPast2;
            QuestionPast3 questionPast3;
            QuestionPast4 questionPast4;
            QuestionPast5 questionPast5;
            QuestionPast6 questionPast6;
            QuestionPast7 questionPast7;

            /****************************************************************/
            /*                      GET PAST 1                              */
            /* Describe:    Fix url image and audio                         */
            /*              Load answer, explain to Object                  */
            /*              Load with index question                        */
            /****************************************************************/

            for(int i = 1; i <= 10; i++){
                questionPast1 = new QuestionPast1();
                questionPast1.setIndex(i);
                questionPast1.setUrlImage(NAMEBOOK + "_" + NAMETOIECTESTONE + "_" +  "...jpg");
                questionPast1.setUrlMP3(NAMEBOOK + "_" + NAMETOIECTESTONE + "_" +  "...jpg");
                int begin = i;
                int end = i + 1;
                try{
                    String strTemp = toeicTestTextAnswer.substring(toeicTestTextAnswer.indexOf(String.valueOf(begin) + ". "),
                            toeicTestTextAnswer.indexOf(String.valueOf(end) + ". "));
                    questionPast1.setExplain(strTemp);
                    questionPast1.setAnswer(strTemp.substring(strTemp.indexOf("(") + 1, strTemp.indexOf(")")));

                    // Get Answer

                }catch (Exception ex){
                    ex.printStackTrace();
                    questionPast1.setExplain(ERROR);
                    questionPast1.setAnswer(ERROR);
                }

                try {
                    questionPast1.setAudioScript(toeicTestTextAudio.substring(toeicTestTextAudio.indexOf(String.valueOf(begin) + ". "),
                            toeicTestTextAudio.indexOf(String.valueOf(end) + ". ")));
                }catch (Exception e){
                    questionPast1.setAudioScript(ERROR);
                }

                questionPast1s.add(questionPast1);
            }

            /****************************************************************/
            /*                      GET PAST 2                              */
            /* Describe: same load in question past 1                       */
            /****************************************************************/
            for(int i = 11; i <= 40; i ++){
                questionPast2 = new QuestionPast2();
                questionPast2.setIndex(i);
                int begin = i;
                int end = i + 1;
                try{
                    String strTemp = toeicTestTextAnswer.substring(toeicTestTextAnswer.indexOf(String.valueOf(begin) + ". "),
                            toeicTestTextAnswer.indexOf(String.valueOf(end) + ". "));
                    questionPast2.setExplain(strTemp);

                    questionPast2.setAnswer(strTemp.substring(strTemp.indexOf("(") + 1, strTemp.indexOf(")")));

                }catch (Exception ex){
                    questionPast2.setExplain(ERROR);
                    questionPast2.setAnswer(ERROR);
                }

                try {
                    questionPast2.setAudioScript(toeicTestTextAudio.substring(toeicTestTextAudio.indexOf(String.valueOf(begin) + ". "),
                            toeicTestTextAudio.indexOf(String.valueOf(end) + ". ")));
                }catch (Exception e){
                    questionPast2.setAudioScript(ERROR);
                }
                questionPast2s.add(questionPast2);
            }

            /****************************************************************/
            /*                      GET PAST 3                              */
            /* Describe: same load in question past 1                       */
            /****************************************************************/
            ToiecTest toiecTest = new ToiecTest();
            BlockQuestionPast3 blockQuestionPast3;
            ArrayList<BlockQuestionPast3> blockQuestionPast3s= new ArrayList<>();

            String str = "Questions";
            int indexAudioScript = toeicTestTextAudio.indexOf(str);

            ArrayList<Integer> arrayAudioScript = new ArrayList<>();
            //arrayAudioScript.add(indexAudioScript);
            while((indexAudioScript=(toeicTestTextAudio.indexOf(str,indexAudioScript)+1))>0)
                arrayAudioScript.add(indexAudioScript);

            indexAudioScript = 0;
            for(int i = 0; i< 10; i++){
                blockQuestionPast3 = new BlockQuestionPast3();
                questionPast3s = new ArrayList<>();
                for(int j =1; j<= 3; j++){
                    questionPast3 = new QuestionPast3();
                    questionPast3.setIndex(40 + i * 3 + j );
                    int begin = 40 + i * 3 + j ;
                    int end = 40 + i * 3 + j  + 1;
                    try{
                        String strTemp = toeicTestTextQuestion.substring(toeicTestTextQuestion.indexOf(String.valueOf(begin) + ". "),
                                toeicTestTextQuestion.indexOf(String.valueOf(end) + ". "));
                        questionPast3.setQuestion(strTemp);

                    }catch (Exception ex){
                        questionPast3.setQuestion(ERROR);
                    }

                    try {
                        String strTemp = toeicTestTextAnswer.substring(toeicTestTextAnswer.indexOf(String.valueOf(begin) + ". "),
                                toeicTestTextAnswer.indexOf(String.valueOf(end) + ". "));

                        questionPast3.setAnswer(strTemp.substring(strTemp.indexOf("(") + 1, strTemp.indexOf(")")));
                        questionPast3.setExplain(strTemp);
                    }catch (Exception e){
                        questionPast3.setAnswer(ERROR);
                        questionPast3.setExplain(ERROR);
                    }
                    questionPast3s.add(questionPast3);

                }
                String abc = toeicTestTextAudio.substring(arrayAudioScript.get(indexAudioScript), arrayAudioScript.get(indexAudioScript + 1));
                blockQuestionPast3.setAudioScript(abc);
                indexAudioScript ++;
                blockQuestionPast3.setQuestionPast3s(questionPast3s);

                blockQuestionPast3s.add(blockQuestionPast3);


            }
            toiecTest.setQuestionPast3s(blockQuestionPast3s);

            /****************************************************************/
            /*                      GET PAST 4                              */
            /* Describe: same load in question past 1                       */
            /****************************************************************/
            BlockQuestionPast4 blockQuestionPast4;
            ArrayList<BlockQuestionPast4> arrayListBlockQuestionPast4s = new ArrayList<>();

            for(int i = indexAudioScript -1; i< arrayAudioScript.size(); i++){
                //
                String temp = toeicTestTextAudio.substring(arrayAudioScript.get(i) + 9, arrayAudioScript.get(i) + 22);
                questionPast4s = new ArrayList<>();
                ArrayList<Integer> arrayList = PDFUtil.getArrayInt(temp, "\\s+through\\s+");
                for(int j = arrayList.get(0); j <= arrayList.get(1); j ++){
                    questionPast4 = new QuestionPast4();

                    questionPast4.setIndex(j);
                    int begin = j;
                    int end = j + 1;
                    try{
                        String strTemp = toeicTestTextQuestion.substring(toeicTestTextQuestion.indexOf(String.valueOf(begin) + ". "),
                                toeicTestTextQuestion.indexOf(String.valueOf(end) + ". "));
                        questionPast4.setQuestion(strTemp);

                    }catch (Exception ex){
                        questionPast4.setQuestion(ERROR);
                    }

                    try {
                        String strTemp = toeicTestTextAnswer.substring(toeicTestTextAnswer.indexOf(String.valueOf(begin) + ". "),
                                toeicTestTextAnswer.indexOf(String.valueOf(end) + ". "));
                        questionPast4.setAnswer(strTemp.substring(strTemp.indexOf("(") + 1, strTemp.indexOf(")")));
                    }catch (Exception e){
                        questionPast4.setExplain(ERROR);
                        questionPast4.setAnswer(ERROR);
                    }
                    questionPast4s.add(questionPast4);
                }

                blockQuestionPast4 = new BlockQuestionPast4();
                blockQuestionPast4.setQuestionPast4s(questionPast4s);
                // Set audio
                try{
                    blockQuestionPast4.setAudioScript(toeicTestTextAudio.substring(arrayAudioScript.get(indexAudioScript - 1), arrayAudioScript.get(indexAudioScript)));
                }catch (Exception e){
                    blockQuestionPast4.setAudioScript("ERROR IN READ AUDIO");
                }
                indexAudioScript ++;

                arrayListBlockQuestionPast4s.add(blockQuestionPast4);
            }
            toiecTest.setQuestionPast4s(arrayListBlockQuestionPast4s);

            /****************************************************************/
            /*                      GET PAST 5                              */
            /* Describe: same load in question past 1                       */
            /****************************************************************/
            for(int i = 101; i <= 140; i++){
                questionPast5 = new QuestionPast5();
                questionPast5.setIndex(i);
                int begin = i;
                int end = i + 1;
                try{
                    String strTemp = toeicTestTextQuestion.substring(toeicTestTextQuestion.indexOf(String.valueOf(begin) + ". "),
                            toeicTestTextQuestion.indexOf(String.valueOf(end) + ". "));
                    questionPast5.setQuestion(strTemp);

                }catch (Exception ex){
                    questionPast5.setQuestion(ERROR);
                }

                try {
                    String strTemp = toeicTestTextAnswer.substring(toeicTestTextAnswer.indexOf(String.valueOf(begin) + ". "),
                            toeicTestTextAnswer.indexOf(String.valueOf(end) + ". "));
                    questionPast5.setExplain(strTemp);

                    questionPast5.setAnswer(strTemp.substring(strTemp.indexOf("(") + 1, strTemp.indexOf(")")));
                }catch (Exception e){
                    questionPast5.setAnswer(ERROR);
                    questionPast5.setExplain(ERROR);
                }

                questionPast5s.add(questionPast5);
            }

            /****************************************************************/
            /*                      GET PAST 6                              */
            /* Find page begin past 6: past 6 have 4 page                   */
            /****************************************************************/
            String past6 = "PART 6";
            String contentTempPast6 = "Directions: ";
            int indexPast6 = 0;
            for(int i = indexBeginQuestion; i< indexEndQuestion; i++){
                PDFTextStripper readerOnePage = new PDFTextStripper();
                readerOnePage.setStartPage(i);
                readerOnePage.setEndPage(i);
                String pageText = readerOnePage.getText(document);

                if(StringUtils.contains(pageText, past6)){
                    if(StringUtils.contains(PDFUtil.stringRemoveSubString(pageText, "\\s+"), PDFUtil.stringRemoveSubString(contentTempPast6, "\\s+"))){
                        // Get to next page + 4
                        indexPast6 = i + 1;
                        break;
                    }
                }
            }

            BlockQuetionPast6 blockQuetionPast6;
            ArrayList<BlockQuetionPast6> blockQuetionPast6ArrayList = new ArrayList<>();
            for(int i = indexPast6; i< indexPast6 + 4; i++){
                // su ly tung page
                PDFTextStripper readerOnePage = new PDFTextStripper();
                readerOnePage.setStartPage(i);
                readerOnePage.setEndPage(i);
                String pageText = readerOnePage.getText(document);
                questionPast6s = new ArrayList<>();
                blockQuetionPast6 = new BlockQuetionPast6();
                // Tach cau hoi ra khoi bai doc
                for(int j = 1; j <=3; j++){
                    questionPast6 = new QuestionPast6();
                    int begin = 140 + (i - indexPast6) * 3 + j;
                    int end = begin + 1;

                    questionPast6.setIndex(begin);
                    try{
                        String temp = pageText.substring(pageText.indexOf(begin), pageText.indexOf(end));
                        questionPast6.setQuestion(temp);

                        PDFUtil.stringRemoveSubString(pageText, temp);
                    }catch (Exception e){
                        questionPast6.setQuestion(ERROR);
                    }

                    try {
                        String strTemp = toeicTestTextAnswer.substring(toeicTestTextAnswer.indexOf(String.valueOf(begin) + ". "),
                                toeicTestTextAnswer.indexOf(String.valueOf(end) + ". "));
                        questionPast6.setExplain(strTemp);

                        questionPast6.setAnswer(strTemp.substring(strTemp.indexOf("(") + 1, strTemp.indexOf(")")));
                    }catch (Exception e){
                        questionPast6.setAnswer(ERROR);
                        questionPast6.setExplain("ERROR READ");
                    }
                    questionPast6s.add(questionPast6);
                }

                blockQuetionPast6.setQuestionPast6s(questionPast6s);
                blockQuetionPast6.setReadContent(pageText);

                blockQuetionPast6ArrayList.add(blockQuetionPast6);
            }
            toiecTest.setQuestionPast6s(blockQuetionPast6ArrayList);

            /****************************************************************/
            /*                      GET PAST 7                              */
            /* Describe:    Load text question past 7 to String             */
            /*              analyze to block: one block muti question       */
            /*              Past7 muti block                                */
            /****************************************************************/
            // Load text past 7
            String past7 = "PART 7";

            int indexPast7 = 0;
            for(int i = indexBeginQuestion; i< indexEndQuestion; i++){
                PDFTextStripper readerOnePage = new PDFTextStripper();
                readerOnePage.setStartPage(i);
                readerOnePage.setEndPage(i);
                String pageText = readerOnePage.getText(document);

                if(StringUtils.contains(pageText, past7)){
                    if(StringUtils.contains(PDFUtil.stringRemoveSubString(pageText, "\\s+"), PDFUtil.stringRemoveSubString(contentTempPast6, "\\s+"))){
                        // Get to next page + 4
                        indexPast7 = i + 1;
                        break;
                    }
                }
            }
            /*
            Text get question past 7
             */
            PDFTextStripper readerPast7Question = new PDFTextStripper();
            readerPast7Question.setStartPage(indexPast7 + 1);
            readerPast7Question.setEndPage(indexEndQuestion);
            String textQuestionPast7 = readerPast7Question.getText(document);
            String strTempOne = "Questions ";
            //---------------------------------------------------------
            int indexTemp = textQuestionPast7.indexOf(strTempOne);
            ArrayList<Integer> intArrayBlockPast7 = new ArrayList<>();
           // intArrayBlockPast7.add(indexTemp);
            while (indexTemp >= 0) {  // indexOf returns -1 if no match found
                intArrayBlockPast7.add(indexTemp);
                indexTemp = textQuestionPast7.indexOf(strTempOne, indexTemp + 1);

            }

            BlockQuestionPast7 blockQuestionPast7;
            ArrayList<BlockQuestionPast7> blockQuestionPast7ArrayList = new ArrayList<>();
            QuestionPast6 questionPast7a;
            ArrayList<QuestionPast6> questionPast7aArrayList;
            for(int i =0; i< intArrayBlockPast7.size() -1; i++){
                String tempBlockPast7 = textQuestionPast7.substring(intArrayBlockPast7.get(i), intArrayBlockPast7.get(i + 1));

                blockQuestionPast7 = new BlockQuestionPast7();
                questionPast7aArrayList = new ArrayList<>();
                ArrayList<Integer> arrayListInt = PDFUtil.getArrayInt(tempBlockPast7.substring(10, 17), "-");

                for(int j = arrayListInt.get(0); j <= arrayListInt.get(1); j++){
                    questionPast7a = new QuestionPast6();
                    questionPast7a.setIndex(j);
                    //set question
                    try {
                        String temp = tempBlockPast7.substring(tempBlockPast7.indexOf(j), tempBlockPast7.indexOf(j + 1));
                        questionPast7a.setQuestion(temp);

                        PDFUtil.stringRemoveSubString(tempBlockPast7, temp);
                    }catch (Exception e){
                        questionPast7a.setQuestion(ERROR);
                    }

                    //set answer
                    try {
                        String strTemp = toeicTestTextAnswer.substring(toeicTestTextAnswer.indexOf(String.valueOf(j) + ". "),
                                toeicTestTextAnswer.indexOf(String.valueOf(j + 1) + ". "));
                        questionPast7a.setExplain(strTemp);

                        questionPast7a.setAnswer(strTemp.substring(strTemp.indexOf("(") + 1, strTemp.indexOf(")")));
                    }catch (Exception e){
                        questionPast7a.setAnswer(ERROR);
                        questionPast7a.setExplain("ERROR READ");
                    }

                    questionPast7aArrayList.add(questionPast7a);
                }

                blockQuestionPast7.setQuestionPast7s(questionPast7aArrayList);
                blockQuestionPast7.setReadContent(tempBlockPast7);

                blockQuestionPast7ArrayList.add(blockQuestionPast7);
            }

           /* // Lấy câu trả lời cho từng câu hỏi của past7
            for(int i =0; i< questionPast7s.size(); i++){
                //Xử lý từng block
                QuestionPast7 questionPastTemp = questionPast7s.get(i);
                ArrayList<Question> questions = questionPastTemp.getQuestions();
                Question question;
                for(int j = 0; j< questions.size(); j++){
                    question = questions.get(j);
                    try{
                        String temp = toeicTestTextAnswer.substring(toeicTestTextAnswer.indexOf(String.valueOf(j) + ". "),
                                toeicTestTextAnswer.indexOf(String.valueOf(j + 1) + ". "));
                        question.setExplain(temp);
                        question.setAnswer(temp.substring(temp.indexOf("(") + 1, temp.indexOf(")")));
                    }catch (Exception ex){
                        ex.printStackTrace();
                        question.setExplain(ERROR);
                    }

                    // Update question
                    questions.set(j, question);
                }

                // Update Block
                questionPastTemp.setQuestions(questions);
                questionPast7s.set(i, questionPastTemp);
            }
*/

            toiecTest.setQuestionPast1s(questionPast1s);
            toiecTest.setQuestionPast2s(questionPast2s);

            //toiecTest.setQuestionPast4s(questionPast4s);
            toiecTest.setQuestionPast5s(questionPast5s);

           toiecTest.setQuestionPast7s(blockQuestionPast7ArrayList);

            return toiecTest;
        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

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

            // TODO get data past6
            String past6 = "PART 6";
            String contentTempPast6 = "Directions: ";
            int indexPast6 = 0;
            for(int i = indexBegin; i< indexEnd; i++){
                PDFTextStripper readerOnePage = new PDFTextStripper();
                readerOnePage.setStartPage(i);
                readerOnePage.setEndPage(i);
                String pageText = readerOnePage.getText(document);

                if(StringUtils.contains(pageText, past6)){
                    if(StringUtils.contains(pageText, contentTempPast6)){
                        // Get to next page + 4
                        indexPast6 = i + 1;
                        break;
                    }
                }
            }
            for(int i = indexPast6; i< indexPast6 + 4; i++){
                PDFTextStripper readerOnePage = new PDFTextStripper();
                readerOnePage.setStartPage(i);
                readerOnePage.setEndPage(i);
                String pageText = readerOnePage.getText(document);

                questionPast6 = new QuestionPast6();
                questionPast6.setIndex(i);
                //questionPast6.setReadContent(pageText);
            }




            for(int i = 141; i <= 152; i++){
                // Past 6
            }


         //   toiecTest.setQuestionPast3s(questionPast3s);
        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

    /**
     * Get data answer
     * @param document
     * @param indexBegin
     * @param indexEnd
     * @return
     */
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
            //toiecTest.setQuestionPast3s(questionPast3s);
            //toiecTest.setQuestionPast4s(questionPast4s);
            toiecTest.setQuestionPast5s(questionPast5s);

            return toiecTest;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] arg){
        // Load data
        boolean checkIsQuestion = false;
        try {
            ToiecTest toiecTestOne = new ToiecTest();
            ToiecTest toiecTestTwo = new ToiecTest();
            ToiecTest toiecTestThree = new ToiecTest();
            ToiecTest toiecTestFour = new ToiecTest();


            toiecTestOne.setNameBook(NAMEBOOK);
            toiecTestOne.setNameToiecTest(NAMETOIECTESTONE);
            ArrayList<QuestionPast1> questionPast1s = new ArrayList<>();

            QuestionPast1 questionPast1;
            String PAST1 = "PAST1";

            PDDocument document = PDDocument.load(new File(URL + "Book– More Practice Tests Course - 4th edition.pdf"));
            document.getClass();
            PDFTextStripper reader;
            int pageIndexPageAnswerKeyOne = 0, pageIndexPageAnswerKeyTwo = 0, pageIndexPageAnswerKeyThree = 0, pageIndexPageAnswerKeyFour = 0;
            int pageIndexPageQuestionOne = 0, pageIndexPageQuestionTwo = 0, pageIndexPageQuestionThree = 0, pageIndexPageQuestionFour = 0;
            int pageIndexAudioScriptOne = 0, pageIndexAudioScriptTwo = 0, pageIndexAudioScriptThree = 0, pageIndexAudioScriptFour = 0;
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
                String strAudioScript = "A u d i o s c r i p t";

                String stringQuestion = "PRACTICE TESTS";


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

                if(checkIsQuestion){
                    if(StringUtils.contains(PDFUtil.stringRemoveSubString(pageText, "\\s+"), PDFUtil.stringRemoveSubString(strTestOne, "\\s+"))){
                        // Page chua cau hoi past 1
                        pageIndexPageQuestionOne = i;
                    }else if(StringUtils.contains(PDFUtil.stringRemoveSubString(pageText, "\\s+"), PDFUtil.stringRemoveSubString(strTestTwo, "\\s+"))){
                        pageIndexPageQuestionTwo = i;
                    }else if(StringUtils.contains(PDFUtil.stringRemoveSubString(pageText, "\\s+"), PDFUtil.stringRemoveSubString(strTestThree, "\\s+"))){
                        pageIndexPageQuestionThree = i;
                    }else if(StringUtils.contains(PDFUtil.stringRemoveSubString(pageText, "\\s+"), PDFUtil.stringRemoveSubString(strTestFour, "\\s+"))){
                        pageIndexPageQuestionFour = i;
                        checkIsQuestion = false;
                    }
                }
                if(StringUtils.contains(PDFUtil.stringRemoveSubString(pageText, "\\s+"), PDFUtil.stringRemoveSubString(stringQuestion, "\\s+"))){
                    checkIsQuestion = true;
                }

                if(StringUtils.contains(pageText, strAudioScript)){
                    if(StringUtils.contains(PDFUtil.stringRemoveSubString(pageText, "\\s+"), PDFUtil.stringRemoveSubString(strTestOne, "\\s+"))){
                        // Page chua cau hoi past 1
                        pageIndexAudioScriptOne = i;
                    }else if(StringUtils.contains(PDFUtil.stringRemoveSubString(pageText, "\\s+"), PDFUtil.stringRemoveSubString(strTestTwo, "\\s+"))){
                        pageIndexAudioScriptTwo = i;
                    }else if(StringUtils.contains(PDFUtil.stringRemoveSubString(pageText, "\\s+"), PDFUtil.stringRemoveSubString(strTestThree, "\\s+"))){
                        pageIndexAudioScriptThree = i;
                    }else if(StringUtils.contains(PDFUtil.stringRemoveSubString(pageText, "\\s+"), PDFUtil.stringRemoveSubString(strTestFour, "\\s+"))){
                        pageIndexAudioScriptFour = i;
                    }

                }
            }
            toiecTestOne = getToiecTest(document, pageIndexPageQuestionOne, pageIndexPageQuestionTwo -1, pageIndexPageAnswerKeyOne,
                    pageIndexPageAnswerKeyTwo -1,pageIndexAudioScriptOne,
                    pageIndexAudioScriptTwo - 1);

            toiecTestTwo = getToiecTest(document, pageIndexPageQuestionTwo, pageIndexPageQuestionThree -1,
                    pageIndexPageAnswerKeyTwo, pageIndexPageAnswerKeyThree - 1, pageIndexAudioScriptTwo, pageIndexAudioScriptThree -1);
            toiecTestThree = getToiecTest(document, pageIndexPageQuestionThree, pageIndexPageQuestionFour -1,
                    pageIndexPageAnswerKeyThree, pageIndexPageAnswerKeyFour - 1, pageIndexAudioScriptThree, pageIndexAudioScriptFour -1);
            toiecTestFour = getToiecTest(document, pageIndexPageQuestionFour, 170,
                    pageIndexPageAnswerKeyFour, 251, pageIndexAudioScriptFour, 200);

            Gson gson = new Gson();
            
            PDFUtil.stringToFile(gson.toJson(toiecTestOne), PATH_RESULT_ONE);
            PDFUtil.stringToFile(gson.toJson(toiecTestTwo), PATH_RESULT_TWO);
            PDFUtil.stringToFile(gson.toJson(toiecTestThree), PATH_RESULT_THREE);
            PDFUtil.stringToFile(gson.toJson(toiecTestFour), PATH_RESULT_FOUR);
            // Save to file

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
