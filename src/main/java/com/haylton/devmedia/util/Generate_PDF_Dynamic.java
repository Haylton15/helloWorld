package com.haylton.devmedia.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Generate_PDF_Dynamic {

    public static void main(String[] args) throws DocumentException {

        try {
            String file_name = "C:\\Users\\Haylton\\teste_dynamic.pdf";
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(file_name));
            documento.open();

            AcessoJDBC banco = new AcessoJDBC();
            Connection connection = banco.getConnection();

            PreparedStatement ps = null;
            ResultSet rs = null;
            String parametroId = "2";

            String query = "select * from codigos";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            PdfPTable table = new PdfPTable(2);

            PdfPCell c1 = new PdfPCell(new Phrase("ID"));
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Language"));
            table.addCell(c1);

            table.setHeaderRows(1);

            while (rs.next()) {
//                Paragraph para1 = new Paragraph(rs.getString("id"));
//                Paragraph para2 = new Paragraph(rs.getString("language"));
//                para1.setIndentationLeft(20);
//                para2.setIndentationLeft(20);
                
                Paragraph para1 = new Paragraph(rs.getString("id"));
                para1.setIndentationLeft(20);
                Paragraph para2 = new Paragraph(rs.getString("language"));
                para2.setIndentationLeft(20);
                
                PdfPCell rightCell1 = new PdfPCell();
                PdfPCell rightCell2 = new PdfPCell();
                rightCell1.addElement(para1);
                rightCell2.addElement(para2);
                
                table.addCell(rightCell1);
                table.addCell(rightCell2);

                documento.add(new Paragraph(" "));

            }

            documento.add(table);

            documento.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Generate_PDF_Dynamic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Generate_PDF_Dynamic.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
