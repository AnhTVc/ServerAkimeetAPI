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
    private static final String NAMEBOOK = "4-More Practice Tests";
    private static final String NAMETOIECTESTONE = "Practice Test One";
    private static final String ERROR = "ERROR READ QUESTION";
    private static final String PATH_RESULT = "D:\\Data\\Du An\\Toiec\\result.txt";

    /**
     * Lay thong tin bai toiec :)
     * @param document
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
                                          int indexEndAnswer){
        try {
            //Load document to text question and text answer
            PDFTextStripper reader = new PDFTextStripper();
            PDFTextStripper readerAnswer = new PDFTextStripper();
            reader.setStartPage(indexBeginQuestion);
            reader.setEndPage(indexEndQuestion);
            readerAnswer.setStartPage(indexBeginAnswer);
            readerAnswer.setEndPage(indexEndAnswer);

            String toeicTestTextQuestion = reader.getText(document);
            String toeicTestTextAnswer = readerAnswer.getText(document);

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
                    ex.printStackTrace();
                    questionPast2.setExplain(ERROR);
                }
                questionPast2s.add(questionPast2);
            }

            /****************************************************************/
            /*                      GET PAST 3                              */
            /* Describe: same load in question past 1                       */
            /****************************************************************/
            ToiecTest toiecTest = new ToiecTest();
            for(int i = 41; i <= 70; i++){
                questionPast3 = new QuestionPast3();
                questionPast3.setIndex(i);
                int begin = i;
                int end = i + 1;
                try{
                    String strTemp = toeicTestTextQuestion.substring(toeicTestTextQuestion.indexOf(String.valueOf(begin) + ". "),
                            toeicTestTextQuestion.indexOf(String.valueOf(end) + ". "));
                    questionPast3.setQuestion(strTemp);

                    strTemp = toeicTestTextAnswer.substring(toeicTestTextAnswer.indexOf(String.valueOf(begin) + ". "),
                            toeicTestTextAnswer.indexOf(String.valueOf(end) + ". "));

                    questionPast3.setAnswer(strTemp.substring(strTemp.indexOf("(") + 1, strTemp.indexOf(")")));
                    questionPast3.setExplain(strTemp);
                }catch (Exception ex){
                    ex.printStackTrace();
                    questionPast3.setExplain(ERROR);
                }

                questionPast3s.add(questionPast3);
            }

            /****************************************************************/
            /*                      GET PAST 4                              */
            /* Describe: same load in question past 1                       */
            /****************************************************************/
            for(int i = 71; i <= 100; i++){
                questionPast4 = new QuestionPast4();
                questionPast4.setIndex(i);
                int begin = i;
                int end = i + 1;
                try{
                    String strTemp = toeicTestTextQuestion.substring(toeicTestTextQuestion.indexOf(String.valueOf(begin) + ". "),
                            toeicTestTextQuestion.indexOf(String.valueOf(end) + ". "));
                    questionPast4.setQuestion(strTemp);
                    strTemp = toeicTestTextAnswer.substring(toeicTestTextAnswer.indexOf(String.valueOf(begin) + ". "),
                            toeicTestTextAnswer.indexOf(String.valueOf(end) + ". "));
                    questionPast4.setExplain(strTemp);

                    questionPast4.setAnswer(strTemp.substring(strTemp.indexOf("(") + 1, strTemp.indexOf(")")));
                }catch (Exception ex){
                    ex.printStackTrace();
                    questionPast4.setExplain(ERROR);
                }
                questionPast4s.add(questionPast4);
            }

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

                    strTemp = toeicTestTextAnswer.substring(toeicTestTextAnswer.indexOf(String.valueOf(begin) + ". "),
                            toeicTestTextAnswer.indexOf(String.valueOf(end) + ". "));
                    questionPast5.setExplain(strTemp);

                    questionPast5.setAnswer(strTemp.substring(strTemp.indexOf("(") + 1, strTemp.indexOf(")")));
                }catch (Exception ex){
                    ex.printStackTrace();
                    questionPast5.setExplain(ERROR);
                }
                questionPast5s.add(questionPast5);
            }

            /****************************************************************/
            /*                      GET PAST 6                              */
            /****************************************************************/
            // TODO get data past6
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
            for(int i = indexPast6; i< indexPast6 + 4; i++){
                PDFTextStripper readerOnePage = new PDFTextStripper();
                readerOnePage.setStartPage(i);
                readerOnePage.setEndPage(i);
                String pageText = readerOnePage.getText(document);

                questionPast6 = new QuestionPast6();
                questionPast6.setIndex(i);
                questionPast6.setReadContent(pageText);
                questionPast6s.add(questionPast6);

            }
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
            //String strTempTwo = " re fer  to th e  fo llo w in g  jo b  an n o u n cem en t";
            int indexTemp = textQuestionPast7.indexOf(strTempOne);
            ArrayList<Integer> intArrayBlockPast7 = new ArrayList<>();
           // intArrayBlockPast7.add(indexTemp);
            while (indexTemp >= 0) {  // indexOf returns -1 if no match found
                intArrayBlockPast7.add(indexTemp);
                indexTemp = textQuestionPast7.indexOf(strTempOne, indexTemp + 1);

            }
            for(int i =0; i< intArrayBlockPast7.size() -1; i++){
                String tempBlockPast7 = textQuestionPast7.substring(intArrayBlockPast7.get(i), intArrayBlockPast7.get(i + 1));
                try{
                    questionPast7 = PDFUtil.getQuestionPast7InBlock(tempBlockPast7);
                    if(questionPast7 != null)
                        questionPast7s.add(questionPast7);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            // Lấy câu trả lời cho từng câu hỏi của past7
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
                questionPast6.setReadContent(pageText);
            }




            for(int i = 141; i <= 152; i++){
                // Past 6
            }


            toiecTest.setQuestionPast3s(questionPast3s);
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
            toiecTest.setQuestionPast3s(questionPast3s);
            toiecTest.setQuestionPast4s(questionPast4s);
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
            toiecTestOne.setNameBook(NAMEBOOK);
            toiecTestOne.setNameToiecTest(NAMETOIECTESTONE);
            ArrayList<QuestionPast1> questionPast1s = new ArrayList<>();

            QuestionPast1 questionPast1;
            String PAST1 = "PAST1";

            PDDocument document = PDDocument.load(new File("D:\\Data\\Kỳ 8\\Toiec\\4-More Practice Tests\\Book– More Practice Tests Course - 4th edition.pdf"));
            document.getClass();
            PDFTextStripper reader;
            int pageIndexPageAnswerKeyOne = 0, pageIndexPageAnswerKeyTwo = 0, pageIndexPageAnswerKeyThree = 0, pageIndexPageAnswerKeyFour = 0;
            int pageIndexPageQuestionOne = 0, pageIndexPageQuestionTwo = 0, pageIndexPageQuestionThree = 0, pageIndexPageQuestionFour = 0;
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
            }
            toiecTestOne = getToiecTest(document, pageIndexPageQuestionOne, pageIndexPageQuestionTwo -1, pageIndexPageAnswerKeyOne, pageIndexPageAnswerKeyTwo -1);

            Gson gson = new Gson();
            System.out.print(gson.toJson(toiecTestOne));
            PDFUtil.stringToFile(gson.toJson(toiecTestOne), PATH_RESULT);
            // Save to file

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
