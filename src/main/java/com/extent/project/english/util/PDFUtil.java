package com.extent.project.english.util;

import org.apache.log4j.BasicConfigurator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;

/**
 * Created by VietAnh on 1/24/2017.
 */
public class PDFUtil {
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
