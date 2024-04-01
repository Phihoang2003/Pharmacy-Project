package utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExportToPDF {
    public static void exportToPDF(JFrame frame, String outputPath) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(new PDRectangle(930, 800));
            document.addPage(page);

            BufferedImage image = createImage(frame.getContentPane());

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            PDImageXObject pdImage = LosslessFactory.createFromImage(document, image);
            contentStream.drawImage(pdImage, 20, 20);

            contentStream.close();
            document.save(outputPath);
            document.close();

            Desktop.getDesktop().open(new File(outputPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage createImage(Component component) {
        Dimension size = component.getSize();
        BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        component.paint(g);
        return image;
    }
}
