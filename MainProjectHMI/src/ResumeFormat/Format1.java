package ResumeFormat;


import Beans.Models.User;
import GUI.Scenes.OnUserLogInScene;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.lang.*;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format1 {
    User user;

    public Format1(){
        user = OnUserLogInScene.getLoggedInUser();
        Document document = new Document(PageSize.A4);

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        try{
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("Resume"+timeStamp+".pdf"));
            document.open();
            System.out.println("format1 document created");

            Paragraph nameHeader = new Paragraph(user.getFirstName().toUpperCase()+" "+user.getLastName().toUpperCase()+"\n",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
            PdfContentByte canvas = writer.getDirectContent();
            CMYKColor magentaColor = new CMYKColor(1.f, 1.f, 0.f, 0.f);
            canvas.setColorStroke(magentaColor);
            canvas.moveTo(0, 760);
            canvas.lineTo(9000, 760);
            canvas.closePathStroke();
            document.add(nameHeader);
            Paragraph oneLiner = new Paragraph("\n\n"+user.getBio());
            document.add(oneLiner);
                    document.close();
        }catch (Exception e){
            System.out.println("System unable to print doc");
            e.printStackTrace();
        }
    }

}
