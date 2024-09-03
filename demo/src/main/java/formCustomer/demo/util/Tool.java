package formCustomer.demo.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class Tool {
  public  static  int  generateRandomNumber(int number){
      Random randomNumber= new Random();
      return randomNumber.nextInt(number);
  }

  public static String generateRandomString(int length){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
      sdf.format(new Date());
      String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
      Random random = new Random();
      StringBuilder sb = new StringBuilder(length);
      for (int i = 0; i < length; i++) {
          int randomIndex = random.nextInt(characters.length());
          sb.append(characters.charAt(randomIndex));
      }
      return sb.toString();
  }
    public static Date getCurrentDate() {
        long millis=System.currentTimeMillis();

        java.sql.Date date=new java.sql.Date(millis);
        // 將日期格式化為字串
        return date;
    }


}
