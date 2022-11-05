package day10;

import org.junit.Test;

import java.sql.Date;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName Day10
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/21 15:42
 * @Version 1.0
 */
public class Day10 {
    @Test
    public void testStream() {


//        List<student> list = new ArrayList<>();
//        list.add(new student(1, 22));
//        list.add(new student(2, 223));
//        list.add(new student(3, 225));
//        list.add(new student(4, 224));
//        list.add(new student(5, 2223));
//        list.add(new student(6, 212));
//
//        Stream<student> stream = list.stream();
//        list.stream().filter(s -> s.age > 223).forEach(System.out::println);

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        String format = df.format(new Date());
//        java.sql.Date date = java.sql.Date.valueOf(format);
//        System.out.println(date);

//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = simpleDateFormat.format(new java.util.Date());
//
//        Date date = new Date(new java.util.Date().getTime());
//        System.out.println(date);

//        SimpleDateFormat df =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateString = df.format(new java.util.Date());
//        System.out.println(new java.util.Date(new java.util.Date().getTime()));

        //获取当前回复时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = df.format(new java.util.Date());
        java.util.Date reDate = null;
        java.util.Date date = new java.util.Date();
//        System.out.println(date);
        try {
            reDate =df.parse(dateString);

            Date d1 = new Date(reDate.getTime());

            System.out.println(d1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        System.out.println(reDate);


    }
}

class student {

    public static void time(Date date){
        System.out.println(date);
    }
    int id;
    int age;

    public student(int id, int age) {
        this.id = id;
        this.age = age;
    }
    @Override
    public String toString() {
        return "id"+"="+id;
    }
    public static void getTest(String s,int i,char a,String a1){

    }
}