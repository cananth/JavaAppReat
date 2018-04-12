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
public class UserHistory {
	
	public String date, time, flash;
	public static ResultSet result= null;
	
	public static void store(Request request, User user) throws Exception
	{
		UserHistory userhistory	= new UserHistory();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
	    userhistory.date = df.format(localDate).toString();
		
		ZoneId zoneIdKolkata = ZoneId.of( "Asia/Kolkata" );
		ZonedDateTime zonedDateTimeKolkata = ZonedDateTime.now(zoneIdKolkata );
        userhistory.time = zonedDateTimeKolkata.toString();
        UserHistoryMapper.storeUserHistory(request , user, userhistory);
	}
	
	public static void userHistory(Connection con, UserHistory userhistory, User user) throws Exception
	{
		 UserHistoryMapper.fetchUserHistory(con, userhistory, user);
		
	}
	
	public static void pdf(Connection con, UserHistory userhistory, User user) throws Exception
	{
		String[] header = {"SERIAL NUMBER","TIME","DATE","IP"}; 
		 UserHistoryMapper.fetchUserHistory(con, userhistory, user);
        Document document = new Document();
        int index = 0;
        int content = 1;
        String filename = "history.pdf";
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        Paragraph paragraph1 = new Paragraph("First paragraph");
        Paragraph paragraph2 = new Paragraph("Second paragraph");
       
        
        PdfPTable table = new PdfPTable(4);
        table.addCell("SERIAL NUMBER");
		table.addCell("TIME");
		table.addCell("DATE");
		table.addCell("IP");
		table.setHeaderRows(1);
         while(userhistory.result.next())
         {
			
			table.addCell(""+content);
			table.addCell(userhistory.result.getString("login_time"));
			table.addCell(userhistory.result.getString("date"));
			table.addCell(userhistory.result.getString("ip"));
			content ++;
			
		}
		document.add(paragraph1);
        document.add(paragraph2);
		document.add(table);
        document.close(); 
        
         PdfReader reader = new PdfReader(filename);
        int n = reader.getNumberOfPages();
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream( user.user_name + filename ));
 
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
	
	
	public static void count(Connection con, User user) throws Exception
	{
		UserHistoryMapper.getCount(con, user);
		 while(user.result.next())
		 {
			 user.count = user.result.getInt("count");
		 }
		
	}
	

}
