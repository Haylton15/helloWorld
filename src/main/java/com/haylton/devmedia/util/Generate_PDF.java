package com.haylton.devmedia.util;

import com.haylton.devmedia.model.Cliente;
import com.haylton.devmedia.repository.ClienteRepository;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.List;

public class Generate_PDF {
	public static void main(String[] args) throws IOException {
		
		try {
			String file_name="C:\\Users\\Haylton\\teste.pdf";
			
			Document document = new Document();
			
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
			
			document.open();
                        
                        
			Paragraph para = new Paragraph("This is testing from Haylton");
                        document.add(para);
                        document.add(new Paragraph(" "));
                        PdfPTable table = new PdfPTable(3);
                        PdfPCell c1 = new PdfPCell(new Phrase("Heading 1"));
                        table.addCell(c1);
                        
                        c1 = new PdfPCell(new Phrase("Heading 2"));
                        table.addCell(c1);
                        
                        c1 = new PdfPCell(new Phrase("Heading 3"));
                        table.addCell(c1);
                        table.setHeaderRows(1);
                        
                        
                        table.addCell("1.0");
                        table.addCell("1.1");
                        table.addCell("1.2");
                        table.addCell("2.1");
                        table.addCell("2.2");
                        table.addCell("2.3");
                        
                        
			
                        document.add(table);
                        
                        Image image = Image.getInstance("C:\\Users\\Haylton\\bb-logo.png");

                        
                        document.add(image); 
                        
                        
			
			
			System.out.println("finished");
			
			
			document.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		
	}
}
