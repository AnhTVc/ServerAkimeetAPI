package com.extent.project.english.util;

import com.extent.project.english.POJO.Question;
import com.extent.project.english.POJO.QuestionPast7;
import org.apache.log4j.BasicConfigurator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import sun.misc.IOUtils;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by VietAnh on 1/24/2017.
 */
public class PDFUtil {

    public static String stringRemoveSubString(String str, String subString){
        return str.replaceAll(subString, "");
    }

    /**
     * ex:  153-154
     * @param str
     * @return
     */
    public static ArrayList<Integer> getArrayInt(String str, String subStr){
        try {
            String[] temps = str.split(subStr);
            ArrayList<Integer> result = new ArrayList<>();
            int tempResult = 0;
            for(int i =0; i < temps.length; i++){
                tempResult = Integer.valueOf(temps[i]);
                result.add(tempResult);
            }

            return result;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get questionPast 7 theo block
     * @param textBlock
     * @return
     */
    public static QuestionPast7 getQuestionPast7InBlock(String textBlock){
        try {
            QuestionPast7 questionPast7 = new QuestionPast7();
            ArrayList<Question> questions = new ArrayList<>();
            Question question;

            // Lấy danh sách các câu hỏi
            ArrayList<Integer> questionIndexs = PDFUtil.getArrayInt(
                    PDFUtil.stringRemoveSubString
                            (textBlock.substring(10, 17), "\\s+"), "-");
            for(int j = questionIndexs.get(0); j <= questionIndexs.get(1); j ++){
                String strTemp = null;

                try {
                    // Lấy nội dung từng câu hỏi
                    strTemp = textBlock.substring(textBlock.indexOf(String.valueOf(j) + ". "),
                            textBlock.indexOf(String.valueOf(j+1) + ". "));
                }catch (Exception e){
                    e.printStackTrace();
                    strTemp = "ERROR READ QUESTION PAST7";
                }
                question = new Question();
                question.setContent(strTemp);
                question.setIndex(j);

                // TODO Find answer past 7
                questions.add(question);
            }

            // Lấy bài đọc cho block
            questionPast7.setReadContent(textBlock.substring(textBlock.indexOf("\n"), questionIndexs.get(0)));
            questionPast7.setQuestions(questions);

            return questionPast7;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * Lưu String tới file
     * @param str
     * @param url
     * @return
     */
    public static boolean stringToFile(String str, String url){
        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter( new FileWriter( url));
            writer.write( str);

        }
        catch ( IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if ( writer != null)
                    writer.close( );
                return  true;
            }
            catch ( IOException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }


    /**
     * File to String
     * @param url: path name
     * @return
     */
    public static String fileToString(String url){
        try {
            String content = new String(Files.readAllBytes(Paths.get(url)));
            return content;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] agr){
        BasicConfigurator.configure();
        try {
            PDDocument document1 = PDDocument.load(new File("D:\\Data\\Kỳ 8\\Toiec\\4-More Practice Tests\\Book– More Practice Tests Course - 4th edition.pdf"));
            PDFRenderer pdfRenderer = new PDFRenderer(document1);
            System.out.print("===================>" + document1.getNumberOfPages());
            int pageCounter = 0;
            for (PDPage page : document1.getPages())
            {
                // note that the page number parameter is zero based
                BufferedImage bim = pdfRenderer.renderImageWithDPI(pageCounter, 300, ImageType.RGB);

                // suffix in filename will be used as the file format
                ImageIOUtil.writeImage(bim, "D:\\Data\\Kỳ 8\\Toiec\\4-More Practice Tests\\image\\" + "a" + (pageCounter++) + ".png", 300);
            }

            document1.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
