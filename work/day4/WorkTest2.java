package work.day4;

import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

/**
 * @ClassName WorkTest2
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/13 14:36
 * @Version 1.0
 */
public class WorkTest2 {

    //1，设计一个方法，实现求任意两个整数范围之间的随机数
    //230 330
    public int getNumberRandom(int number1, int number2) {
        //1 , 2  230 330 660  700  1789  1089  2178
        return (int) ((Math.random() + 1) * (number2 - number1) + (number1 - (number2 - number1)));
    }

    //练习：将一个字符串如”1,2,3,4,5,6”转换成一个整型数组
    public int[] change(String s) {
        char[] chars = s.toCharArray();
        int arrLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!",".equals(String.valueOf(chars[i]))) {
                arrLength++;
            }
        }
        int[] arr = new int[arrLength];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!",".equals(String.valueOf(chars[i]))) {
                String str = String.valueOf(chars[i]);
                int i1 = Integer.parseInt(str);
                if (j < arrLength) {
                    arr[j] = i1;
                    j++;
                }
            }
        }
        return arr;
    }

//   遇到整百年时被10整除要被400整除才是闰年，否则为平年（2000闰年，1900平年，300平年）；遇到非整百年时（如2004，2005），
//    只要被4整除就是闰年，不能被4整除为平年（2004闰年，2005平年）。
//    闰年的2月有29天，平年的2月有28天。
//2，设计一个方法，实现计算任意一年的任意一个月份有几天？
    public int getDays(int year, int month) {
        boolean flag = false;
        int big = 31;
        int nm = 30;
        int two = 28;
        if ((year % 10 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            flag = true;
        }
        if (month > 0 && month <= 12) {
            if (flag) {
                two = 29;
            }
            switch (month) {
                case 11:
                case 9:
                case 6:
                case 4:
                    return nm;
                case 12:
                case 10:
                case 8:
                case 7:
                case 5:
                case 3:
                case 1:
                    return big;
                case 2:
                    return two;
            }
        }
        return 0;
    }

    //3，设计一个方法，实现对字符串的反转功能，比如输入“abc”出来的结果是“cba”，要求至少采用两种方式实现。
    public String getStr(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = 0;
            temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return new String(chars);
    }

    public String getStr2(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i <= s.length() / 2 && j >= s.length() / 2; i++, j--) {
            char temp = 0;
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    //4，设计一个方法，判断一个字符串是否为对称字符串，比如“abcba”，“abba”,要求至少采用两种方式实现。
    public boolean isSym(String s) {
        char[] chars = s.toCharArray();
        int flag = 0;
        for (int i = 0, j = chars.length - 1; i < chars.length && j > chars.length / 2; i++, j--) {
            if (String.valueOf(chars[i]).equals(String.valueOf(chars[j]))) {
                flag++;
            }
        }
        if (chars.length / 2 == flag) {
            return true;
        }
        return false;
    }

    public boolean isSym2(String s) {
        //截取字符串
        StringBuffer stringBuffer = new StringBuffer(s);
        int flag = 0;
        //首位
        for (int i = 0, j = s.length(); i < s.length()/2 && j > s.length()/2; i++, j--) {
            String substring = stringBuffer.substring(i, j);
            char[] chars = substring.toCharArray();
            if (String.valueOf(chars[0]).equals(String.valueOf(chars[chars.length - 1]))) {
                flag++;
            }
        }
        return flag == s.length() / 2;
    }

    //5，判断一个字符串包含大写，小写，数字的个数，比如“AbcD1”,则大写为2，小写为2，数字为1
    public String isNumber(String s) {
        int[] arr = new int[3];
        int b1 = 0, s1 = 0, n1 = 0;
        char[] charsS = s.toCharArray();
        //大写
        String s2 = s.toUpperCase();
        char[] charsS2 = s2.toCharArray();
        for (int i = 0; i < charsS.length; i++) {
            if ((String.valueOf(charsS[i]).equals(String.valueOf(charsS2[i]))) && (charsS[i] < 48 || charsS[i] > 57)) {
                b1++;
            }
        }
        //小写
        String s3 = s.toLowerCase();
        char[] charsS3 = s3.toCharArray();
        for (int i = 0; i < charsS.length; i++) {
            if (String.valueOf(charsS[i]).equals(String.valueOf(charsS3[i])) && (charsS[i] < 48 || charsS[i] > 57)) {
                s1++;
            }
        }
        //数字
        for (int i = 0; i < charsS.length; i++) {
            if (charsS[i] <= 57 && charsS[i] > 47) {
                n1++;
            }
        }
        return "大写为" + b1 + "小写为" + s1 + "数字为" + n1;
    }

    @Test
    public void WorkT() {
        System.out.println(getStr("abcdsa"));
        System.out.println(getStr2("abcdsa"));
    }

    @Test
    public void WorkT2() {
        int numberRandom = getNumberRandom(10, 20);
        System.out.println(numberRandom);
    }

    @Test
    public void WorkT3() {
        int[] change = change("1,2,3,4,5,6");
        System.out.println(Arrays.toString(change));

    }

    @Test
    public void WorkT4() {
        String string = "JDkkkKLNLII99VVjakk9";
        String number = isNumber(string);
        System.out.println(number);
    }

    @Test
    public void Work5() {
        String s = "adabsasbada";
        System.out.println(isSym(s));
        System.out.println(isSym2(s));
    }

    @Test
    public void Work6() {
        System.out.println(getDays(2004, 2));
    }
}
