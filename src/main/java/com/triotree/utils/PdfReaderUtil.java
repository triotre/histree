package com.triotree.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;

public class PdfReaderUtil {

	WebDriver driver;
	public static String readPDFInURL() throws IOException {
        String output;
        String filePath = System.getProperty("user.dir")+"\\target\\OrderConfirmation.pdf";
        File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		PDDocument document = null;
		try {
			document = PDDocument.load(fis);
			output = new PDFTextStripper().getText(document);
		}finally {
			if (document != null) {
                document.close();
            }
            //fileToParse.close();
            fis.close();
        }
        return output;		
	}
}
