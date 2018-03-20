package qa.test.lab.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NumbersGenerator {

    public static void main(String[] args){
        System.out.println(NumbersGenerator.randomNumber1To100());

    }

    public static String getCurrentTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String randomNumber1To100(){
        final double max = 100;
        int t = (int) (Math.random() * max);
        return Integer.toString(t);
    }

}
