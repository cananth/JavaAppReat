package models;
import lib.*;
import mappers.*;
import java.util.*;
import java.net.*;
import java.sql.*;
import java.time.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Paragraph; 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
 
public class ProgramHistory {
	
	public String input ="", output = "", useroutput = "", date, ip = "", time,status,flash;
	public static ResultSet result= null;
	
		//public DateTime time = new DateTime(DateTimeZone.forID("Asia/Kolkata"));
	public static void store(Connection con, Program program, ProgramHistory programhistory) throws Exception
	{
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
	    programhistory.date = df.format(localDate).toString();
		
		ZoneId zoneIdKolkata = ZoneId.of( "Asia/Kolkata" );
		ZonedDateTime zonedDateTimeKolkata = ZonedDateTime.now(zoneIdKolkata );
        programhistory.time = zonedDateTimeKolkata.toString();
        ProgramHistoryMapper.programHistory(con, program, programhistory);
	}
	
	public static void history(Connection con, ProgramHistory programhistory, Program program) throws Exception
	{ 
		
		 ProgramHistoryMapper.programHistoryData(con, programhistory, program);
		
	}
	
	public static void pdf(Connection con, Program program) throws Exception
	{
		String[] header = {"SERIAL NUMBER", "PROGRAM NAME","INPUT","OUTPUT","TIME","DATE","IP"}; 
		ProgramHistory programhistory = new ProgramHistory();
		 ProgramHistoryMapper.programHistoryData(con, programhistory, program);
        Document document = new Document();
        int index = 1;
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream("example.pdf"));
        // step 3
        document.open();
        // step 4
        Paragraph paragraph1 = new Paragraph("First paragraph");
        Paragraph paragraph2 = new Paragraph("Second paragraph");
        
        PdfPTable table = new PdfPTable(7);
         while(programhistory.result.next())
         {
			table.addCell(""+index);
			table.addCell("Reverse Word");
			table.addCell(programhistory.result.getString("input"));
			table.addCell(programhistory.result.getString("output"));
			table.addCell(programhistory.result.getString("time"));
			table.addCell(programhistory.result.getString("date"));
			table.addCell(programhistory.result.getString("ip_address"));
			index ++;
			
		}
		document.add(paragraph1);
        document.add(paragraph2);
		document.add(table);
        document.close();
        
        PdfReader reader = new PdfReader("example.pdf");
        int n = reader.getNumberOfPages();
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("example2.pdf"));
        
        Image img = Image.getInstance("assets/images/mahaswami.png");
		
		for(int i = 0; i < n; i++)
		{
			PdfGState gs1 = new PdfGState();
			gs1.setFillOpacity(0.4f);
			PdfContentByte over = stamper.getOverContent(1);
			over.saveState();
			over.setGState(gs1);
			over.addImage(img, 300, 0, 0, 300, 155, 324);
			over.restoreState();
		}
        stamper.close();
        reader.close();
      
	}
	
	public static void count(Connection con, Program program) throws Exception
	{
		ResultSet result = ProgramHistoryMapper.getCount(con, program);
		while(result.next())
		 {
			 program.count = result.getInt("count");
		 }
	}
}
		



