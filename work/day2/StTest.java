package day2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName StTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/11 16:25
 * @Version 1.0
 */
public class StTest {
    @Test
    public void st() {
        Map<String, work.day2.Student> map = new HashMap<>();

        work.day2.Student student1 = new work.day2.Student("xx", 20, "specialty", 60, 80, 20, "男");
//        System.out.println(student1 + "\t" + average + "\t" + heightSource + "\t" + lowSource + "\t" + sumScores);
        String source = student1.getSource(student1);
        System.out.println(source);
        map.put("1", student1);

        for (Map.Entry<String, work.day2.Student> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue());
        }

    }

}
