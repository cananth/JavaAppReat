package lib;
public class Response {
	
   public String data, contentType , header, program_id, user_id, username;
   public int statusCode;
   public byte[] imageContent = "".getBytes();
   public String setCookie(Response response)
   {
	   return "HTTP/1.1 "+response.statusCode+ "OK\r\n Content-type:"+response.contentType+"\r\nSet-Cookie:user_id="+response.user_id+"&program_id="+response.program_id+"&username="+response.username+";Path=/;Expires = Mon, 25th Jan 2018 00:00:00 GMT \r\n\r\n";
   }
   
   
}

